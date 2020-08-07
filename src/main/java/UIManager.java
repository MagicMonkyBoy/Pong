import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {

    Handler handler;
    private ArrayList<UIObjects> objects;

    public UIManager(Handler handler) {
        this.handler = handler;
        objects = new ArrayList<UIObjects>();
    }

    public void tick() {
        for (UIObjects o: objects) {
            o.tick();
        }
    }

    public void render(Graphics g) {
        for (UIObjects o: objects) {
            o.render(g);
        }
    }

    public void onMouseMove(MouseEvent e) {
        for (UIObjects o: objects) {
            o.onMouseMove(e);
        }
    }

    public void onMouseRelease(MouseEvent e) {
        for (UIObjects o: objects) {
            o.onMouseRelease(e);
        }
    }

    public void addObject(UIObjects o) {
        objects.add(o);
    }

    public void removeObject(UIObjects o) {
        objects.remove(o);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObjects> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObjects> objects) {
        this.objects = objects;
    }

}
