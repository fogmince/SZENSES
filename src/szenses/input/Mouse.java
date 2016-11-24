package szenses.input;

import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener {

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        mouseB = e.getButton();
    }

    public void mouseReleased(MouseEvent e) {
        mouseB = -1;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public static int getX() {
        return mouseX;
    }

    public static int getY() {
        return mouseY;
    }

    public static int getButton() {
        return mouseB;
    }
}
