package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class DrawableObject{
    protected int x;
    protected int y;
    protected int height;
    protected int width;
    protected Color color;
    protected String object;

    public DrawableObject(Color color) {

        this.height = 10;
        this.width = 20;
        this.color = color;
    }

    public DrawableObject(double x, double y, Color color) {
        this(color);
        this.setX((int)x);
        this.setY((int)y);
    }

    public String getObject() {
        return object;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(double x) {
        this.x = (int)x;
    }

    public void setY(double y) {
        this.y =(int)y;
    }

    public void setHeight(double height) {
        this.height = (int)height;
    }

    public void setWidth(double width) {
        this.width = (int) width;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public abstract void  DrawObject(GraphicsContext graphicsContext);

    public void setX(int x) {
        this.x=x;
    }

    public void setY(int y) {
        this.y=y;
    }

    @Override
    public String toString() {
        return "DrawableObject{" +
                "x=" + x +
                ", y=" + y +
                ", height=" + height +
                ", width=" + width +
                ", color=" + color +
                ", object='" + object + '\'' +
                '}';
    }
}
