import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;

    public MouseManager() {

    }

    public boolean isLeftPressed() {
        return leftPressed;
    }
    public boolean isRightPressed() {
        return rightPressed;
    }
    public int getMouseX() {
        return mouseX;
    }
    public int getMouseY() {
        return mouseY;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
//			System.out.println("Left");
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = true;
//			System.out.println("Right");
        }
    }

    public void mouseReleased(MouseEvent e) {


        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = false;
//			System.out.println("Left");
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = false;
//			System.out.println("Right");
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        if (State.getState() != null) {

        }

        mouseX = e.getX();
        mouseY = e.getY();
    }
}
