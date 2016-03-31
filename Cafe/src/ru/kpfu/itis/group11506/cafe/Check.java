package ru.kpfu.itis.group11506.cafe;

public class Check {
    public static void printCheck() {
        System.out.println("---------------------");
        System.out.println("Your dishes:");
        for (int i = 0; i < User.order.length() && User.order.charAt(i) != '0'; i++) {
            System.out.println(i+1 + ". " + Menu.menu[Character.getNumericValue(User.order.charAt(i))-1]);
        }
        System.out.println("Thanks for visit!");
        System.out.println("---------------------");
        System.out.println("Personal information:");
        System.out.println("Name: " + User.name);
        System.out.println("Number: " + User.phoneNumber);
        System.out.println("Address: " + User.address);
        System.out.println("Card: " + User.card);
    }
}
