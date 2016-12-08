package szenses.graphics.ui.components;

import org.w3c.dom.ranges.*;
import szenses.graphics.Screen;
import szenses.util.Vector2i;

import java.awt.*;

public class UIProgressBar extends UIComponent {
    private Vector2i size;
    private Color foreground;

    private double progress; //0.0 - 1.0

    public UIProgressBar(Vector2i position, Vector2i size) {
        super(position);
        this.size = size;
        color = Color.GRAY;
        foreground = Color.RED;
    }

    public void render(Screen screen) {
      /*  g.setColor(color);
        g.fillRect(position.x, position.y, size.x, size.y);

        g.setColor(foreground);
        g.fillRect(position.x, position.y, (int) (progress * size.x), size.y); */

        screen.drawRect(color, position.x, position.y, size.x, size.y);
        screen.drawRect(foreground, position.x, position.y, (int) (progress * size.x), size.y);
    }

    public void update() {
        if(progress < 0.4) setColor(Color.GREEN);
        else if(progress >= 0.4 && progress < 0.7) setColor(Color.YELLOW);
        else setColor(Color.RED);
    }

    public void setProgress(double progress) {
        if(progress < 0.0 || progress > 1.0) {
            progress = 1;
            System.err.println("Progress out of range Set to 1");
        }

        this.progress = progress;
    }

    public UIComponent setColor(Color color) {
        this.foreground = color;
        return this;
    }
}
