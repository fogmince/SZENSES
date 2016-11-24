package szenses.state;

import szenses.graphics.*;

import java.awt.*;


public class MenuState extends State {
    public MenuState(StateManager ms) {
        super(ms);
    }

    public void init() {

    }

    public void update() {

    }

    public void render(Screen screen) {
        screen.drawRect(Color.cyan, 20, 20, 400, 500);
    }
}
