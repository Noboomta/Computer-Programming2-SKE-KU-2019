package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for array iteration any type of element.
 * @author Bhatara Chaemchan SKE17
 */
public class ArrayIterator<T> implements Iterator<T> {

     /** attribute of the array for iterate */
     private T[] array;

     /** The position of element in array */
     private int cursor = 0;

     /**
     * Initialize a new array iterator with the array to process.
     * @param array is the array to iterate over.
     */
     public ArrayIterator(T[] array) { this.array = array; }


     /**
      * retrun non-null element from array.
      * @return the next non-null element in array.
      * @throws NoSuchElementException if there are no more element for return.
      */
     @Override
     public T next() {
      if(hasNext() && cursor < array.length){
       return array[cursor++];
      }
      throw new NoSuchElementException("No more element");
     }

     /**
      * Check has a next element in array or not.
      * @return true if next element in array is non-null, false otherwise.
      */
     @Override
     public boolean hasNext(){
      for(int i = cursor; i < array.length; i++){
       if(array[i] != null) {
        cursor = i;
        return true;
         }
      }
      return false;
     }

      @Override
      public void remove() { }

}