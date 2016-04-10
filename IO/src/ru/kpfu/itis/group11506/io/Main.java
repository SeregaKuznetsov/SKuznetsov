package ru.kpfu.itis.group11506.io;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        writeFile();
        readAndEditFile();
        readEditFile();
    }


    private static void writeFile() {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("./IO/src/ru/kpfu/itis/group11506/io/in.bin"))) {
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
        int num;
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("./IO/src/ru/kpfu/itis/group11506/io/out.bin"));
                 DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("./IO/src/ru/kpfu/itis/group11506/io/in.bin")))) {
                while (dis.available() != 0) {
                    num = dis.readInt();
                    System.out.println("\nRead numbers: " + num);
                    if (num % 2 == 1) {
                        dos.writeInt(num);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private static void readEditFile() {
        System.out.println("\nFile after edit:");
        try(DataInputStream dis = new DataInputStream(new FileInputStream("./IO/src/ru/kpfu/itis/group11506/io/out.bin"))){
            while (dis.available() != 0) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
