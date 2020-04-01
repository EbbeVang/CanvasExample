package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectStroke extends DrawableObject{

    public RectStroke(Color color) {
        this(0, 0, color);
    }

    public RectStroke(double x, double y, Color color) {
        super(x, y, color);
        object = "Rectangle";
    }

    @Override
    public void DrawObject(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(this.color);
        graphicsContext.strokeRect(x, y, width, height);
    }
}
