package szenses.graphics;

import szenses.Main;
import szenses.graphics.ui.components.UIButton;
import szenses.graphics.ui.components.UIHandler;
import szenses.graphics.ui.components.UILabel;
import szenses.util.Vector2i;

import java.awt.*;

public class MenuUI {

    private UIHandler handler;

    private UILabel title;
    private UIButton test;

    public MenuUI() {
        handler = new UIHandler();

        title = new UILabel(new Vector2i(285 - 150, 200), "Szenses").setColor(Color.DARK_GRAY).setFont(new Font("Georgia", Font.BOLD, 70));
        handler.addComponent(title);

       // test = new UIButton(Sprite.buttonTest, new Vector2i(285 - 100, 400));
        //handler.addComponent(test);
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
