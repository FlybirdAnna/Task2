package Task2;
import java.util.Collection;

public class MyList<T> {
    private Object[] data;
    private int size;

    public MyList() {
        data = new Object[10];
        size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        data[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        return (T) data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
    }

    public void addAll(Collection<? extends T> collection) {
        for (T item : collection) {
            add(item);
        }
    }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }
}