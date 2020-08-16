import java.awt.*;

public class Text extends UIObjects {

    private Color textColor;
    private String text;

    public Text(float x, float y, int width, int height, Handler handler, Color textColor, String text, State state) {
        super(x, y, width, height, handler, state);
        this.text = text;
        this.textColor = textColor;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(textColor);
        g.drawString(text, (int)x, (int)y);
    }

    public void onClick() {

    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setColor(Color color) {
        this.textColor = color;
    }
}
