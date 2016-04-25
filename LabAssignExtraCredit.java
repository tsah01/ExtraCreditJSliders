package jsliders.extra.credit;


import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Shawn Clisby
 */
public class LabAssignExtraCredit extends JPanel {

    private JSlider leftWheel;
    private JSlider rightWheel;
    private JSlider[] colors;
    private JLabel[] labels;
    private String[] text = {"Left Wheel Velocity", "Right Wheel Velocity",
        "Red", "Green", "Blue"};
    
    LabAssignExtraCredit() {

        setSliders();
        setLabels();
       
        add(labels[0]);//left wheel velocity label
        add(leftWheel);//left wheel velcity slider

        add(labels[1]);//right wheel velocity label
        add(rightWheel);//right wheel velcity slider
              
        add(labels[2]);//red label
        add(colors[0]);//slider        
        
        add(labels[3]);//green label
        add(colors[1]);//slider

        add(labels[4]);//blue label
        add(colors[2]);//slider

    }

    private void setSliders() {

        leftWheel = new JSlider(-250, 250);
        leftWheel.setMajorTickSpacing(100);
        leftWheel.setPaintTicks(true);
        leftWheel.setPaintLabels(true);

        rightWheel = new JSlider(-250, 250);
        rightWheel.setMajorTickSpacing(100);
        rightWheel.setPaintTicks(true);
        rightWheel.setPaintLabels(true);

        colors = new JSlider[3];

        for (int i = 0; i < 3; i++) {

            colors[i] = new JSlider(0, 250);
            colors[i].setMajorTickSpacing(50);
            colors[i].setMinorTickSpacing(10);
            colors[i].setPaintTicks(true);
            colors[i].setPaintLabels(true);
        }
    }

    private void setLabels() {

        labels = new JLabel[5];

        for (int i = 0; i < 5; i++) {
            labels[i] = new JLabel(text[i]);
        }
    }
}
