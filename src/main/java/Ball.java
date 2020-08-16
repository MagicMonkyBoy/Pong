import java.awt.*;
import java.awt.event.MouseEvent;

public class Ball extends GameObjects {

    private Color color;
    private double speed;
    private double angle;                   //in degrees
    private boolean hasColor = false;
    private GameObjectManager gameObjectManager;
    private double maxAngle = 60;
    private boolean isWithin = false;

    public Ball (float x, float y, int width, int height, Handler handler, State state, double speed, double angle) {
        super(x, y, width, height, handler, state);
        this.speed = speed;
        this.angle = angle;
        bounds = new Rectangle((int)x, (int)y, width, height);

    }

    public void tick() {

        while (angle >= 360) {
            angle -= 360;
        }
        while (angle < 0) {
            angle += 360;
        }

        x += speed * Math.cos(angle * (Math.PI/180));
        y -= speed * Math.sin(angle * (Math.PI/180));

        bounds.setBounds((int) x, (int) y, width, height);
    }

    public void render(Graphics g) {
        if (hasColor) {
            g.setColor(color);
        } else {
            g.setColor(Color.PINK);
        }
        g.fillOval((int) x, (int) y, width, height);

//        g.setColor(Color.RED);
//        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

    }

    public void onMouseMove(MouseEvent e) {

    }

    public void setColor(Color color) {
        this.color = color;
        hasColor = true;
    }

    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }

}
