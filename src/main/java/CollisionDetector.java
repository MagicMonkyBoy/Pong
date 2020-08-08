import java.util.ArrayList;

public class CollisionDetector {

    private ArrayList<GameObjects> colliderGameObjects;
    private CollisionListener collisionListener;


    public CollisionDetector(Handler handler, CollisionListener collisionListener) {
        colliderGameObjects = new ArrayList<GameObjects>();
        this.collisionListener = collisionListener;
    }

    public void tick() {
        for (GameObjects go1: colliderGameObjects) {
            for (GameObjects go2: colliderGameObjects) {
                if (!go1.equals(go2) && go1.bounds.intersects(go2.bounds)) {
                    collisionListener.collision(go1, go2);
                }
            }
        }
    }

    public void addGameObject(GameObjects gameObject) {
        colliderGameObjects.add(gameObject);
    }

    public void setOffScreenBounds() {

    }

    public void removeGameObject(GameObjects gameObject) {
        colliderGameObjects.remove(gameObject);
    }

}
