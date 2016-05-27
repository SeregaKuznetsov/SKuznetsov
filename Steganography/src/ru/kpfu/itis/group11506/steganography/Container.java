package ru.kpfu.itis.group11506.steganography;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Container {

    private byte [] imageInByte;
    private int availableSpace;
    private BufferedImage img;

    public Container(File file) {
        readPixels(file);
        showPixelArray();
    }

    public int getAvailableSpace() {
        return availableSpace;
    }


    private void readPixels(File file) {
        try {
            img = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "bmp", baos);
            imageInByte = baos.toByteArray();
            baos.flush();
            baos.close();
        } catch (IOException e) {
            //TODO
        }

        availableSpace = img.getWidth() * img.getHeight() * 2 * 3;
    }

    public void showPixelArray () {
        for (int i = 0; i < imageInByte.length; i++) {
            System.out.println(i + " - " + imageInByte[i]);
        }
    }

    public byte [] getBytePixelArray () {
        return imageInByte;
    }

    private String toBinaryShow(int i) {
        StringBuilder sb = new StringBuilder(Integer.toString(i));
        while (sb.length() != 8) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
