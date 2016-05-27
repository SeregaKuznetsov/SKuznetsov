package ru.kpfu.itis.group11506.steganography;

        import javax.imageio.ImageIO;
        import java.awt.image.BufferedImage;
        import java.io.ByteArrayInputStream;
        import java.io.File;
        import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String imagePath = args[0];
        File file = new File(imagePath);

        Container container = new Container(file);
        Key key = new Key();
        ToLSB toLSB = new ToLSB();
        toLSB.LSB(container, key);

        BufferedImage newImg = ImageIO.read(new ByteArrayInputStream(container.getBytePixelArray()));
        ImageIO.write(newImg, "bmp", new File("C:\\\\Projects\\\\pic2.bmp"));

        FromLSB fromLSB = new FromLSB();
        Container container1 = new Container(new File("C:\\\\Projects\\\\pic2.bmp"));
        System.out.println(fromLSB.fromLSB(container1));
    }
}

