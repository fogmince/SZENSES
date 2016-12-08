package szenses.state;

import szenses.Main;
import szenses.graphics.Screen;
import szenses.graphics.Sprite;
import szenses.graphics.ui.SearchUI;
import szenses.graphics.ui.components.UIButton;
import szenses.graphics.ui.components.UISprite;
import szenses.util.Vector2i;


public class SearchState extends State {

    private SearchUI ui;

    private UIButton back;
    private UIButton search;
    private UIButton map;

    public SearchState(StateManager sm) {
        super(sm);
    }

    public void init() {
        ui = new SearchUI();

        back = new UIButton(Sprite.buttonBack, new Vector2i(25, 25));
        ui.addButton(back);

        search = new UIButton(Sprite.search, new Vector2i(Main.WIDTH / 2 - 450 / 2 - 10, 440));
        ui.addButton(search);

    }

    public void update() {
        ui.update();

        if(back.isClicked()) sm.setState(StateManager.MENU_STATE);

        if(search.isClicked()) ui.search();
    }

    public void render(Screen screen) {
        screen.drawImage(Sprite.background, -400, -200);

        ui.render(screen);
    }
}
