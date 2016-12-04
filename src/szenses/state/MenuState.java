package szenses.state;

import com.sun.prism.paint.*;
import szenses.Main;
import szenses.graphics.*;
import szenses.graphics.ui.components.UIButton;
import szenses.util.Vector2i;

import java.awt.*;
import java.awt.Color;


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

        search = new UIButton(Sprite.buttonTest, new Vector2i(285 - 150, 220 - 15));
        ui.addButton(search);

        favorites = new UIButton(Sprite.buttonTest, new Vector2i(285 - 150, 300 - 15));
        ui.addButton(favorites);

        settings = new UIButton(Sprite.buttonTest, new Vector2i(285 - 150, 380 - 15));
        ui.addButton(settings);

        help = new UIButton(Sprite.buttonTest, new Vector2i(285 - 150, 460 - 15));
        ui.addButton(help);
    }

    public void update() {
        ui.update();

        if(search.isClicked()) System.out.println("HEJ");
    }

    public void render(Screen screen) {
        //screen.drawRect(new Color(0x29E4F0), 0, 0, Main.WIDTH, Main.HEIGHT);

        GradientPaint gradient = new GradientPaint(0, 100, Color.BLUE, 200, 200, Color.CYAN);
        screen.renderBackgruondPaint(gradient);

        ui.render(screen);
    }
}
