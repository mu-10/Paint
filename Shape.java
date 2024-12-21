import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class Shape implements Serializable {
    private Point startPoint;
    private Point endPoint;
    private Color color;
    private Model.ShapeType shapeType;

    public Shape(Point startPoint, Point endPoint, Color color, Model.ShapeType shapeType) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = color;
        this.shapeType = shapeType;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Color getColor() {
        return color;
    }

    public Model.ShapeType getShapeType() {
        return shapeType;
    }
}
