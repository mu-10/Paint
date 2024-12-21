import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.awt.Point;

public class Controller extends JFrame {
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View(model);
        add(view);

        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton sourceButton = (JButton) e.getSource();

                if (sourceButton == view.getButton1()) {
                    model.setCurrentColor(Color.BLACK);
                    view.updateColorLabel(Color.BLACK);

                } else if (sourceButton == view.getButton2()) {
                    model.setCurrentColor(Color.RED);
                    view.updateColorLabel(Color.RED);

                } else if (sourceButton == view.getButton3()) {
                    model.setCurrentColor(Color.GREEN);
                    view.updateColorLabel(Color.GREEN);

                } else if (sourceButton == view.getButton4()) {
                    model.setCurrentShapeType(Model.ShapeType.DOT);

                } else if (sourceButton == view.getButton5()) {
                    model.setCurrentShapeType(Model.ShapeType.OVAL);

                } else if (sourceButton == view.getButton6()) {
                    model.setCurrentShapeType(Model.ShapeType.RECT);

                } else if (sourceButton == view.getButton7()) {
                    undoLastAction();

                } else if (sourceButton == view.getButton9()) {
                    saveDrawing();

                } else if (sourceButton == view.getButton10()) {
                    loadDrawing();
                }
            }
        };

        // Add action listeners for the buttons
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
                model.setCurrentStartPoint(e.getPoint()); // Update the current start point in the model
            }

            public void mouseReleased(MouseEvent e) {
                Point endPoint = e.getPoint(); 
                model.addShape(model.getCurrentStartPoint(), endPoint); // Retrieve and use model's state
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
