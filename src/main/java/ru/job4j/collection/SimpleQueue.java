package ru.job4j.collection;

public class SimpleQueue<T> {

    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        return in.pop();
    }

    public void push(T value) {
        if (in.isEmpty()) {
            in.push(value);
            return;
        }
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        in.push(value);
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
    }
}