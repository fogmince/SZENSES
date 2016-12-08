package szenses.graphics.ui;

import szenses.graphics.*;
import szenses.graphics.ui.components.*;

public abstract class UI {

    public UIHandler handler;

    public UI() {
        handler = new UIHandler();
    }

    public abstract void update();
    public abstract void render(Screen screen);

    public void addButton(UIButton b) {
        handler.addComponent(b);
    }

}
