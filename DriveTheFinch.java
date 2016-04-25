/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsliders.extra.credit;

import javax.swing.*;

/**
 *
 * @author Shawn
 */
public class DriveTheFinch {

    public static void main(String[] args) {
       
        JFrame frame = new JFrame();
        
        frame.add(new FinchSlideGUI());
        frame.setSize(300,350);
        frame.setTitle("Drive the Finch");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
