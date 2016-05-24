package ru.kpfu.itis.group11506.steganography;

public class ToLSB {

    public int [][][] LSB(Container container, Key key) {
        checkAvailableSpace(container.getAvailableSpace(), key.getSizeOfMessage());
        String [] txt = getCoupOfByte(key.getBinaryText());
        int [][][] pixels = container.getIntPixelArray();

        for (int i = 0; i < txt.length; i++) {
            pixels[(i / 10) % 10][i % 10][i / 100] =
                    pixels[(i / 10) % 10][i % 10][i / 100] +
                            bin2dec(txt[i]);
        }

        /*for (int z = 0; z < 3; z++) {
            System.out.println();
            for (int i = 0; i < pixels.length; i++) {
                for (int j = 0; j < pixels[i].length; j++) {
                    System.out.print(pixels[i][j][z] + " ");
                }
                System.out.println();
            }
        }*/
        return pixels;
    }


    private void checkAvailableSpace(int availableSpace, int sizeOfMessage) {
        System.out.println("AvailableSpace - " + availableSpace);
        System.out.println("sizeOfMessage - " + sizeOfMessage);
        if (availableSpace < sizeOfMessage) {
            System.out.println("Size of message so big");
            System.exit(0);
        }
    }

    private String[] getCoupOfByte(String [] txt) {
        String [] byteArr = new String[txt.length*4];
        for (int i = 0; i < txt.length; i ++) {
            for (int j = 0; j < txt[i].length(); j+=2) {
                byteArr[i*4+j/2] = txt[i].substring(j, j + 2);
            }
        }
        return byteArr;
    }

    private int bin2dec(String binNumber) {
        int result = 0;
        for (int i = 0; i < binNumber.length(); i++) {
            result += Math.pow(2, i) * (binNumber.charAt(i) == '1' ? 1 : 0);
        }
        return result;
    }
}
