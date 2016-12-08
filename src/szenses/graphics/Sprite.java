package szenses.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {

    private static final String button_path = "/textures/ui/button/";
    private static final String icon_path = "/textures/ui/icon/";
    private static final String ui_path = "/textures/ui/";

    // UI
    public static final Sprite button = new Sprite(button_path + "button");
    public static final Sprite buttonBack = new Sprite(button_path + "back_button");
    public static final Sprite search = new Sprite(button_path + "search_button");
    public static final Sprite map = new Sprite(button_path + "map_button");

    public static final Sprite iconGlass = new Sprite(icon_path + "glass");
    public static final Sprite iconGear = new Sprite(icon_path + "gear");
    public static final Sprite iconStar = new Sprite(icon_path + "star");
    public static final Sprite iconHelp = new Sprite(icon_path + "help");
    public static final Sprite iconArrows = new Sprite(icon_path + "arrow");
    public static final Sprite iconA = new Sprite(icon_path + "A");
    public static final Sprite iconB = new Sprite(icon_path + "B");

    public static final Sprite title = new Sprite(ui_path + "1234");
    public static final Sprite background = new Sprite(ui_path + "backgruond");



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
