import java.util.ArrayList;

public class CollisionDetector {

    private ArrayList<GameObjects> colliderGameObjects;
    private CollisionListener collisionListener;
    private boolean offScreenBounds = false;
    private Handler handler;


    public CollisionDetector(Handler handler, CollisionListener collisionListener) {
        colliderGameObjects = new ArrayList<GameObjects>();
        this.collisionListener = collisionListener;
        this.handler = handler;
    }

    public void tick() {
        for (GameObjects go1: colliderGameObjects) {
            for (GameObjects go2: colliderGameObjects) {
                try {
                    if (!go1.equals(go2) && go1.bounds.intersects(go2.bounds)) {
                        collisionListener.collision(go1, go2);
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace(); 
                }
            }
        }
        if (offScreenBounds) {

            for (GameObjects go1: colliderGameObjects) {
                try {

                    if (go1.bounds.y < 0) {
                        //System.out.println("YAYAYAYAYYA");
                        collisionListener.collision(go1, "NORTH");
                    }
                    if (go1.bounds.y + go1.bounds.height > handler.getHeight()) {
                        collisionListener.collision(go1, "SOUTH");
                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addGameObject(GameObjects gameObject) {
        colliderGameObjects.add(gameObject);
    }

    public void setOffScreenBounds() {
        offScreenBounds = true;
    }

    public void removeGameObject(GameObjects gameObject) {
        colliderGameObjects.remove(gameObject);
    }

}
