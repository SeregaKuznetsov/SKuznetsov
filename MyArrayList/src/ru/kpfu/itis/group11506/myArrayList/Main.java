package ru.kpfu.itis.group11506.myArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new MyArrayList<Integer>(10);

        System.out.println("size before add: " + list.size());
        for (int i = 0; i < 100000; i++){
            list.add(i);
        }
        System.out.println("size after add: " + list.size());
        System.out.println("value: " + list.get(156));
        list.remove(15);
        list.remove(798);
        list.remove(4952);
        System.out.println("size after remove (3 elements): " + list.size());
        System.out.println("replacement: " + list.set(156, 17984012));
        System.out.println("which index the new element: " + list.indexOf(17984012));
        System.out.println("what value for this index: " + list.get(156));
        System.out.println("index: " + list.indexOf(89));
        System.out.println("add new element with shift: ");
        list.add(564, 95712);
        System.out.println("what value: " + list.get(564));
        System.out.println("final size: " + list.size());
    }
}
