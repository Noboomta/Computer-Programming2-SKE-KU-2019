import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.BufferedReader;

public class WordCounts {
    /**
     * Print a help message and exit.
     */
    private static void usage() {
        String name = CopyFile.class.getName();
        System.out.printf("Usage: java %s source\n", name);
        System.exit(0);
    }

    /**
     * Method to count the word, line, char.
     * 
     * @param source source file for count.
     */
    private static void wordcount(String source) {
        File file1 = new File(source);
        try (BufferedReader buffRead = new BufferedReader(new FileReader(file1))){
            String[] words = null;
            int wordAt = 0;
            int lineAt = 0;
            int charAt = 0;
            String str;

            while ((str = buffRead.readLine()) != null) {
                lineAt += 1;
                // not empty
                if (!str.isEmpty()) {
                    charAt += str.length()+1;
                    words = str.split("\\s+");
                    for(String w: words){
                        if(!w.isEmpty()){
                            wordAt++;
                        }
                    }
                }
                else{
                    charAt++;
                }
            }
            
            System.out.printf("%d %d %d %s", lineAt, wordAt, charAt, source + "\n");
        }catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        }catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }

    /**
     * Run the wordCount Main.
     * 
     * @param args name of file for count.
     */
    public static void main(String[] args) {
        if (args.length != 1)
            usage();

        wordcount(args[0]);
    }
}