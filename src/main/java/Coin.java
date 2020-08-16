import java.awt.*;
import java.awt.event.MouseEvent;

public class Coin extends GameObjects {

    private boolean hasColor = false;
    private Color color;

    public Coin (float x, float y, int width, int height, Handler handler, State state) {
        super(x, y, width, height, handler, state);
        bounds = new Rectangle((int)x, (int)y, width, height);

    }

    public void tick() {
        bounds.setBounds((int) x, (int) y, width, height);
    }

    public void render(Graphics g) {
        if (hasColor) {
            g.setColor(color);
        } else {
            g.setColor(Color.PINK);
        }
        g.fillOval((int) x, (int) y, width, height);

        g.setColor(Color.RED);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public void setColor(Color color) {
        this.color = color;
        hasColor = true;
    }

    public void onMouseMove(MouseEvent e) {

    }
}
