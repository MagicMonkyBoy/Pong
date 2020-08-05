public class Handler {

    private Game game;

    public Handler(Game game) {
        this.game = game;
    }

    public int getWidth() {
        return game.getWidth();
    }
    public int getHeight() {
        return game.getHeight();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }
}
