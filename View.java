import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class View extends JPanel {
    private Model model;
    private JLabel footerLabel;
    private JLabel colorLabel;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button9;
    private JButton button10;

    public View(Model model) {
        this.model = model;

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        button1 = new JButton("Black");
        button2 = new JButton("Red");
        button3 = new JButton("Green");
        button4 = new JButton("Dot");
        button5 = new JButton("Oval");
        button6 = new JButton("Rect");
        button7 = new JButton("Undo");
        button9 = new JButton("Save");
        button10 = new JButton("Load");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button9);
        panel.add(button10);

        add(panel, BorderLayout.NORTH);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout());

        footerLabel = new JLabel("Mode:");
        colorLabel = new JLabel("Using color: " + model.getSelectedColor().toString());

        footerPanel.add(footerLabel);
        footerPanel.add(colorLabel);

        add(footerPanel, BorderLayout.SOUTH);

        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Point> startPoints = model.getStartPoints();
        ArrayList<Point> endPoints = model.getEndPoints();
        ArrayList<Color> pointColors = model.getPointColors();
        ArrayList<Model.ShapeType> shapes = model.getShapes();

        for (int i = 0; i < startPoints.size(); i++) {
            g.setColor(pointColors.get(i));
            Point start = startPoints.get(i);
            Point end = endPoints.get(i);
            int width = Math.abs(end.x - start.x);
            int height = Math.abs(end.y - start.y);

            switch (shapes.get(i)) {
                case DOT:
                    g.fillOval(start.x - 5, start.y - 5, 10, 10);
                    break;
                case OVAL:
                    g.fillOval(Math.min(start.x, end.x), Math.min(start.y, end.y), width, height);
                    break;
                case RECT:
                    g.fillRect(Math.min(start.x, end.x), Math.min(start.y, end.y), width, height);
                    break;
            }
        }
    }

    public JButton getButton1() { return button1; }
    public JButton getButton2() { return button2; }
    public JButton getButton3() { return button3; }
    public JButton getButton4() { return button4; }
    public JButton getButton5() { return button5; }
    public JButton getButton6() { return button6; }
    public JButton getButton7() { return button7; }
    public JButton getButton9() { return button9; }
    public JButton getButton10() { return button10; }

    public void updateColorLabel(Color color) {
        colorLabel.setText("Using color: " + color.toString());
    }
}
