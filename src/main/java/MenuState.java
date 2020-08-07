import java.awt.*;

public class MenuState extends State {

    UIManager uiManager;

    TextButton test;
    public MenuState(final Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);


         test =  new TextButton(handler.getWidth()/2 - 100, handler.getHeight()/2 - 50, 200, 50, handler, Color.WHITE, new ClickListener() {
            public void onClick() {
                System.out.println("HELLO button works");
                State.setState(new GameState(handler));
            }
        }, this);
         test.setText("Start", Color.BLACK);
         test.setHoverButtonColor(Color.LIGHT_GRAY);
        uiManager.addObject(test);
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0 ,0, handler.getWidth(), handler.getHeight());

        uiManager.render(g);
    }

    public void tick() {
        uiManager.tick();


    }

    public UIManager getUIManager() {
        return uiManager;
    }
}
