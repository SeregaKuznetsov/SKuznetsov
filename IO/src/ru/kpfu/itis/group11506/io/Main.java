package ru.kpfu.itis.group11506.io;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        writeFile();
        readAndEditFile();
        readEditFile();
    }


    private static void writeFile() {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Projects\\SKuznetsov\\IO\\src\\ru\\kpfu\\itis\\group11506\\io/out.bin.txt"))) {
            for (int i = 0; i < 100; i++) {
                int rndNumber = (int) (Math.random() * 100);
                System.out.println("Created Numbers" + i + " : " + rndNumber);
                dos.writeInt(rndNumber);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    private static void readAndEditFile() {
        int num = 0;
        byte[] buffer = new byte[200];
        for (int i = 0; i < buffer.length; i++) {
            try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Projects\\SKuznetsov\\IO\\src\\ru\\kpfu\\itis\\group11506\\io/out.bin.txt")))) {
                while (dis.available() != 0) {
                    System.out.println("\nRead numbers: " + i + " - " + num);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (num % 2 == 1) {
                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Projects\\SKuznetsov\\IO\\src\\ru\\kpfu\\itis\\group11506\\io/in.bin.txt"))) {
                    dos.writeInt(num);
                    System.out.println("\nRead numbers after edit: " + num);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readEditFile() {
        System.out.println("\nFile after edit:");
        try(DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Projects\\SKuznetsov\\IO\\src\\ru\\kpfu\\itis\\group11506\\io/in.bin.txt"))){
            for (int i = 0; i < 100; i++) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
