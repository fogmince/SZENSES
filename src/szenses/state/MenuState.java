package szenses.state;

import szenses.Main;
import szenses.graphics.*;
import szenses.graphics.ui.components.UIButton;
import szenses.util.Vector2i;

import java.awt.*;


public class MenuState extends State {

    private MenuUI ui;

    private UIButton search;
    private UIButton favorites;
    private UIButton settings;
    private UIButton help;

    public MenuState(StateManager ms) {
        super(ms);
        ui = new MenuUI();

    }

    public void init() {
        ui = new MenuUI();

        search = new UIButton(Sprite.buttonTest, new Vector2i(285 - 150, 250));
        ui.addButton(search);

        favorites = new UIButton(Sprite.buttonTest, new Vector2i(285 - 150, 320));
        ui.addButton(favorites);

        settings = new UIButton(Sprite.buttonTest, new Vector2i(285 - 150, 390));
        ui.addButton(settings);

        help = new UIButton(Sprite.buttonTest, new Vector2i(285 - 150, 460));
        ui.addButton(help);
    }

    public void update() {
        ui.update();

        if(search.isClicked()) System.out.println("HEJ");
    }

    public void render(Screen screen) {
        screen.drawRect(new Color(0x8EB9FF), 0, 0, Main.WIDTH, Main.HEIGHT);
        ui.render(screen);
    }
}
