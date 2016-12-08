package szenses.graphics;

import szenses.*;

import java.awt.*;

import static szenses.Main.SCALE;

public class Screen {

    private int xOffset, yOffset;

    private Graphics g;

    public Screen() {

    }

    public void drawRect(Color color, int x, int y, int width, int height) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void drawEmtyRect(Color color, int x, int y, int width, int height) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

    public void drawText(String text, int x, int y, Font font, Color color) {
        g.setFont(font);
        g.setColor(color);

        g.drawString(text, x, y);
    }

    public void drawImage(Sprite sprite, int x, int y) {
        g.drawImage(sprite.getSprite(), x, y, null);
    }


    public void clear() {
        g.setColor(Color.black);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
    }


    public void setGraphics(Graphics g) {
        this.g = g;
    }
}
