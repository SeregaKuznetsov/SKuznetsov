package ru.kpfu.itis.group11506.binaryTree;

public interface BinaryTree<T extends Comparable> {
    boolean add(T value);
    void delete(T value);
    T get(T value);
    boolean contains(T value);
}
