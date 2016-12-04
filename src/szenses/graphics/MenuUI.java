package szenses.graphics;

import szenses.Main;
import szenses.graphics.ui.components.UIButton;
import szenses.graphics.ui.components.UIHandler;
import szenses.graphics.ui.components.UILabel;
import szenses.graphics.ui.components.UISprite;
import szenses.util.Vector2i;

import java.awt.*;

public class MenuUI {

    private UIHandler handler;

    private UILabel title;

    private UISprite glass;
    private UISprite star;
    private UISprite gear;

    public MenuUI() {
        handler = new UIHandler();

        title = new UILabel(new Vector2i(285 - 120, 150), "Szenses").setColor(new Color(0x59256E)).setFont(new Font("georgia", Font.ITALIC, 70));
        handler.addComponent(title);

        glass = new UISprite(new Vector2i(285 + 150 + 20, 220 - 15), Sprite.iconGlass);
        handler.addComponent(glass);

        star = new UISprite(new Vector2i(285 + 150 + 20, 300 - 15), Sprite.iconstar);
        handler.addComponent(star);

        gear = new UISprite(new Vector2i(285 + 150 + 20, 380 - 15), Sprite.iconGear);
        handler.addComponent(gear);
    }

    public void update() {
        handler.update();
    }

    public void render(Screen screen) {
        handler.render(screen);
    }

    public void addButton(UIButton b) {
        handler.addComponent(b);
    }
}
