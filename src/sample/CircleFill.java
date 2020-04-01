package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleFill extends DrawableObject {

    public CircleFill (Color color) {
        this(0,0, color);
    }

    public CircleFill(double x, double y, Color color) {
        super(x, y, color);
        object = "Circle Filled";
    }

    @Override
    public void DrawObject(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(this.color);
        graphicsContext.setFill(this.color);
        graphicsContext.fillOval(x, y, width, height);
    }

}
