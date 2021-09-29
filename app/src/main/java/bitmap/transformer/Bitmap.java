package bitmap.transformer;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Bitmap {

    private static final int ROTATE_LEFT = 1;
    private static final int ROTATE_RIGHT = -1;

    private int width = 0;
    private int height = 0;

    private BufferedImage fromDiskImage;
    private BufferedImage toDiskImage;

    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    public Bitmap() {
    }
    public void readImage(File imagePath) {
        if (width != 0 && height != 0)
            fromDiskImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        try {
            fromDiskImage = ImageIO.read(imagePath);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());

        }
    }

    public void writeImage(File targetImagePath) {
        try {
            Iterator<ImageReader> iterator = ImageIO.getImageReaders(fromDiskImage);
            ImageReader reader = iterator.next();
            String format = reader.getFormatName();

            ImageIO.write(toDiskImage, format, targetImagePath);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public void rotate90(int direction) {

        int width = fromDiskImage.getWidth();
        int height = fromDiskImage.getHeight();
        toDiskImage = new BufferedImage(width, height, fromDiskImage.getType());

        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++) {
                if (direction == ROTATE_LEFT)
                    toDiskImage.setRGB(y, (width - 1) - x, fromDiskImage.getRGB(x, y));
                else if (direction == ROTATE_RIGHT)
                    toDiskImage.setRGB((height - 1) - y, x, fromDiskImage.getRGB(x, y));
            }
    }

    public void mirrorImage() {
        int width = fromDiskImage.getWidth();
        int height = fromDiskImage.getHeight();
        toDiskImage = new BufferedImage(width * 2, height, fromDiskImage.getType());

        for (int y = 0; y < height; y++) {
            for (int lx = 0, rx = width * 2 - 1; lx < width; lx++, rx--) {
                int pixel = fromDiskImage.getRGB(lx, y);

                toDiskImage.setRGB(lx, y, pixel);
                toDiskImage.setRGB(rx, y, pixel);
            }
        }
    }

    public void OrangeBorder(){
        System.out.println("in red border 1");
        int borderWidth = 5;
        int width = fromDiskImage.getWidth();
        int height = fromDiskImage.getHeight();
        toDiskImage = new BufferedImage(width, height, fromDiskImage.getType());


        System.out.println("in red border 2");
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (y < borderWidth || y + borderWidth >= height || x < borderWidth || x + borderWidth >= width) {
                    toDiskImage.setRGB(x, y, ((int) (Color.RED.getRGB() * 0.50)));
                }
            }
        }
    }
}
