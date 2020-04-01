package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleStroke extends DrawableObject{

    public CircleStroke(Color color) {
        this(0, 0, color);

    }

    public CircleStroke(double x, double y, Color color) {
        super(x, y, color);
        object = "Circle";
    }

    @Override
    public void DrawObject(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(this.color);
        graphicsContext.strokeOval(getX(), getY(),width, height);
    }
}
