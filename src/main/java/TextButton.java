import java.awt.*;

public class TextButton extends UIObjects {

    private Handler handler;
    private String text;
    private boolean hasText;
    private Color buttonColor, hoverColor, textColor;
    private Font font;
    private ClickListener clickListener;
    private boolean setHover = false;

    public TextButton(float x, float y, int width, int height, Handler handler, Color buttonColor, ClickListener clickListener) {
        super(x, y, width, height, handler);

        this.buttonColor = buttonColor;
        this.clickListener = clickListener;
    }

    public void setText(String text, Color textColor) {
        this.text = text;
        this.textColor = textColor;
        //this.font = font;
        hasText = true;
    }

    public void setHoverButtonColor(Color hoverColor) {
        this.hoverColor = hoverColor;
        setHover = true;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        if (setHover && hovering) {
            g.setColor(hoverColor);
        } else {
            g.setColor(buttonColor);
        }
        g.fillRect((int)x, (int)y, width, height);
        if (hasText) {
            g.setColor(textColor);
            //g.setFont(font);
            g.drawString(text, (int)x + width/2 - g.getFontMetrics().stringWidth(text)/2, (int)y + height/2);
        }
    }

    public void onClick() {
        clickListener.onClick();
    }
}
