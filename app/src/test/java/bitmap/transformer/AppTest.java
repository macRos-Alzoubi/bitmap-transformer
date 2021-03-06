/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class AppTest {

    @Test
    public void mirrorImage() {
        Bitmap bitmap = new Bitmap();
        bitmap.mirrorImage(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_image.jpg"),
                new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_imageMirror.jpg"));
        try {
            BufferedImage soursImage = ImageIO.read(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_image.jpg"));
            BufferedImage targetImage = ImageIO.read(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_imageMirror.jpg"));
            int soursWidth = soursImage.getWidth();
            int targetWidth = targetImage.getWidth();
            assertEquals(soursWidth*2 ,targetWidth,"Target Image Width should be double the source Image Width (targetWidth = soursWidth*2 )." );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void rotate90(){
        Bitmap bitmap = new Bitmap();
        bitmap.rotate90(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_image.jpg"),
                new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_imageRotate.jpg") , +1);
        try {
            BufferedImage soursImage = ImageIO.read(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_image.jpg"));
            BufferedImage targetImage = ImageIO.read(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_imageRotate.jpg"));
            int soursWidth = soursImage.getWidth();
            int targetHeight = targetImage.getHeight();
            assertEquals(soursWidth ,targetHeight,"Target Image Height should be the same as the source Image Width (targetHeight = soursWidth )." );
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void darken(){
        Bitmap bitmap = new Bitmap();
        bitmap.darken(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\BmpImage.bmp"),
                new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\BmpImageDarken.bmp"));
        try {
            BufferedImage soursImage = ImageIO.read(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\BmpImage.bmp"));
            BufferedImage targetImage = ImageIO.read(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\BmpImageDarken.bmp"));
            Color rgb = new Color(soursImage.getRGB(0,0));
            rgb = rgb.darker();
            Color rgbDarken = new Color(targetImage.getRGB(0,0));
            assertEquals(rgb.getRGB(),rgbDarken.getRGB() ,"The first pixel in the target image should be darker than the The first pixel in the source image");

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Test
    public void lighten(){
        Bitmap bitmap = new Bitmap();
        bitmap.lighten(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\BmpImage.bmp"),
                new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\BmpImageLighten.bmp"));
        try {
            BufferedImage soursImage = ImageIO.read(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\BmpImage.bmp"));
            BufferedImage targetImage = ImageIO.read(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\BmpImageLighten.bmp"));
            Color rgb = new Color(soursImage.getRGB(0,0));
            rgb = rgb.brighter();
            Color rgbDarken = new Color(targetImage.getRGB(0,0));
            assertEquals(rgb.getRGB(),rgbDarken.getRGB(),"The first pixel in the target image should be brighter than the The first pixel in the source image");

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
