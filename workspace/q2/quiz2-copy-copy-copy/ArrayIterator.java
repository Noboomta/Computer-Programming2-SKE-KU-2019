 

import java.util.Iterator;
import java.util.NoSuchElementException;

//TODO write good Javadoc
public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int cursor = 0;
    private int len = 0;

    /**
     * Initialize a new array iterator with the array to process.
     *
     * @param array is the array to iterate over
     */
    public ArrayIterator(T[] array) {
        this.array = array;
        this.len = array.length;
    }

    /**
     * @see java.util.Iterator#next()
     */
    @Override
    public T next() {
        if(cursor<len && hasNext()){
            return array[cursor++];
        }
        throw new NoSuchElementException("No more elements"); 
    }

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

    public static void main(String[] args) {
        String[] array = { "apple", "banana", null, "carrot", null };
        ArrayIterator<String> iter = new ArrayIterator<>(array);
        System.out.println((iter.next( )));
        System.out.println((iter.hasNext( )));
        System.out.println((iter.hasNext( )));
        System.out.println((iter.next( )));
        System.out.println((iter.next( )));
        System.out.println((iter.hasNext( )));
        System.out.println((iter.next( )));
    }
}
