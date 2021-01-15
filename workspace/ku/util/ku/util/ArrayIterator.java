package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class name ArrayIterator to check, return the element in array, have 2 Methods.
 * @param <T> any Object.
 */
public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int cursor = 0;
    private int len = 0;

    /**
     * Initialize a new array iterator with the array to process.
     *
     * @param array is the array to iterate over
     * @param len is the length of array.
     */
    public ArrayIterator(T[] array) {
        this.array = array;
        this.len = array.length;
    }

    /**int
     * Method to return the next element in Array.
     * @return the next element in the array.
     */
    @Override
    public T next() {
        if (cursor < len && hasNext()) {
            return array[cursor++];
        }
        throw new NoSuchElementException("No more elements");
    }

    /**
     * Method to check if the Array have more element except null.
     * @return the boolean of if they have next element.
     */
    @Override
    public boolean hasNext() {
        for (int i = cursor; i < len; i++) {
            if (array[i] == null) {
                continue;
            } else {
                cursor = i;
                return true;
            }
        }
        return false;
    }
}