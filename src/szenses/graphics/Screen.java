package szenses.graphics;

import szenses.*;

import java.awt.*;

public class Screen {

    private int xOffset, yOffset;

    private Graphics g;

    public Screen() {

    }

    public void drawRect(Color color, int x, int y, int width, int height) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void clear() {
        g.setColor(Color.black);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
    }

    public void setGraphics(Graphics g) {
        this.g = g;
    }
}
