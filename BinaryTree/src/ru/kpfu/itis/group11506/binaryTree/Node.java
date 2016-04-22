package ru.kpfu.itis.group11506.binaryTree;

public class Node<T> {

    public Node(T value) {
        this.value = value;
    }

    T value;
    Node<T> left;
    Node<T> right;
}
