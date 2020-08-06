import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObjects {

    protected float x, y;
    protected int width, height;
    Handler handler;


    public UIObjects(float x, float y, int width, int height, Handler handler) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void onMouseMove(MouseEvent e);

    public abstract void onMouseRelease(MouseEvent e);


}
