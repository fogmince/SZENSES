package szenses.graphics.ui;

import szenses.Main;
import szenses.graphics.Screen;
import szenses.graphics.Sprite;
import szenses.graphics.ui.components.UIButton;
import szenses.graphics.ui.components.UIHandler;
import szenses.graphics.ui.components.UILabel;
import szenses.graphics.ui.components.UISprite;
import szenses.util.Vector2i;

public class MenuUI {

    private UIHandler handler;

    private UISprite background;

    private UISprite glass;
    private UISprite star;
    private UISprite gear;
    private UISprite help;

    private UISprite title;

    public MenuUI() {
        handler = new UIHandler();

        background = new UISprite(new Vector2i(-500, -200), Sprite.background);
        handler.addComponent(background);

        title = new UISprite(new Vector2i(Main.WIDTH / 2 - 374 / 2 - 80, -20), Sprite.title);
        handler.addComponent(title);

        glass = new UISprite(new Vector2i(Main.WIDTH / 2 + 450 / 2 + 30, 280), Sprite.iconGlass);
        handler.addComponent(glass);

        star = new UISprite(new Vector2i(Main.WIDTH / 2 + 450 / 2 + 30, 280 + (int) (80 * 1.5)), Sprite.iconStar);
        handler.addComponent(star);

        gear = new UISprite(new Vector2i(Main.WIDTH / 2 + 450 / 2 + 30, 280 + 80 * 3), Sprite.iconGear);
        handler.addComponent(gear);

        help = new UISprite(new Vector2i(Main.WIDTH / 2 + 450 / 2 + 30, 280 + (int) (80 * 4.5)), Sprite.iconHelp);
        handler.addComponent(help);
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

    public void addLabel(UILabel l) {
        handler.addComponent(l);
    }
}
