import java.awt.Color;
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;

public class Model {
    public enum ShapeType { DOT, OVAL, RECT }
    private Color selectedColor;
    private ShapeType selectedShape;
    private ArrayList<Point> startPoints;
    private ArrayList<Point> endPoints;
    private ArrayList<Color> pointColors;
    private ArrayList<ShapeType> shapes;

    public Model() {
        selectedColor = Color.BLACK;
        selectedShape = ShapeType.DOT;
        startPoints = new ArrayList<>();
        endPoints = new ArrayList<>();
        pointColors = new ArrayList<>();
        shapes = new ArrayList<>();
    }

    public void setSelectedColor(Color color) {
        this.selectedColor = color;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedShape(ShapeType shape) {
        this.selectedShape = shape;
    }

    public ShapeType getSelectedShape() {
        return selectedShape;
    }

    public void addShape(Point start, Point end, Color color, ShapeType shape) {
        startPoints.add(start);
        endPoints.add(end);
        pointColors.add(color);
        shapes.add(shape);
    }

    public void removeLastShape() {
        if (!startPoints.isEmpty()) {
            startPoints.remove(startPoints.size() - 1);
            endPoints.remove(endPoints.size() - 1);
            pointColors.remove(pointColors.size() - 1);
            shapes.remove(shapes.size() - 1);
        }
    }

    public ArrayList<Point> getStartPoints() {
        return startPoints;
    }

    public ArrayList<Point> getEndPoints() {
        return endPoints;
    }

    public ArrayList<Color> getPointColors() {
        return pointColors;
    }

    public ArrayList<ShapeType> getShapes() {
        return shapes;
    }

    public void saveToFile(String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(startPoints);
            out.writeObject(endPoints);
            out.writeObject(pointColors);
            out.writeObject(shapes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            startPoints = (ArrayList<Point>) in.readObject();
            endPoints = (ArrayList<Point>) in.readObject();
            pointColors = (ArrayList<Color>) in.readObject();
            shapes = (ArrayList<ShapeType>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
