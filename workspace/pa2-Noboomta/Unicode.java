import java.util.ArrayList;

/**
 * Unicode Class of Cipher. to change the data in every char.
 */
public class Unicode implements Cipher {

    /**
     * Encrypt the data to be increase key to the unicode in every unit.
     * @param data String of data.
     * @param key Key to be increase in unit code.
     * @return Char array.
     */
    @Override
    public char[] encrypt(char[] data, int key) {
        ArrayList<Character> newData = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            int uni = (int) data[i];
            newData.add((char) (uni + key));
        }
        char[] ansData = new char[newData.size()];
        for (int i = 0; i < newData.size(); i++) {
            ansData[i] = newData.get(i);
        }
        return ansData;
    }

    /**
     * Encrypt the data to be decrease key to the unicode in every unit.
     * @param data String of data.
     * @param key Key to be decrease in unit code.
     * @return Char array.
     */
    @Override
    public char[] decrypt(char[] data, int key) {
        ArrayList<Character> newData = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            int uni = (int) data[i];
            newData.add((char) (uni - key));
        }
        char[] ansData = new char[newData.size()];
        for (int i = 0; i < newData.size(); i++) {
            ansData[i] = newData.get(i);
        }
        return ansData;
    }
}