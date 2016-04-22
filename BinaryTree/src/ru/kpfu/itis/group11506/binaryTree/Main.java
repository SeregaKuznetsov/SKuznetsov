package ru.kpfu.itis.group11506.binaryTree;

public class Main {
    public static void main(String[] args) {
        MyTree<Integer> tree = new MyTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(4);
        tree.add(2);
        tree.delete(4);
        System.out.println(tree.contains(4));
        System.out.println(tree.get(6));

    }
}
