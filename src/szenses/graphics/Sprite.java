package szenses.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {

    private static final String button_path = "/textures/ui/button/";
    private static final String icon_path = "/textures/ui/icon/";

    // UI
    public static final Sprite buttonTest = new Sprite(button_path + "button");

    public static final Sprite iconGlass = new Sprite(icon_path + "glass");
    public static final Sprite iconGear = new Sprite(icon_path + "gear");
    public static final Sprite iconstar = new Sprite(icon_path + "star");



    private String path;
    private int width, height;
    private int[] pixels;

    private BufferedImage image;

    public Sprite(String path) {
        this.path = path + ".png";
        loadImage();
    }

    public Sprite(int color, int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];

        for(int i = 0; i < pixels.length; i++)  {
            pixels[i] = color;
        }

        image = new BufferedImage(width, height, 1);

        image.setRGB(0, 0, width, height, pixels, 0, width);
    }

    public Sprite(int[] pixels, int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[pixels.length];

        for(int i = 0; i < pixels.length; i++) {
            this.pixels[i] = pixels[i];

            if(this.pixels[i] == 0xFFFF00FF) {
                this.pixels[i] = 0x0;
            }
        }


        image = new BufferedImage(width, height, 2);

        image.setRGB(0, 0, width, height, this.pixels, 0, width);
    }

    private void loadImage() {
        try {

            System.out.print("Loading image " + path + "...");
            image = ImageIO.read(Sprite.class.getResourceAsStream(path));
            System.out.println(" Successful");

            width = image.getWidth();
            height = image.getHeight();

            pixels = new int[width * height];

            image.getRGB(0, 0, width, height, pixels, 0, width);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(" Failed");
        }
    }

    public BufferedImage getSprite() {
        return image;
    }
}
