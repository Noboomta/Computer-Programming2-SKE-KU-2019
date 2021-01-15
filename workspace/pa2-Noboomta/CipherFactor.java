/**
 * Factort class to return the type of Cipher.
 * @author NoBoomTa
 */
public class CipherFactor {
    /**
     * Method to return the type of Cipher.
     * @param alg algorithm.
     * @return Cipher.
     */
    public static Cipher getCipher(String alg) {
        if (alg == null) {
            return null;
        }
        if (alg.equalsIgnoreCase("shift")) {
            return new Alphabetshift();
        } else if (alg.equalsIgnoreCase("unicode")) {
            return new Unicode();
        } else return null;
    }
}