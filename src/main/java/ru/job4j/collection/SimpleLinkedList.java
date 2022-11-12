package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private int modCount;
    private int size;

    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.date = element;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        if (first == null) {
            Node<E> newNode = new Node<E>(value, null);
            first = newNode;
            last = newNode;
        } else {
            Node<E> newNode = new Node<E>(value, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = first;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.date;
                current = current.next;
                return data;
            }
        };
    }
}