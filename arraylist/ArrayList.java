package arraylist;

public class ArrayList<T> {
    
    private Object[] array;
    private int capacity;
    private int size;

    public ArrayList() {
        size = 0;
        capacity = 2;
        array = new Object[capacity];
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        @SuppressWarnings("unchecked")
        final T t = (T) array[index];
        return t;
    }

    public void add(T data) {
        if (size == capacity) grow();
        array[size] = data;
        size++;
    }

    private void grow() {
        Object[] array2 = new Object[capacity*2];
        for (int i = 0; i < capacity; i++) array2[i] = array[i];
        array = array2;
        capacity *= 2;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        T t = get(index);
        for (int i = index; i < size - 1; i++) array[i] = array[i+1];
        size--;
        if (size < capacity/2) shrink();
        return t;
    }

    private void shrink() {
        Object[] array2 = new Object[capacity/2];
        for (int i = 0; i < capacity/2; i++) array2[i] = array[i];
        array = array2;
        capacity /= 2;
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }
}