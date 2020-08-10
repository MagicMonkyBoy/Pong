import java.awt.*;
import java.awt.event.MouseEvent;

public class InvisableColliders extends GameObjects{

    Rectangle bounds;

    public InvisableColliders(float x, float y, int width, int height, Handler handler, State state) {
        super(x, y, width, height, handler, state);
        bounds = new Rectangle((int)x, (int)y, width, height);
    }

    public void tick() {
        bounds.setBounds((int) x, (int) y, width, height);
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.drawRect((int) x, (int) y, width, height);
    }

    public void onMouseMove(MouseEvent e) {

    }

}
