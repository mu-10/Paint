import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class View extends JPanel {
    private Model model;

    private JLabel footerLabel;
    private JLabel colorLabel;

    private ArrayList<Point> points;
    private ArrayList<Color> pointColors;

    // Buttons as instance variables
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;

    public View(Model model) {
        this.model = model;

        points = new ArrayList<>();
        pointColors = new ArrayList<>();

        // Panel layout
        setLayout(new BorderLayout());

        // Panel for the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Initialize the buttons
        button1 = new JButton("Black");
        button2 = new JButton("Red");
        button3 = new JButton("Green");
        button4 = new JButton("Dot");
        button5 = new JButton("Oval");
        button6 = new JButton("Rect");
        button7 = new JButton("Undo");
        button8 = new JButton("Redo");
        button9 = new JButton("Save");
        button10 = new JButton("Load");

        // Add buttons to the panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button10);

        // Add panel to the main view
        add(panel, BorderLayout.NORTH);

        // footer panel for later
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout());
        
        footerLabel = new JLabel("Mode:");
        colorLabel = new JLabel("Using color: " + model.getSelectedColor().toString());

        footerPanel.add(footerLabel);
        footerPanel.add(colorLabel);

        add(footerPanel, BorderLayout.SOUTH);

        setBackground(Color.WHITE);  // Set background color for the view
    }

        @Override
        protected void paintComponent(Graphics g){

            super.paintComponent(g);

            for(int i = 0; i < points.size(); i++) {
                Point p = points.get(i);
                Color color = pointColors.get(i);
                g.setColor(color);
                g.fillOval(p.x - 5, p.y - 5, 10, 10);
            }
        }

        public void addDot(Point p, Color color) {
            points.add(p);
            pointColors.add(color);
            repaint();
        }
    // Getters for the buttons so Controller can add listeners
    public JButton getButton1() { 
        return button1; 
    }

    public JButton getButton2() { 
        return button2; 
    }

    public JButton getButton3() { 
        return button3; 
    }

    public JButton getButton4() { 
        return button4; 
    }

    public JButton getButton5() { 
        return button5; 
    }

    public JButton getButton6() { 
        return button6; 
    }

    public JButton getButton7() { 
        return button7; 
    }

    public JButton getButton8() { 
        return button8; 
    }

    public JButton getButton9() { 
        return button9; 
    }

    public JButton getButton10() { 
        return button10; 
    }

    public void updateColorLabel(Color color) {
    
        colorLabel.setText("Using color: " + color.toString());
    } 

    
}
