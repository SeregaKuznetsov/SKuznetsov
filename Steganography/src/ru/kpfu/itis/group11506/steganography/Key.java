package ru.kpfu.itis.group11506.steganography;

import java.util.Scanner;

public class Key {

    private int sizeOfMessage;
    private String message;
    private int text[];

    public Key() {
        writeMessage();
    }

    private void writeMessage() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the secret text");
        message = in.nextLine();
        sizeOfMessage = message.length() * 8;
        text = new int[message.length()];
        for (int i = 0; i < text.length; i++) {
            text[i] = (int) message.charAt(i);
        }
    }

    public String[] getBinaryText() {
        String[] txt = new String[text.length];
        for (int i = 0; i < text.length; i++) {
            txt[i] = toBinaryShow(text[i]);
        }
        return txt;
    }

    /*public byte [] getByteText() {
        byte [] txt = new byte[text.length];
        for (int i = 0; i < text.length; i++) {
            txt[i] = (byte)text[i];
        }
        return txt;
    }*/

    /*public void showMessage() {
        for (int i = 0; i < text.length; i++) {
            System.out.println(message.charAt(i) + " " + text[i] + " " + toBin(text[i]));
        }
    }*/

    public int getSizeOfMessage() {
        return sizeOfMessage;
    }

    /*private int toBin(int i) {
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.insert(0, i & 1);
            i >>= 1;
        }
        if (sb.length() == 0) sb.append("0");
        return Integer.parseInt(sb.toString());
    }*/

    private String toBinaryShow(int i) {
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.insert(0, i & 1);
            i >>= 1;
        }
        if (sb.length() == 0) sb.append("0");
        while (sb.length() != 8) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
