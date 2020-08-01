import javax.swing.*;
import java.awt.*;

public class Display extends Canvas{

    JFrame frame;
    Canvas canvas;
    Graphics g;
    int framerate;

    public Display(int width, int height, int framerate) {
        this.framerate = framerate;
        frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Canvas canvas = this;
        canvas.setSize(width, height);
        canvas.setBackground(Color.black);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

    }

    int i = 0;

    public void paint(Graphics g) {
        i++;
        g.setColor(Color.red);
        g.fillRect(0 + i, 0 + i, 30, 30);
    }
}
