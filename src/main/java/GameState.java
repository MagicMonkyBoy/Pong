import java.awt.*;

public class GameState extends State{

    GameObjectManager gameObjectManager;
    Paddle leftPaddle, rightPaddle;

    public GameState (Handler handler) {
        super(handler);
        gameObjectManager = new GameObjectManager(handler);
        handler.getGame().getMouseManager().setGameObjectManager(gameObjectManager);

        leftPaddle = new Paddle(10, handler.getHeight() / 2, 20, 120, handler, new MouseMoveListener() {
            public void move(int x, int y) {
                leftPaddle.setY(y);
            }
        }, this);
        leftPaddle.setColor(Color.WHITE);
        gameObjectManager.addGameObject(leftPaddle);

        rightPaddle = new Paddle(handler.getWidth() - 30, handler.getHeight() / 2, 20, 120, handler, new MouseMoveListener() {
            public void move(int x, int y) {
                rightPaddle.setY(y);
            }
        }, this);
        rightPaddle.setColor(Color.WHITE);
        gameObjectManager.addGameObject(rightPaddle);
    }


    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
        gameObjectManager.render(g);
    }

    public void tick() {
        gameObjectManager.tick();
    }
}
