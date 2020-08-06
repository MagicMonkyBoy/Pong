import java.awt.*;

public class MenuState extends State {

    UIManager uiManager;

    Handler handler;

    public MenuState(Handler handler) {
        super(handler);
        this.handler = handler;
        uiManager = new UIManager(handler);
    }

    public void render(Graphics g) {
        uiManager.render(g);
    }

    public void tick() {
        uiManager.tick();
    }

    public UIManager getUIManager() {
        return uiManager;
    }
}
