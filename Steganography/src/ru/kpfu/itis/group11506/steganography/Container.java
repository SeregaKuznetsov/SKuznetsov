package ru.kpfu.itis.group11506.steganography;

import javax.imageio.ImageIO;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class Container {
    private int [][][] pixelArr;
    private Raster r;
    private int availableSpace;

    public Container(File file) {
        readPixels(file);
        showPixelArray(pixelArr);
    }

    /*private void writeByteArr() {
        for (int z = 0; z < 3; z++) {
            System.out.println();
            for (int i = 0; i < pixelArr.length; i++) {
                for (int j = 0; j < pixelArr[i].length; j++) {
                    bytePixelsArr[i][j][z] = (byte)pixelArr[i][j][z];
                }
                System.out.println();
            }
        }
    }*/

    public int getAvailableSpace() {
        return availableSpace;
    }


    /*private void getBinaryPixels() {
        for (int z = 0; z < 3; z++) {
            for(int i=0; i < pixelArr.length; i++) {
                for(int j=0; j < pixelArr[i].length; j++) {
                    pixelArr[i][j][z] = toBin(pixelArr[i][j][z]);
                }
            }
        }
    }*/

    private void readPixels(File file) {
        try {
            r = ImageIO.read(file).getRaster();
            pixelArr = new int[r.getWidth()][r.getHeight()][3];
            for(int i=0; i < r.getWidth(); i++) {
                for(int j=0; j < r.getHeight(); j++) {
                    pixelArr[i][j]=r.getPixel(i, j, new int [r.getWidth() * r.getHeight()]);
                }
            }
        } catch (IOException e) {
            //TODO
        }
        availableSpace = r.getWidth() * r.getHeight() * 2 * 3;
    }

    public void showPixelArray (int [][][] array) {
        for (int z = 0; z < 3; z++) {
            System.out.println();
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j][z] + " ");
                }
                System.out.println();
            }
        }
    }

    public void showPixelArray () {
        for (int z = 0; z < 3; z++) {
            System.out.println();
            for (int i = 0; i < pixelArr.length; i++) {
                for (int j = 0; j < pixelArr[i].length; j++) {
                    System.out.print(toBinaryShow(pixelArr[i][j][z]) + " ");
                }
                System.out.println();
            }
        }
    }

    /*public String [][][] getPixelArray () {
        String [][][] a = new String[r.getWidth()][r.getHeight()][3];
        for (int z = 0; z < 3; z++) {
            for (int i = 0; i < pixelArr.length; i++) {
                for (int j = 0; j < pixelArr[i].length; j++) {
                    a[i][j][z] = toBinaryShow(pixelArr[i][j][z]);
                }
            }
        }
        return a;
    }*/

    public int [][][] getIntPixelArray () {
        int [][][] a = new int[r.getWidth()][r.getHeight()][3];
        for (int z = 0; z < 3; z++) {
            for (int i = 0; i < pixelArr.length; i++) {
                for (int j = 0; j < pixelArr[i].length; j++) {
                    a[i][j][z] = pixelArr[i][j][z];
                }
            }
        }
        return a;
    }

    private String toBinaryShow(int i) {
        StringBuilder sb = new StringBuilder(Integer.toString(i));
        while (sb.length() != 8) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
