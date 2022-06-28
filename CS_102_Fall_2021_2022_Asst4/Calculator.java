/**
 * @(#)Calculator.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/11/13
 */

import javax.swing.*;
import java.awt.*;
//the main class with the frame
public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(520,300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CalculatorPanel(frame.getX(),frame.getY()));
        //OR
        //frame.getContentPane().add(new APanel(frame.getX(),frame.getY()));
        frame.setVisible(true);
        frame.pack();
    }
}
