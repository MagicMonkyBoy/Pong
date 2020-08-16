import java.awt.*;
import java.awt.image.BufferStrategy;

class Game implements Runnable {

    private Display display;
    private Handler handler;

    private boolean running = false;
    private Thread thread;

    private int width, height;
    private String name;

    private BufferStrategy bs;
    private Graphics g;

    public MenuState menuState;
    public GameState gameState;

    private MouseManager mouseManager;

    public Game(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
        mouseManager = new MouseManager();
    }

    private void tick() {
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0, 0, width, height);

        if (State.getState() != null) {
            State.getState().render(g);
        }

        bs.show();
        g.dispose();
    }

    private void init() {
        display = new Display(width, height, name);
        handler = new Handler(this);

        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        menuState = new MenuState(handler);
        State.setState(menuState);
    }

    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        else {
            running = true;
        }
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        System.exit(0);
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}