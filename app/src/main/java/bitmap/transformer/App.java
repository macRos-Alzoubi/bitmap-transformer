/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.io.File;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap();
        bitmap.mirrorImage(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_image.jpg")
                , new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_imageMirror.jpg"));
        bitmap.rotate90(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_image.jpg")
        , new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_imageRotate.jpg"),
                1);
        bitmap.darken(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_image.jpg"),
                new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_imageDarken.jpg") );

        bitmap.lighten(new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_image.jpg"),
                new File("C:\\Users\\STUDENT\\401courseJAVA\\java-fundamentals\\bitmap-transformer\\app\\src\\main\\resources\\GUI_it_imageLighten.jpg") );

//        String imageTransformation = args[2];
//        File sourceImageFile = new File(args[0]);
//        File targetImageFile = new File(args[1]);
//
//        if (imageTransformation.contains("rotate")) {
//            if (imageTransformation.endsWith("+1"))
//                bitmap.rotate90(sourceImageFile, targetImageFile, 1);
//            else if (imageTransformation.endsWith("-1"))
//                bitmap.rotate90(sourceImageFile, targetImageFile, -1);
//            else
//                System.out.println("Direction of rotation either 1 or -1 (Left || Right)");
//        } else if (imageTransformation.equals("mirror"))
//            bitmap.mirrorImage(sourceImageFile, targetImageFile);
//        else if (imageTransformation.equals("darken"))
//            bitmap.darken(sourceImageFile, targetImageFile);
//        else if (imageTransformation.equals("lighten"))
//            bitmap.lighten(sourceImageFile, targetImageFile);
//        else
//            System.out.println("Invalid CLI input please enter a valid inputs");

    }
}
