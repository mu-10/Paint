import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.awt.Point;

public class Controller extends JFrame {
    private Model model;
    private View view;
    private Point startPoint; // Starting point for oval/rectangle drawing

    public Controller() {
        model = new Model();
        view = new View(model);
        add(view);

        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton sourceButton = (JButton) e.getSource();

                if (sourceButton == view.getButton1()) {
                    model.setSelectedColor(Color.BLACK);
                    view.updateColorLabel(Color.BLACK);

                } else if (sourceButton == view.getButton2()) {
                    model.setSelectedColor(Color.RED);
                    view.updateColorLabel(Color.RED);

                } else if (sourceButton == view.getButton3()) {
                    model.setSelectedColor(Color.GREEN);
                    view.updateColorLabel(Color.GREEN);

                } else if (sourceButton == view.getButton4()) {
                    model.setSelectedShape(Model.ShapeType.DOT);

                } else if (sourceButton == view.getButton5()) {
                    model.setSelectedShape(Model.ShapeType.OVAL);

                } else if (sourceButton == view.getButton6()) {
                    model.setSelectedShape(Model.ShapeType.RECT);

                } else if (sourceButton == view.getButton7()) {
                    undoLastAction();

                } else if (sourceButton == view.getButton9()) {
                    saveDrawing();

                } else if (sourceButton == view.getButton10()) {
                    loadDrawing();
                }
            }
        };

        view.getButton1().addActionListener(buttonListener);
        view.getButton2().addActionListener(buttonListener);
        view.getButton3().addActionListener(buttonListener);
        view.getButton4().addActionListener(buttonListener);
        view.getButton5().addActionListener(buttonListener);
        view.getButton6().addActionListener(buttonListener);
        view.getButton7().addActionListener(buttonListener);
        view.getButton9().addActionListener(buttonListener);
        view.getButton10().addActionListener(buttonListener);

        // Mouse listeners for capturing points and drawing shapes
        view.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint(); // Capture the starting point
            }

            public void mouseReleased(MouseEvent e) {
                Point endPoint = e.getPoint(); // Capture the end point on release

                // Add the shape with start and end points, selected color, and selected shape
                model.addShape(startPoint, endPoint, model.getSelectedColor(), model.getSelectedShape());
                view.repaint();
            }
        });

        setTitle("Paint");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void undoLastAction() {
        model.removeLastShape();
        view.repaint();
    }

    private void saveDrawing() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            model.saveToFile(file.getAbsolutePath());
        }
    }

    private void loadDrawing() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            model.loadFromFile(file.getAbsolutePath());
            view.repaint();
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
