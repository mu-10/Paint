import java.awt.Color;
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;

public class Model {
    public enum ShapeType { DOT, OVAL, RECT }
    
    private Color selectedColor;
    private ShapeType selectedShape;
    private Point currentStartPoint; // New addition for managing the current start point
    private ArrayList<Shape> shapes;

    public Model() {
        selectedColor = Color.BLACK;
        selectedShape = ShapeType.DOT;
        currentStartPoint = null; // Initialize to null until a point is set
        shapes = new ArrayList<>();
    }

    // Methods for managing shapes
    public void addShape(Point start, Point end) {
        shapes.add(new Shape(start, end, selectedColor, selectedShape));
    }

    public void removeLastShape() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
        }
    }

    // Color and shape selection management
    public void setCurrentColor(Color color) {
        this.selectedColor = color;
    }

    public void setCurrentShapeType(ShapeType shape) {
        this.selectedShape = shape;
    }

    // Current drawing state management
    public void setCurrentStartPoint(Point start) {
        this.currentStartPoint = start;
    }

    public Point getCurrentStartPoint() {
        return currentStartPoint;
    }

    public Color getSelectedColor() {
    return selectedColor;
    }

    public ShapeType getCurrentShapeType() {
        return selectedShape;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    // Methods for saving and loading shapes
    public void saveToFile(String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(shapes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            shapes = (ArrayList<Shape>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
