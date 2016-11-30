package szenses.graphics.ui.components;


import szenses.graphics.Screen;
import szenses.graphics.Sprite;
import szenses.util.Vector2i;

import java.awt.*;

public class UISprite extends UIComponent {

    private Sprite sprite;

    public UISprite(Vector2i position, Sprite sprite) {
        super(position);
        this.sprite = sprite;
    }

    public void render(Screen screen) {
        screen.drawImage(sprite, position.x, position.y);
    }
}
