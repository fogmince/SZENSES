package szenses.graphics.ui.components;


import szenses.graphics.Screen;
import szenses.util.Vector2i;

import java.awt.*;

public class UILabel extends UIComponent {

    private String text;
    private Font font;

    public UILabel(Vector2i position, String text) {
        super(position);
        this.text = text;
        font = new Font("Helvetica", Font.PLAIN, 32);
    }

    public void render(Screen screen) {
        screen.drawText(text, position.x, position.y, font, color);
    }

    public UILabel setFont(Font font) {
        this.font = font;
        return this;
    }

    public UILabel setColor(Color color) {
        this.color = color;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }
}
