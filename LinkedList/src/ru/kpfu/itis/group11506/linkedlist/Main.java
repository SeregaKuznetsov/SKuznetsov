package ru.kpfu.itis.group11506.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedNodes<Boolean> list = new LinkedNodes<Boolean>();
        CycleDetermination cycleDetermination = new CycleDetermination();

        list.init();

        list.addLastNode(true);
        list.addLastNode(true);
        list.addLastNode(true);
        list.addLastNode(true);
        list.addLastNode(true);

        boolean hasCycle = cycleDetermination.hasCycle(list);

        list.addLastNode(list.getStartNode());

        boolean hasCycleAfterAdding = cycleDetermination.hasCycle(list);

        System.out.println("Number of nodes - " + list.getNumberOfNodes());
        list.removeLastNode();
        System.out.println("Number of nodes after remove - " + list.getNumberOfNodes());
        System.out.println("Before create cycle - " + hasCycle);
        System.out.println("After create cycle - " + hasCycleAfterAdding);
    }
}