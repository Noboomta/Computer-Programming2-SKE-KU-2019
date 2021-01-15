public interface Cipher {
    char[] encrypt(char[] data, int key);
    char[] decrypt(char[] data, int key);
}
