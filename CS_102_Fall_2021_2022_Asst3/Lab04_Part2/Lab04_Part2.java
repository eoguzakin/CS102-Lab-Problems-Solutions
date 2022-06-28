/**
 * @(#)Lab04_Part2.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/28
 */

import javax.swing.*;
import java.awt.*;
//a frame for our game
public class Lab04_Part2 extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800,600));
        BalloonsGamePanel panel = new BalloonsGamePanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
