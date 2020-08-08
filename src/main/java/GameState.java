import java.awt.*;

public class GameState extends State{

    private GameObjectManager gameObjectManager;
    private Paddle leftPaddle, rightPaddle;
    private Ball ball;
    private CollisionDetector collisionDetector;

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


        rightPaddle = new Paddle(handler.getWidth() - 30, handler.getHeight() / 2, 80, 120, handler, new MouseMoveListener() {
            public void move(int x, int y) {
                rightPaddle.setY(y);
            }
        }, this);
        rightPaddle.setColor(Color.WHITE);
        gameObjectManager.addGameObject(rightPaddle);


        ball = new Ball(handler.getWidth()/2 - 10, handler.getHeight()/2 - 10, 20, 20, handler, this, 4, 0);
        ball.setColor(Color.white);
        gameObjectManager.addGameObject(ball);

        collisionDetector = new CollisionDetector(handler, new CollisionListener() {
            public void collision(GameObjects collider, GameObjects collidee) {
                //System.out.println("Collision");
                if (collider.equals(ball) && collidee.equals(leftPaddle) && (ball.getAngle() > 90 || ball.getAngle() < 270)) {
                    ball.setAngle(180 - ball.getAngle());
                }
                if (collider.equals(ball) && collidee.equals(rightPaddle) && (ball.getAngle() < 90 || ball.getAngle() > 270)) {
                    ball.setAngle(180 - ball.getAngle());
                }
            }
        });
        collisionDetector.addGameObject(ball);
        collisionDetector.addGameObject(leftPaddle);
        collisionDetector.addGameObject(rightPaddle);
    }


    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
        gameObjectManager.render(g);
    }

    public void tick() {
        gameObjectManager.tick();
        collisionDetector.tick();
    }

    public GameObjectManager getGameObjectManager() {
        return gameObjectManager;
    }
}
