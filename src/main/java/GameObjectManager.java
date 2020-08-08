import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameObjectManager {

    ArrayList<GameObjects> gameObjects;
    Handler handler;

    public GameObjectManager (Handler handler) {
        this.handler = handler;
        gameObjects = new ArrayList<GameObjects>();
    }

    public void tick() {
        for (GameObjects go : gameObjects) {
            go.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObjects go : gameObjects) {
            go.render(g);
        }
    }

    public void addGameObject(GameObjects gameObject) {
        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObjects gameObject) {
        gameObjects.remove(gameObject);
    }

    public void onMouseMove(MouseEvent e) {
        for (GameObjects go : gameObjects) {
            if (go.state == State.getState()) {
                go.onMouseMove(e);
                //System.out.println("YA YA YA ");
            }
        }
    }

    public ArrayList<GameObjects> getGameObjects() {
        return gameObjects;
    }
}
