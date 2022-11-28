package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        expand();

        int hashCodeKey = hash(Objects.hashCode(key));
        int index = indexFor(hashCodeKey);

        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            result = true;
            count++;
            modCount++;
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash % (table.length - 1);
    }

    private void expand() {
        if (count == (capacity * LOAD_FACTOR)) {
            capacity *= 2;
            table = Arrays.copyOf(table, capacity);
        }
    }

    @Override
    public V get(K key) {
        V result = null;

        int hashCodeKey = hash(Objects.hashCode(key));
        int index = indexFor(hashCodeKey);

        if (table[index] != null) {
            int hashCodeKey2 = hash(Objects.hashCode(table[index].key));
            if (hashCodeKey == hashCodeKey2) {
                if (Objects.equals(key, table[index].key)) {
                    result = table[index].value;
                }
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        if (get(key) != null) {
            int hashCodeKey = hash(Objects.hashCode(key));
            int index = indexFor(hashCodeKey);
            table[index] = null;
            result = true;
            count--;
            modCount++;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (point < table.length && table[point] == null) {
                    point++;
                }
                return point < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                K key = table[point].key;
                point++;
                return key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}