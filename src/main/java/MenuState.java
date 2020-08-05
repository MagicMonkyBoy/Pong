import java.awt.*;

public class MenuState extends State {

    Handler handler;

    public MenuState(Handler handler) {
        super(handler);
        this.handler = handler;
    }

    int x = 0, y = 0;

    public void render(Graphics g) {

        if (handler.getMouseManager().isLeftPressed()) {
            g.setColor(Color.RED);
        } else if (handler.getMouseManager().isRightPressed()) {
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.GREEN);
        }
        g.fillRect(x - 100, y - 100, 200, 200);
    }

    public void tick() {
        x = handler.getMouseManager().getMouseX();
        y = handler.getMouseManager().getMouseY();
    }
}
