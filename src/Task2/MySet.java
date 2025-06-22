package Task2;

import java.util.LinkedList;

public class MySet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<T>[] buckets;

    @SuppressWarnings("unchecked")
    public MySet() {
        buckets = (LinkedList<T>[]) new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(T value) {
        return (value.hashCode() & 0x7FFFFFFF) % buckets.length;
    }


    public boolean add(T value) {
        int index = getBucketIndex(value);
        if (!buckets[index].contains(value)) {
            buckets[index].add(value);
            return true;
        }
        return false;
    }


    public boolean delete(T value) {
        int index = getBucketIndex(value);
        return buckets[index].remove(value);
    }
}