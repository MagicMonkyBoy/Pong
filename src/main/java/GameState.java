import java.awt.*;

public class GameState extends State{

    private GameObjectManager gameObjectManager;
    private Paddle leftPaddle, rightPaddle;
    private Ball ball;
    private CollisionDetector collisionDetector;
    private float maxAngle = 180; // IN DEGREES

    public GameState (final Handler handler) {
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


        ball = new Ball(handler.getWidth()/2 - 10, handler.getHeight()/2 - 10, 20, 20, handler, this, 10, 1);
        ball.setColor(Color.white);
        gameObjectManager.addGameObject(ball);

//        topBoundry = new InvisableColliders(0, -1, handler.getWidth(), 1, handler, this);
//        gameObjectManager.addGameObject(topBoundry);

        collisionDetector = new CollisionDetector(handler, new CollisionListener() {

            //OBJECT COLLISION
            public void collision(GameObjects collider, GameObjects collidee) {
                //System.out.println("Collision");


                //BALL TRAVELLING LEFTWARDS
                if (collider.equals(ball) && collidee.equals(leftPaddle) && (ball.getAngle() > 90 || ball.getAngle() < 270)) {
                    //System.out.println("Left");
                    //BALL GOING UP
                    if (ball.getAngle() < 180) {
                        double dif = collidee.bounds.getCenterY() - ball.bounds.getCenterY();
                        ball.setAngle((maxAngle*Math.abs(dif))/collidee.getHeight()/2);
                    }
                    //BALL GOING DOWN
                    if (ball.getAngle() > 180) {
                        double dif = collidee.bounds.getCenterY() - ball.bounds.getCenterY();
                        ball.setAngle((maxAngle*-1*Math.abs(dif))/collidee.getHeight()/2);
                    }

                    //ball.setAngle(180 - ball.getAngle());
                }
                //BALL TRAVELLING RIGHTWARDS
                if (collider.equals(ball) && collidee.equals(rightPaddle) && (ball.getAngle() < 90 || ball.getAngle() > 270)) {
                    //System.out.println("Right");
                    //BALL GOING UP
                    if (ball.getAngle() < 90) {
                        double dif = collidee.bounds.getCenterY() - ball.bounds.getCenterY();
                        ball.setAngle(180 - ((maxAngle*Math.abs(dif))/collidee.getHeight()/2));
                    }
                    //BALL GOING DOWN
                    if (ball.getAngle() > 270) {
                        double dif = collidee.bounds.getCenterY() - ball.bounds.getCenterY();
                        ball.setAngle(180 - ((maxAngle*-1*Math.abs(dif))/collidee.getHeight()/2));
                    }
                    //ball.setAngle(180 - ball.getAngle());
                }
            }

            //OUT OF SCREEN
            public void collision(GameObjects collider, String compassDirection) {
                //System.out.println("OFF SCREEN");
                if (collider.equals(ball)) {
                    if (compassDirection.equals("NORTH") || compassDirection.equals("SOUTH")) {
                        ball.setAngle(360 - ball.getAngle());
                    } else if (compassDirection.equals("WEST") || compassDirection.equals("EAST")) {
                        State.setState(new MenuState(handler));
                    }
                } else if (collider.equals(leftPaddle) || collider.equals(rightPaddle)) {
                    if (compassDirection.equals("NORTH")) {
                        collider.setY(0);
                    } else if (compassDirection.equals("SOUTH")) {
                        collider.setY(handler.getHeight() - collider.getHeight());
                    }
                }

            }
        });
        collisionDetector.setOffScreenBounds();
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
