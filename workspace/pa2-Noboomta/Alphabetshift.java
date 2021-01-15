import java.util.ArrayList;

/**
 * Unicode Class of Cipher. to change the data in only alphabet.
 */
public class Alphabetshift implements Cipher {

    /**
     * Encrypt the data to be increase key to the unicode in only Alphabet and have to Alphabet.
     *
     * @param data String of data.
     * @param key  Key to be increase in unit code.
     * @return Char array.
     */
    @Override
    public char[] encrypt(char[] data, int key) {
        if (key < 0) {
            return decrypt(data, key * -1);
        }
        ArrayList<Character> newData = new ArrayList<Character>();
        for (int i = 0; i < data.length; i++) {
            int uni = (int) data[i];
            int newu = uni + key;
            if ((uni >= 65 && uni <= 90) || (uni >= 97 && uni <= 122)) {
                if (newu < 65 || (newu > 90 && newu < 97) || newu > 122) {
                    newData.add((char) (newu - 26));
                } else
                    newData.add((char) (newu));
            } else {
                newData.add(data[i]);
            }
        }
        char[] ansData = new char[newData.size()];
        for (int i = 0; i < newData.size(); i++) {
            ansData[i] = newData.get(i);
        }

        return ansData;
    }

    /**
     * Encrypt the data to be decrease key to the unicode in only Alphabet and have to Alphabet.
     *
     * @param data String of data.
     * @param key  Key to be decrease in unit code.
     * @return Char array.
     */
    @Override
    public char[] decrypt(char[] data, int key) {
        if (key < 0) {
            return encrypt(data, key * -1);
        }
        ArrayList<Character> newData = new ArrayList<Character>();
        for (int i = 0; i < data.length; i++) {
            int uni = (int) data[i];
            int newu = uni - key;
            if ((uni >= 65 && uni <= 90) || (uni >= 97 && uni <= 122)) {
                if (newu < 65 || (newu > 90 && newu < 97) || newu > 122) {
                    newData.add((char) (newu + 26));
                } else
                    newData.add((char) (newu));
            } else {
                newData.add(data[i]);
            }
        }
        char[] ansData = new char[newData.size()];
        for (int i = 0; i < newData.size(); i++) {
            ansData[i] = newData.get(i);
        }

        return ansData;
    }
}