package ru.kpfu.itis.group11506.linkedStack;

import java.util.Iterator;

class LinkedStack<T> implements Stack<T> {
    Node<T> startNode;
    int size = 0;

    public LinkedStack() {
        init();
    }

    private void init() {
        startNode = null;
    }

    public int size() {
        return size;
    }


    // checked list by having elements
    @Override
    public boolean empty() {
        return size == 0;
    }

    // add a new element on the top of stack
    @Override
    public void push(T element) {
        Node<T> newNode = new Node<T>();
        if (startNode == null) {
            startNode = newNode;
            startNode.setValue(element);
        } else {
            newNode.setNextNode(startNode);
            startNode = newNode;
            startNode.setValue(element);
        }
        size++;
    }

    // return value of last node and delete his
    @Override
    public T pop() {
        if (startNode == null) {
            throw new NullPointerException("List is empty");
        }
        T tmp = startNode.getValue();
        startNode = startNode.getNextNode();
        size--;
        return tmp;
    }

    // return value of last node
    @Override
    public T peek() {
        if (startNode == null)
            throw new NullPointerException("List is empty");
        return startNode.getValue();
    }

    // iterator
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> cursorNode = startNode;
            Node<T> tmp;

            @Override
            public boolean hasNext() {
                return cursorNode != null;
            }

            @Override
            public T next() {
                tmp = cursorNode;
                cursorNode = cursorNode.getNextNode();
                return tmp.getValue();
            }
        };
    }


}