package szenses.state;

import szenses.graphics.*;

import java.util.*;

public class StateManager {

    private List<State> states = new ArrayList<>();

    private int currentState;

    public static final int MENU_STATE = 0;
    public static final int SEARCH_STATE = 1;
    public static final int MAP_STATE = 2;

    public StateManager() {
        states.add(new MenuState(this));
        states.add(new SearchState(this));

        currentState = MENU_STATE;
        states.get(currentState).init();
    }

    public void update() {
        states.get(currentState).update();
    }

    public void render(Screen screen) {
        states.get(currentState).render(screen);
    }

    public void setState(int state) {
        currentState = state;
        states.get(currentState).init();
    }
}
