package ru.kpfu.itis.group11506.linkedStack;

public interface Stack<T> extends Iterable<T> {

    public void push(T lastElement);

    public T pop();

    public T peek();

    public int size();

    public boolean empty();
}