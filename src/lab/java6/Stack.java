package lab.java6;

import java.util.NoSuchElementException;

public class Stack<T> {
    private final T[] data;
    private int size;

    public Stack (int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size < data.length) {
            data[size] = element;
            size++;
        } else {
            throw new StackOverflowError("Stack is full");
        }
    }

    public void pop() {
        if (size > 0) {
            size--;
            data[size] = null;
        } else {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    public T peek() {
        if (size > 0) {
            return data[size - 1];
        } else {
            throw new NoSuchElementException("Stack is empty");
        }
    }
}
