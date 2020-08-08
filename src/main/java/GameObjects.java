import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class GameObjects {

    protected float x, y;
    protected int width, height;
    protected State state;
    protected Rectangle bounds;
    Handler handler;

    public GameObjects (float x, float y, int width, int height, Handler handler, State state) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
        this.state = state;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void onMouseMove(MouseEvent e);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
