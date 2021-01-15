import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Compare {

    /**
     * Print a help message and exit.
     */
    private static void usage() {
        String name = CopyFile.class.getName();
        System.out.printf("Usage: java %s source1 source2\n", name);
        System.exit(0);
    }

    /**
	 * Print an error message and exit with exit code 1.
	 * @param message the error text to print
	 */
    private static void error(String message) {
        System.out.println(message);
        System.exit(1);
    }

    /**
     * Method to compare 2 files.
     * @param source1 File1 name
     * @param source2 File2 name
     */
    private static void comparefile(String source1, String source2) {

        File fileA = new File(source1);
        File fileB = new File(source2);

        if (!fileA.exists() || !fileA.isFile()) {
            error(source1 + " does not exist or is not a regular file.");
            System.exit(0);
        }
        if (!fileA.canRead()) {
            error(source1 + " is not readable");
            System.exit(0);
        }

        if (!fileB.exists() || !fileB.isFile()) {
            error(source2 + " does not exist or is not a regular file.");
            System.exit(0);
        }
        if (!fileB.canRead()) {
            error(source2 + " is not readable");
            System.exit(0);
        }

        try(InputStream a = new FileInputStream(fileA); InputStream b = new FileInputStream(fileB)){
            int byteAt = 0;
            int lenBuff = 1024;
            byte[] buff1 = new byte[lenBuff];
            byte[] buff2 = new byte[lenBuff];

            while(a.read(buff1) >= 0 && b.read(buff2) >= 0 ){
                if(Arrays.equals(buff1, buff2)){
                    byteAt+=lenBuff;
                }
            }

            for(int i=0; i<lenBuff; i++){
                if (buff1[i] != buff2[i]) {
                    if (byteAt >= fileA.length()) {
                        error("EOF " + source1 + " after byte " + byteAt);
                        System.exit(1);
                    }
                    if (byteAt >= fileB.length()) {
                        error("EOF " + source2 + " after byte " + byteAt);
                        System.exit(1);
                    }
                    error("Differ at byte " + byteAt);
                }
                byteAt++;
            }

            System.out.println("Same");
            System.exit(1);

        }catch(FileNotFoundException f){
            error(f.getMessage());
        }catch(IOException i){
            error(i.getMessage());
        }
        
    }

    public static void main(String[] args) {
        if (args.length != 2)
            usage();
        comparefile(args[0], args[1]);
    }
}