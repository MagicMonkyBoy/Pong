import java.awt.*;

public class MenuState extends State {

    public MenuState(Handler handler) {
        super(handler);
    }

    int x = 0, y = 0;

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
    }

    public void tick() {
        x++;
        y++;
    }
}
