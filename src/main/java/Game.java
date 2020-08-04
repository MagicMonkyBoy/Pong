import java.awt.*;
import java.awt.image.BufferStrategy;

class Game implements Runnable {

    Display display;
    Handler handler;

    private boolean running = false;
    Thread thread;

    private int width, height;
    private String name;

    BufferStrategy bs;
    Graphics g;

    public Game(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    private void tick() {

    }

    private void render() {

    }

    private void init() {
        display = new Display(width, height, name);
        handler = new Handler(this);

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
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}