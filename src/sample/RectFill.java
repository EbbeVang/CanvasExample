package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectFill extends DrawableObject{

    public RectFill(Color color) {
        this(0, 0, color);

    }

    public RectFill(double x, double y, Color color) {
        super(x, y, color);
        object = "Rectangle Filled";
    }

    @Override
    public void DrawObject(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(this.color);
        graphicsContext.setFill(this.color);
        graphicsContext.fillRect(x, y, width, height);
    }
}
