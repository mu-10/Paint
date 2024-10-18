import java.awt.*;
import javax.swing.*;

public class View extends JPanel {
    private Model model;

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
        JLabel footerLabel = new JLabel("State");
        footerPanel.add(footerLabel);

        add(footerPanel, BorderLayout.SOUTH);

        setBackground(Color.WHITE);  // Set background color for the view
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
}
