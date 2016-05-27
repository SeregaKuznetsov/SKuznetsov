package ru.kpfu.itis.group11506.steganography;

public class FromLSB {


    public String fromLSB(Container container) {
        byte [] pixels = container.getBytePixelArray();
        String [] binaryTxt = new String [container.getAvailableSpace()];
        for (int i = 54; i < pixels.length; i++) {
            binaryTxt[i-54] = getTwoLastBit(pixels[i]);
        }
        System.out.println((int)'s');
        System.out.println(Integer.toString((int)'s', 2));
        return null;
    }

    private String getTwoLastBit(int num) {
        String binaryNum = "0" + Integer.toString(num, 2);
        if (binaryNum.charAt(0) == '-') {
            //binaryNum.charAt(0) = '0';
        }
        return binaryNum.substring(binaryNum.length()-2, binaryNum.length());
    }

    /*private String getText (String [] binaryTxt) {
        char [] txt = new char [binaryTxt.length / 4];
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < binaryTxt.length;  i+=4) {
            System.out.println("i - " + i + " bin - " + binaryTxt[i] + binaryTxt[i+1]
                    + binaryTxt[i+2] + binaryTxt[i+3] + " dec - " + Integer.parseInt(binaryTxt[i] + binaryTxt[i+1]
                    + binaryTxt[i+2] + binaryTxt[i+3]) + " char - " + (char)(Integer.parseInt(binaryTxt[i] + binaryTxt[i+1]
                    + binaryTxt[i+2] + binaryTxt[i+3])));
            txt [i] = (char)Integer.parseInt(binaryTxt[i] + binaryTxt[i+1]
                    + binaryTxt[i+2] + binaryTxt[i+3]);
        }
        for (int i = 0; i < txt.length; i++) {
            text.append(txt);
        }
        return text.toString();
    }*/

    private byte bin2dec(String binNumber) {
        byte result = 0;
        for (int i = 0; i < binNumber.length(); i++) {
            result += Math.pow(2, i) * (binNumber.charAt(i) == '1' ? 1 : 0);
        }
        return result;
    }
}
