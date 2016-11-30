package szenses.state;

import szenses.Main;
import szenses.graphics.*;
import szenses.graphics.ui.components.UIButton;
import szenses.util.Vector2i;

import java.awt.*;


public class MenuState extends State {

    private MenuUI ui;

    private UIButton test;

    public MenuState(StateManager ms) {
        super(ms);
        ui = new MenuUI();

        test = new UIButton(Sprite.buttonTest, new Vector2i(285 - 100, 400));
        ui.addButton(test);
    }

    public void init() {
        ui = new MenuUI();

        test = new UIButton(Sprite.buttonTest, new Vector2i(285 - 100, 400));
        ui.addButton(test);
    }

    public void update() {
        ui.update();

        if(test.isClicked()) System.out.println("HEJ");
    }

    public void render(Screen screen) {
        screen.drawRect(new Color(0x8EB9FF), 0, 0, Main.WIDTH, Main.HEIGHT);
        ui.render(screen);
    }
}
