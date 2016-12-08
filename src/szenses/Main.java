package szenses;

import szenses.graphics.*;
import szenses.input.*;
import szenses.state.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Main extends Canvas implements Runnable {

    public static final int WIDTH = 800, HEIGHT = 900, SCALE = 2;
    public static final String TITLE = "Szenses";

    private StateManager sm;
    private Screen screen;

    private JFrame frame;
    private boolean running = false;
    private Thread thread;

    public Main() {
        sm = new StateManager();
        screen = new Screen();

        addKeyListener(new Keyboard());
        addMouseListener(new Mouse());
        addMouseMotionListener(new Mouse());
    }

    private synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while(running) {
            long lastTime = System.nanoTime();
            long timer = System.currentTimeMillis();
            final double ns = 1000000000.0/60.0;
            double delta = 0;
            int frames = 0;
            int updates = 0;

            requestFocus();

            while(running) {
                long now = System.nanoTime();
                delta += (now-lastTime) / ns;

                lastTime = now;

                while(delta >= 1) {
                    update();
                    updates++;
                    delta--;
                }

                render();
                frames++;

                if(System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("Updates: " + updates + ", FPS: " + frames);
                    frame.setTitle(TITLE + "  |  Updates: " + updates + ", FPS:" + frames);
                    updates = 0;
                    frames = 0;
                }
            }
        }
    }


    private void update() {
        Keyboard.update();
        sm.update();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();

        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        screen.setGraphics(g);
        screen.clear();

        sm.render(screen);

        g.dispose();
        bs.show();
    }

    public static final void main(String[] args) {
        Main main = new Main();

        main.frame = new JFrame(TITLE);
        main.frame.setResizable(false);
        main.frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        main.frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        main.frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.frame.add(main);
        main.frame.pack();
        main.frame.setLocationRelativeTo(null);
        main.frame.setVisible(true);

        main.start();
    }
}
