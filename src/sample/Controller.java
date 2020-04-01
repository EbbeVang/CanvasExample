package sample;

import com.sun.javafx.collections.ElementObservableListDecorator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Controller {


    @FXML
    TableView<DrawableObject> tableView;
    @FXML
    Label labelPointerPos;
    @FXML
    Button btnCircleStroke;
    @FXML
    Button btnCircleFill;
    @FXML
    Button btnRectStroke;
    @FXML
    Button btnRectFill;
    @FXML
    Canvas canvas;
    @FXML
    ColorPicker colorPicker;
    @FXML
    TableColumn<DrawableObject, String> col_object;
    @FXML
    TableColumn<DrawableObject, Integer> col_x;
    @FXML
    TableColumn<DrawableObject, Integer> col_y;
    @FXML
    TableColumn<DrawableObject, Integer> col_height;
    @FXML
    TableColumn<DrawableObject, Integer> col_width;
    @FXML
    TextField widthValue;
    @FXML
    TextField heightValue;

    boolean trackMouse = false;
    Color selectedColor = Color.BLACK;
    DrawableObject selectedTool;
    ObservableList<DrawableObject> drawables = FXCollections.observableArrayList();
    GraphicsContext graphicsContext;


    public void initialize()
    {
        graphicsContext = canvas.getGraphicsContext2D();
        heightValue.setText("20");
        widthValue.setText("20");

    }

    public void canvasChanged()
    {
        for (DrawableObject drawable: tableView.getItems()){
            System.out.println(drawable);
        }
    }

    public void mouseOverCanvas(MouseEvent mouseEvent)
    {
        labelPointerPos.setText("X: "+mouseEvent.getX() + " Y: "+mouseEvent.getY());
    }

    public void canvasMouseClicked(MouseEvent mouseEvent)
    {
        selectedTool.setColor(selectedColor);
        selectedTool.setX(mouseEvent.getX());
        selectedTool.setY(mouseEvent.getY());
        selectedTool.setWidth(Integer.parseInt(widthValue.getText()));
        selectedTool.setHeight(Integer.parseInt(heightValue.getText()));
        drawables.add(selectedTool);
        tableView.getItems().add(selectedTool);
        selectedTool.DrawObject(graphicsContext);
        switch (selectedTool.object){
            case "Rectangle Filled":
                selectedTool = new RectFill(selectedColor);
                break;
            case "Rectangle":
                selectedTool = new RectStroke(selectedColor);
                break;
            case "Circle":
                selectedTool = new CircleStroke(selectedColor);
                break;
            case "Circle Filled":
                selectedTool = new CircleFill(selectedColor);
                break;
        }
        System.out.println(selectedTool);
    }

    public void mouseEnterCanvas()
    {
        trackMouse = true;
    }

    public void mouseLeaveCanvas()
    {
        trackMouse = false;
    }

    public void selectCircleFill()
    {
        selectedTool = new CircleFill(selectedColor);
        System.out.println("Selected circle fill");
    }

    public void selectCircleStroke()
    {
        selectedTool = new CircleStroke(selectedColor);
        System.out.println("selected circle stroke");
    }

    public void selectRectFill()
    {
        selectedTool = new RectFill(selectedColor);
        System.out.println("selected rect fill");
    }

    public void selectRectStroke()
    {
        selectedTool = new RectStroke(selectedColor);
        System.out.println("selected rect stroke");
    }

    public void setSelectedColorColor()
    {

        System.out.println(colorPicker.getValue());
        this.selectedColor = colorPicker.getValue();
    }
}
