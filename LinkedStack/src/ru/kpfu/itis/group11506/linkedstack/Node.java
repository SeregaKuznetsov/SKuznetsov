package ru.kpfu.itis.group11506.linkedStack;

public class Node<T> {

    private Node<T> nextNode;
    private T value;

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}