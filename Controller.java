import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

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
                        Button1Pressed(e);  
                    } else if (sourceButton == view.getButton2()) {
                        Button2Pressed(e);  
                    } else if (sourceButton == view.getButton3()) {
                        Button3Pressed(e);  
                    } else if (sourceButton == view.getButton4()) {
                        Button4Pressed(e);  
                    } else if (sourceButton == view.getButton5()) {
                        Button5Pressed(e);  
                    } else if (sourceButton == view.getButton6()) {
                        Button6Pressed(e);  
                    } else if (sourceButton == view.getButton7()) {
                        Button7Pressed(e); 
                    } else if (sourceButton == view.getButton8()) {
                        Button8Pressed(e);  
                    } else if (sourceButton == view.getButton9()) {
                        Button9Pressed(e);  
                    } else if (sourceButton == view.getButton10()) {
                        Button10Pressed(e); 
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
                    view.getButton8().addActionListener(buttonListener);
                    view.getButton9().addActionListener(buttonListener);
                    view.getButton10().addActionListener(buttonListener);
    
                               
    
        view.addMouseListener(
            new MouseListener() {

                public void mousePressed(MouseEvent e) {

                    Color colorToUse = model.getSelectedColor();
                    System.out.println("Using color: " + colorToUse.toString());

                }
                        
                public void mouseReleased(MouseEvent e) {}
                                        
                public void mouseClicked(MouseEvent e) {
                    model.Dot();
                }
                                    
                public void mouseEntered(MouseEvent e) {}
                                            
                public void mouseExited(MouseEvent e) {}
                        
            }

            );
        

        view.addMouseMotionListener(
            new MouseMotionListener() {
                @Override
                public void mouseDragged (MouseEvent e){}
                @Override
                public void mouseMoved (MouseEvent e) {}
            }
        );
                            
        setTitle("Paint");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void Button1Pressed(ActionEvent e) {
    model.setSelectedColor(Color.BLACK);
    view.updateColorLabel(Color.BLACK);
    System.out.println("Black color selected");
    }

    public void Button2Pressed(ActionEvent e) {
    model.setSelectedColor(Color.RED);
    view.updateColorLabel(Color.RED);
    System.out.println("Red color selected");
    }

    public void Button3Pressed(ActionEvent e) {
    model.setSelectedColor(Color.GREEN);
    view.updateColorLabel(Color.GREEN);
    System.out.println("Green color selected");
    }

    public void Button4Pressed(ActionEvent e) {
    System.out.println("Dot selected");
    }

    public void Button5Pressed(ActionEvent e) {
    System.out.println("Oval selected");
    }

    public void Button6Pressed(ActionEvent e) {
    System.out.println("Rectangle selected");
    }

    public void Button7Pressed(ActionEvent e) {
    System.out.println("Undo");
    }

    public void Button8Pressed(ActionEvent e) {
    System.out.println("Redo");
    }

    public void Button9Pressed(ActionEvent e) {
    System.out.println("Save");
    }

    public void Button10Pressed(ActionEvent e) {
    System.out.println("Load");
    }


    public static void main(String [] args) {
        new Controller();
    }

}



