import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Crypt class to manage data to be Decrypted or Encrypted iin the kind of file or String.
 */
public class Crypt {

    /**
     * Print a help message and exit.
     */
    private static void usage() {
        String name = Crypt.class.getName();
        System.out.printf("Usage: java %s -mode (enc/dec) -alg (shift/unicode) -key (key)\n", name);
        System.exit(0);
    }

    /**
     * Print an error message and exit with exit code 1.
     *
     * @param message the error text to print
     */
    private static void error(String message) {
        System.out.println(message);
        System.exit(1);
    }

    /**
     * Main method of the class to use for senf to another class and return the result back.
     *
     * @param args To keep the information to be use in the method.
     */
    public static void main(String[] args) {

        String mode = "enc";
        int key = 0;
        String in = "";
        String out = "";
        String data = "";
        Cipher cipher = null;

        for (int i = 0; i < args.length; i++) {
            String word = args[i];

            if (word.equalsIgnoreCase("-mode")) {
                mode = args[i + 1];
            } else if (word.equalsIgnoreCase("-alg")) {
                cipher = CipherFactor.getCipher(args[i+1]);
            } else if (word.equalsIgnoreCase("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (word.equalsIgnoreCase("-data")) {
                data = args[i + 1];
            } else if (word.equalsIgnoreCase("-in")) {
                in = args[i + 1];
            } else if (word.equalsIgnoreCase("-out")) {
                out = args[i + 1];
            }
        }

        if (data.equalsIgnoreCase("")) {

            try (BufferedReader buff = new BufferedReader(new FileReader(new File(in)));) {
                while (true) {
                    String cc = buff.readLine();
                    if (cc == null)
                        break;
                    data += cc;
                }
            } catch (FileNotFoundException f) {
                error(f.getMessage());
            } catch (IOException i) {
                error(i.getMessage());
            }

        }

        char[] dataChar = data.toCharArray();
        String ans = "";

        if (cipher != null && mode.equalsIgnoreCase("enc")) {
            ans = new String(cipher.encrypt(dataChar, key));
        } else if (cipher != null && mode.equalsIgnoreCase("dec")) {
            ans = new String(cipher.decrypt(dataChar, key));
        }

        if (!out.equalsIgnoreCase("")) {
            try {
                File outFile = new File(out);
                if (outFile.createNewFile()) {
                    System.out.println("File created: " + outFile.getName());
                } else {
                    System.out.println("File already exists.");
                }

                FileWriter myWriter = new FileWriter(out);
                myWriter.write(ans);
                myWriter.close();

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.println(ans);
        }
    }
}