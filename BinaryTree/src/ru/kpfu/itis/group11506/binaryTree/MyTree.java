package ru.kpfu.itis.group11506.binaryTree;

public class MyTree<T extends Comparable<T>> implements BinaryTree<T>{

    private Node<T> startNode;

    public MyTree() {
        startNode = null;
    }


    @Override
    public boolean add(T value) {
        Node<T> addNode = null;
        for (Node<T> i = startNode; i != null; i = value.compareTo(i.value) < 0 ? i.left : i.right) {
            addNode = i;
        }

        Node<T> newNode = new Node<>(value);
        if (addNode == null) {
            startNode = newNode;
            return true;
        } else {
            if (value.compareTo(addNode.value) < 0) {
                addNode.left = newNode;
            } else {
                addNode.right = newNode;
            }
            return true;
        }
    }

    @Override
    public void delete(T value) {
        Node<T> i = startNode;
        Node<T> delNode = null;
        while (i != null) {
            if (value.compareTo(i.value) == 0) {
                break;
            } else {
                delNode = i;
                if (value.compareTo(i.value) < 0) {
                    i = i.left;
                } else {
                    i = i.right;
                }
            }
        }
        if (i == null) {
            return;
        }
        if (i.right == null) {
            if (delNode == null) {
                startNode = i.left;
            } else {
                if (i == delNode.left) {
                    delNode.left = i.left;
                } else {
                    delNode.right = i.left;
                }
            }
        } else {
            Node<T> leftMost = i.right;
            delNode = null;
            while (leftMost.left != null) {
                delNode = leftMost;
                leftMost = leftMost.left;
            }
            if (delNode != null) {
                delNode.left = leftMost.right;
            } else {
                i.right = leftMost.right;
            }
            i.value = leftMost.value;
        }
    }

    @Override
    public T get(T value) {
        Node<T> i = startNode;
        while (i != null) {
            if (value.compareTo(i.value) == 0) {
                return i.value;
            }
            if (value.compareTo(i.value) < 0) {
                i = i.left;
            } else {
                i = i.right;
            }
        }
        if (i==null){
            System.out.println("Elements was not found");
        }
        return null;
    }

    @Override
    public boolean contains(T value) {
        for (Node<T> i = startNode; i != null; i = value.compareTo(i.value) < 0 ? i.left : i.right) {
            if (value.equals(i.value))
                return true;
        }
        return false;
    }
}
