import java.awt.*;

public class MenuState extends State {

    UIManager uiManager;

    TextButton startButton;
    TextButton exitButton;
    GameState gameState;

    public MenuState(final Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);


        startButton =  new TextButton(handler.getWidth()/2 - 100, handler.getHeight()/2 - 50, 200, 50, handler, Color.WHITE, new ClickListener() {
            public void onClick() {
                System.out.println("HELLO button works");
                gameState = null;
                gameState = new GameState(handler);
                State.setState(gameState);
            }
        }, this);
        startButton.setText("Start", Color.BLACK);
        startButton.setHoverButtonColor(Color.LIGHT_GRAY);

        exitButton = new TextButton(handler.getWidth() / 2 - 100, handler.getHeight() / 2 + 10, 200, 50, handler, Color.WHITE, new ClickListener() {
            public void onClick() {
                handler.getGame().stop();
            }
        }, this);
        exitButton.setText("Exit", Color.BLACK);
        exitButton.setHoverButtonColor(Color.LIGHT_GRAY);

        uiManager.addObject(exitButton);
        uiManager.addObject(startButton);
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
