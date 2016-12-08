package szenses.graphics.ui;

import szenses.Main;
import szenses.graphics.Screen;
import szenses.graphics.Sprite;
import szenses.graphics.ui.components.*;
import szenses.input.*;
import szenses.util.Vector2i;

import java.awt.*;

public class SearchUI extends UI {

    private UISprite overRow;
    private UISprite lowerRow;
    private UISprite a;
    private UISprite b;
    private UISprite arrow;
    private UISprite arrowLeft;

    private UILabel start;
    private UILabel stop;
    private UILabel time;
    private UILabel time2;
    private UILabel recommendation;
    private UILabel departer1;
    private UILabel arrival1;
    private UILabel yellow;
    private UILabel departer2;
    private UILabel arrival2;
    private UILabel buss16;


    private UIProgressBar peopleYellow;
    private double peopleAmountYellow = 330;

    private UIProgressBar people16;
    private double peopleAmount16 = 200;

    private boolean searched = false;

    public SearchUI() {
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

        start = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 90, 250), "Nordstan").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 40));
        handler.addComponent(start);

        stop = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 90, 340), "Lindholmen").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 40));
        handler.addComponent(stop);

        time = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2, 410), "Avg.").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 32));
        handler.addComponent(time);

        time2 = new UILabel(new Vector2i(Main.WIDTH / 2 - 450 / 2 + 100, 410), "Idag   13:48").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 32));
        handler.addComponent(time2);

        peopleYellow = new UIProgressBar(new Vector2i(Main.WIDTH / 2 - 230, 610), new Vector2i(100, 30));
        departer1 = new UILabel(new Vector2i(Main.WIDTH / 2 - 105, 632), "13:51").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 26));
        arrival1 = new UILabel(new Vector2i(Main.WIDTH / 2 + 80, 632), "14:02").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 26));
        yellow = new UILabel(new Vector2i(Main.WIDTH / 2 - 10, 632), "Gul").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 26));

        people16 = new UIProgressBar(new Vector2i(Main.WIDTH / 2 - 230, 710), new Vector2i(100, 30));
        departer2 = new UILabel(new Vector2i(Main.WIDTH / 2 - 105, 732), "13:53").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 26));
        arrival2 = new UILabel(new Vector2i(Main.WIDTH / 2 + 80, 732), "14:05").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 26));
        buss16 = new UILabel(new Vector2i(Main.WIDTH / 2 - 5, 732), "16").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 26));

        arrowLeft = new UISprite(new Vector2i(Main.WIDTH / 2 + 190, 605), Sprite.iconArrowLeft);
        recommendation = new UILabel(new Vector2i(Main.WIDTH / 2 + 190, 560), "REC.").setColor(Color.BLACK).setFont(new Font("Times New Roman", Font.PLAIN, 26));
    }

    public void update() {
        handler.update();

        peopleYellow.setProgress(peopleAmountYellow / 600);
        people16.setProgress(peopleAmount16 / 600);

        if(Keyboard.space) {
            peopleAmountYellow += 5;
            arrowLeft.setPosition(Main.WIDTH / 2 + 190, 705);
        }
    }

    public void render(Screen screen) {
        screen.drawRect(new Color(0xBEBEBE), Main.WIDTH / 2 - 460 / 2 - 40, 160, 560, 350);

        if(searched) {
            screen.drawRect(new Color(0xBEBEBE), Main.WIDTH / 2 - 460 / 2 - 40, 500, 560, 310);

            screen.drawEmtyRect(Color.WHITE, Main.WIDTH / 2 - 460 / 2 - 20, 585, 400, 80);
            screen.drawEmtyRect(Color.WHITE, Main.WIDTH / 2 - 460 / 2 - 20, 685, 400, 80);

            screen.drawRect(Color.YELLOW, Main.WIDTH / 2 - 13, 632 - 23, 45, 30);
            screen.drawRect(new Color(0x50ADFF), Main.WIDTH / 2 - 13, 732 - 23, 45, 30);
        }

        handler.render(screen);
    }

    public void search() {
        searched = true;
        handler.addComponent(peopleYellow);
        handler.addComponent(departer1);
        handler.addComponent(arrival1);
        handler.addComponent(yellow);

        handler.addComponent(people16);
        handler.addComponent(departer2);
        handler.addComponent(arrival2);
        handler.addComponent(buss16);

        handler.addComponent(arrowLeft);
        handler.addComponent(recommendation);
    }
}
