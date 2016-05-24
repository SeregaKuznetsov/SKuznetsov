package ru.kpfu.itis.group11506.steganography;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Projects\\pic.bmp");
        Container container = new Container(file);
        Key key = new Key();
        ToLSB toLSB = new ToLSB();

        toLSB.LSB(container, key);
    }
}

