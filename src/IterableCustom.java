import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Reviewed by Soheil Jahangiri and Reza Moein
 * Project Still has no name and it's untitled. change it. //finish
 * Reconsider to not send your code with build/out folder in it.
 * Reconsider to not send your .idea folder (this is related to your environment)
 *
 * @param <T>
 */
public class IterableCustom<T> implements Iterable<T> {
    private Object[] items;
    private int size;

    //create constructor by default
    public IterableCustom() {
        this(10);
    }

    //create constructor
    public IterableCustom(int capacity) {
        if (capacity <= 0) {
            throw new IllegalStateException("Capacity must be positive");
        }
        items = new Object[capacity];
        size = 0;
    }

    //add
    public void add(T item) {
        if (size == items.length) {
            resize();
        }
        items[size++] = item;
    }

    //resize
    private void resize() {
        //This is a default
        Object[] temp = new Object[items.length * 2];
        // TODO: why using for over System.arraycopy ?
        // Answer: It is usually faster to copy presentations because this optimized operation is performed at a lower level
        System.arraycopy(items, 0, temp, 0, this.items.length);
        items = temp;
    }

    /**
     * Imagine Java compiler is not smart enough to make your code branch-less.
     * with that in mind, How can you make this code branch-less?
     * or make it simplified.
     */
    //finish

    // remove by value
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }

        //create new array small size
        Object[] newItem = new Object[items.length - 1];
        //copy all with for loop
        for (int i = 0, j = 0; i < size; i++){
            if (i == index) continue;
            newItem[j++] = items[i];
        }
            //update items and size
            items = newItem;
        size--;
    }

    public void remove(String item) {
        // TODO unnecessary twice invocation of method "indexOfRange(item)"
        // finish
        int index = indexOfRange(item);
        if (index >= 0) {
            remove(index);
            System.out.println("Removed " + item);
        } else {
            System.out.println("Index out of bounds");
        }
    }

    //find index value
    private int indexOfRange(Object o) {
        // TODO:(From Soheil) what is this block of code doing?
        //find index for remove by String value
        // TODO:(From Reza) Try to refactor this part as a one loop
        // finish
        for (int i = 0; i < items.length; i++) {
            if (o != null && o.equals(items[i])) {
                return i;
            }
        }
        return -1;
    }

    //size
    public int size() {
        return size;
    }

    //Get
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
        return (T) items[index];

    }

    // /////////////////////////////////////////////////
    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T> {
        int cursor = 0;       // index of next element to return
        int lastRet = -1;     // index of last element returned; -1 if no such

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            // TODO better to use try catch only for get(i) method not for entire block
            // finish
            int i = cursor;
            T next;
            try {
                next = get(i);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException(e);
            }
            lastRet = i;
            cursor = i + 1;
            return next;
        }

        @Override
        public void remove() {
            // TODO: why using try catch here? when you are not going to throw any exception in "remove" operation?
            // finish
            IterableCustom.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }
}