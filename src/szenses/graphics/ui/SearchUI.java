package szenses.graphics.ui;

import szenses.Main;
import szenses.graphics.Screen;
import szenses.graphics.Sprite;
import szenses.graphics.ui.components.UIButton;
import szenses.graphics.ui.components.UIHandler;
import szenses.graphics.ui.components.UILabel;
import szenses.graphics.ui.components.UISprite;
import szenses.util.Vector2i;

import java.awt.*;

public class SearchUI {

    private UIHandler handler;

    private UISprite overRow;
    private UISprite lowerRow;

    private UILabel start;
    private UILabel stop;
    private UILabel time;
    private UILabel time2;

    private UISprite a;
    private UISprite b;

    private UISprite arrow;

    private UIButton map;

    private boolean searched = false;

    public SearchUI() {
        handler = new UIHandler();

        overRow = new UISprite(new Vector2i(Main.WIDTH / 2 - 450 / 2, 200), Sprite.button);
        handler.addComponent(overRow);

        lowerRow = new UISprite(new Vector2i(Main.WIDTH / 2 - 450 / 2, 290), Sprite.button);
        handler.addComponent(lowerRow);

        arrow = new UISprite(new Vector2i(Main.WIDTH / 2 + 450 / 2 + 20, 260), Sprite.iconArrows);
        handler.addComponent(arrow);

        a = new UISprite(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 20, 220), Sprite.iconA);
        handler.addComponent(a);

        b = new UISprite(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 20, 310), Sprite.iconB);
        handler.addComponent(b);

        start = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 90, 250), "Centralstationen").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 40));
        handler.addComponent(start);

        stop = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 90, 340), "Lindholmen").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 40));
        handler.addComponent(stop);

        time = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2, 410), "Avg.").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 32));
        handler.addComponent(time);

        time2 = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 100, 410), "Idag   18:00").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 32));
        handler.addComponent(time2);


        map = new UIButton(Sprite.map, new Vector2i(Main.WIDTH / 2 - 460 / 2 - 5, 520));

    }

    public void update() {
        handler.update();
    }

    public void render(Screen screen) {
        screen.drawRect(new Color(0xBEBEBE), Main.WIDTH / 2 - 460 / 2 - 40, 160, 560, 350);

        if(searched) screen.drawRect(new Color(0xBEBEBE), Main.WIDTH / 2 - 460 / 2 - 40, 500, 560, 340);
        handler.render(screen);
    }

    public void search() {
        searched = true;
        handler.addComponent(map);
    }

    public void addButton(UIButton b) {
        handler.addComponent(b);
    }
}
