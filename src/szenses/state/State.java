package szenses.state;

import szenses.graphics.*;
import szenses.graphics.ui.*;

public abstract class State {

    protected StateManager sm;

    public State(StateManager sm) {
        this.sm = sm;
    }

    public abstract void init();
    public abstract void update();
    public abstract void render(Screen screen);

}
