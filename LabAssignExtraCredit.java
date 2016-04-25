package jsliders.extra.credit;


import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


/**
 * Lab Assignment 8 / Group Assignment / Finch Slider GUI
 * @author Shawn.Clisby, Tula.Sah, Joshua.Rodstein
 */
public class FinchSlideGUI extends JPanel {

    private Finch ourFinch = new Finch();
    private JSlider leftWheel;
    private JSlider rightWheel;
    private JSlider[] colors;
    private JLabel[] labels;
    private String[] text = {"Left Wheel Velocity", "Right Wheel Velocity",
        "Red", "Green", "Blue"};
    private JPanel redPanel; 
    private JPanel greenPanel; 
    private JPanel bluePanel;

    FinchSlideGUI() {

        setLabels();
        setSliders();
        redPanel = new JPanel(new BorderLayout());
        greenPanel = new JPanel(new BorderLayout());
        bluePanel  = new JPanel(new BorderLayout());

        add(labels[0]);//left wheel velocity label
        add(leftWheel);//left wheel velcity slider

        add(labels[1]);//right wheel velocity label
        add(rightWheel);//right wheel velcity slider

        redPanel.add(labels[2], BorderLayout.WEST);
        redPanel.add(colors[0], BorderLayout.CENTER);
        labels[2].setForeground(Color.red);
        colors[0].setValue(0);
        add(redPanel);

        greenPanel.add(labels[3], BorderLayout.WEST);
        greenPanel.add(colors[1], BorderLayout.CENTER);
        labels[3].setForeground(Color.green);
        colors[1].setValue(0);
        add(greenPanel);

        bluePanel.add(labels[4], BorderLayout.WEST);
        bluePanel.add(colors[2], BorderLayout.CENTER);
        labels[4].setForeground(Color.blue);
        colors[2].setValue(0);
        add(bluePanel);//slider

        if (!this.isEnabled()) {
            ourFinch.quit();
        }

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
            colors[i].addChangeListener(new colorListener());
        }

        leftWheel.addChangeListener(new velocityListener());
        rightWheel.addChangeListener(new velocityListener());
        
        
        

    }

    private void setLabels() {

        labels = new JLabel[5];

        for (int i = 0; i < 5; i++) {
            labels[i] = new JLabel(text[i]);
        }
        
    }

    class velocityListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (e.getSource() == leftWheel) {
                ourFinch.setWheelVelocities(leftWheel.getValue(),
                        rightWheel.getValue());
            }
            if (e.getSource() == rightWheel) {
                ourFinch.setWheelVelocities(leftWheel.getValue(),
                        rightWheel.getValue());
            }
        }
    }
    
        class colorListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
           if (e.getSource() == colors[0])
               ourFinch.setLED(colors[0].getValue(), colors[1].getValue(), 
                       colors[2].getValue());
           else if (e.getSource() == colors[1])
               ourFinch.setLED(colors[0].getValue(), colors[1].getValue(), 
                       colors[2].getValue());
           else
               ourFinch.setLED(colors[0].getValue(), colors[1].getValue(), 
                       colors[2].getValue());
        }
    }
}
