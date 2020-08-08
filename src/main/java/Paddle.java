import java.awt.*;
import java.awt.event.MouseEvent;

public class Paddle extends GameObjects {

    Color color;
    MouseMoveListener mouseMoveListener;

    public Paddle(int x, int y, int width, int height, Handler handler, MouseMoveListener mouseMoveListener, State state) {
        super(x, y, width, height, handler, state);
        this.mouseMoveListener = mouseMoveListener;

        bounds = new Rectangle((int)x, (int)y, width, height);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void tick() {
        bounds.setBounds((int)x, (int)y, width, height);
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int)x, (int)y, width, height);

        g.setColor(Color.RED);
        g.drawRect((int)x, (int)y, width, height);
    }

    public void onMouseMove(MouseEvent e) {
        mouseMoveListener.move(e.getX(), e.getY() - height/2);
    }

    public Rectangle getBounds() {
        return bounds;
    }

}
