/**
 * Written by Mohammad Alzoubi
 */
package bitmap.transformer;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
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

    /**
     *
     * @param width Width of the image
     * @param height Height of the image
     */
    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Bitmap() {
    }


    /**
     *
     * @param imagePath Image path to be read
     *
     */
    private void readImage(File imagePath) {
        if (width != 0 && height != 0)
            fromDiskImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        try {
            System.out.println("in readImage: " + imagePath);
            fromDiskImage = ImageIO.read(imagePath);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());

        }
    }

    /**
     *
     * @param fromFile Source image file reference
     * @param toFile Saved image file reference
     */
    private void writeImage(File fromFile, File toFile) {
        try {
            String format = getFormat(fromFile);
            ImageIO.write(toDiskImage, format, toFile);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    /**
     *
     * @param fromFile Source image file reference
     * @return Returns Source image format (String)
     */
    private String getFormat(File fromFile) {
        String format = "";
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(fromFile);
            Iterator<ImageReader> iterator = ImageIO.getImageReaders(iis);
            ImageReader reader = iterator.next();
            format = reader.getFormatName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
     *
     * @param fromFile Source image file reference
     * @param toFile Saved image file reference
     * @param direction Direction of rotation either 1 or -1 (Left || Right)
     */
    public void rotate90(File fromFile, File toFile, int direction) {

        if (direction != ROTATE_LEFT && direction != ROTATE_RIGHT) {
            System.out.println("Direction should be either 1 or -1");
        } else {
            readImage(fromFile);
            int width = fromDiskImage.getWidth();
            int height = fromDiskImage.getHeight();
            System.out.printf("width: %s, Height: %s\n", width, height);
            toDiskImage = new BufferedImage(height, width, fromDiskImage.getType());

            for (int y = 0; y < height; y++)
                for (int x = 0; x < width; x++)
                    if (direction == ROTATE_LEFT)
                        toDiskImage.setRGB(y, (width - 1) - x, fromDiskImage.getRGB(x, y));
                    else toDiskImage.setRGB((height - 1) - y, x, fromDiskImage.getRGB(x, y));

            writeImage(fromFile, toFile);
        }
    }

    /**
     *
     * @param fromFile Source image file reference
     * @param toFile Saved image file reference
     */
    public void mirrorImage(File fromFile, File toFile) {

        readImage(fromFile);
        int width = fromDiskImage.getWidth();
        int height = fromDiskImage.getHeight();
        toDiskImage = new BufferedImage(width * 2, height, fromDiskImage.getType());

        for (int y = 0; y < height; y++)
            for (int lx = 0, rx = width * 2 - 1; lx < width; lx++, rx--) {
                int pixel = fromDiskImage.getRGB(lx, y);

                toDiskImage.setRGB(lx, y, pixel);
                toDiskImage.setRGB(rx, y, pixel);
            }

        writeImage(fromFile, toFile);
    }

    /**
     *
     * @param fromFile Source image file reference
     * @param toFile Saved image file reference
     */
    public void darken(File fromFile, File toFile) {

        readImage(fromFile);
        int width = fromDiskImage.getWidth();
        int height = fromDiskImage.getHeight();
        toDiskImage = new BufferedImage(width, height, fromDiskImage.getType());
        Color darkerColor;

        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++) {
                darkerColor = new Color(fromDiskImage.getRGB(x, y));
                darkerColor = darkerColor.darker();
                toDiskImage.setRGB(x, y, darkerColor.getRGB());
            }

        writeImage(fromFile, toFile);
    }

    /**
     *
     * @param fromFile Source image file reference
     * @param toFile Saved image file reference
     */
    public void lighten(File fromFile, File toFile) {

        readImage(fromFile);
        int width = fromDiskImage.getWidth();
        int height = fromDiskImage.getHeight();
        toDiskImage = new BufferedImage(width, height, fromDiskImage.getType());
        Color lighterColor;

        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++) {
                lighterColor = new Color(fromDiskImage.getRGB(x, y));
                lighterColor = lighterColor.brighter();
                toDiskImage.setRGB(x, y, lighterColor.getRGB());
            }

        writeImage(fromFile, toFile);
    }
}
