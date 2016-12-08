package szenses.state;

import szenses.Main;
import szenses.graphics.*;
import szenses.graphics.ui.MenuUI;
import szenses.graphics.ui.components.UIButton;
import szenses.graphics.ui.components.UILabel;
import szenses.util.Vector2i;

import java.awt.*;


public class MenuState extends State {

    private MenuUI ui;

    private UIButton search;
    private UIButton favorites;
    private UIButton settings;
    private UIButton help;

    private UILabel searchText;
    private UILabel favoriteText;
    private UILabel settingsText;
    private UILabel helpText;

    public MenuState(StateManager ms) {
        super(ms);
        ui = new MenuUI();

    }

    public void init() {
        ui = new MenuUI();


        search = new UIButton(Sprite.button, new Vector2i(Main.WIDTH / 2 - 450 / 2, 280));
        ui.addButton(search);

        favorites = new UIButton(Sprite.button, new Vector2i(Main.WIDTH / 2 - 450 / 2, 280 + (int) (80 * 1.5)));
        ui.addButton(favorites);

        settings = new UIButton(Sprite.button, new Vector2i(Main.WIDTH / 2 - 450 / 2, 280 + (int) (80 * 3)));
        ui.addButton(settings);

        help = new UIButton(Sprite.button, new Vector2i(Main.WIDTH / 2 - 450 / 2, 280 + (int) (80 * 4.5)));
        ui.addButton(help);

        searchText = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 175, 280 + 75 - 15), "Sök").setColor(Color.BLACK).setFont(new Font("Times new roman", Font.ITALIC, 72));
        ui.addLabel(searchText);

        favoriteText = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 110, 280 + (int) (80 * 1.5) + 75 - 15), "Favoriter").setColor(Color.BLACK).setFont(new Font("Times new roman", Font.ITALIC, 72));
        ui.addLabel(favoriteText);

        settingsText = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 45, 280 + (int) (80 * 3) + 75 - 15), "Inställningar").setColor(Color.BLACK).setFont(new Font("Times new roman", Font.ITALIC, 72));
        ui.addLabel(settingsText);

        helpText = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 140, 280 + (int) (80 * 4.5) + 75 - 15), "Hjälp").setColor(Color.BLACK).setFont(new Font("Times new roman", Font.ITALIC, 72));
        ui.addLabel(helpText);
    }

    public void update() {
        ui.update();

        if(search.isClicked()) sm.setState(StateManager.SEARCH_STATE);
    }

    public void render(Screen screen) {
        ui.render(screen);
    }
}
