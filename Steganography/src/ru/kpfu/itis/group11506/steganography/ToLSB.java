package ru.kpfu.itis.group11506.steganography;

public class ToLSB {

    public byte [] LSB(Container container, Key key) {
        checkAvailableSpace(container.getAvailableSpace(), key.getSizeOfMessage());
        String [] txt = getCoupOfByte(key.getBinaryText());
        byte [] imageInByte = container.getBytePixelArray();

        System.out.println("txt.length" + txt.length);
        for (int i = 0; i < txt.length; i++) {
            if ((imageInByte[i+54] < 0 && imageInByte[i+54] + bin2dec(txt[i]) < 0) || (imageInByte[i+54] > 0 && imageInByte[i+54] + bin2dec(txt[i]) < 128)) {
                System.out.println(imageInByte[i+54] + bin2dec(txt[i]));
                System.out.print("-> ");
                imageInByte[i+54] = (byte) (imageInByte[i+54] + bin2dec(txt[i]));
            }
            System.out.println((i+54) + " - " + imageInByte[i+54]);
        }
        System.out.println("length - " + imageInByte.length);

        return imageInByte;
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
