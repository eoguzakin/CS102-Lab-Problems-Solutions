/**
 * @(#)BalloonsGamePanel.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/28
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.*;
import shapes.*;
//a game panel for the game
public class BalloonsGamePanel extends JPanel implements SwingConstants{
	//variables
	private ShapeContainer balloons;
	javax.swing.Timer timer;
	JLabel score;
	JOptionPane restart;
	private long elapsedT;
	private int points;
	//constructor
    public BalloonsGamePanel() {
    	super();
    	init();
    }
    //an initializer method
    public void init(){
    	points = 0;
    	balloons = new ShapeContainer();
    	setPreferredSize(new Dimension(800,600));
    	setBackground(Color.yellow);
    	setVisible(true);
    	score = new JLabel("score: " + points);
    	add(score);
    	addMouseListener(new ClickListener());
    	elapsedT = 0;
    	//we create 25 balloons for start
    	for(int i = 0; i < 25; i++){
    		Balloon b = new Balloon((int)(Math.random() * 800),(int)(Math.random() * 600),25);
    		balloons.add(b);
    	}
    	ActionListener listener = new TimerListener();
    	timer = new Timer(50, listener);
    	timer.start();
    	repaint();
    }
    //printer method for balloons
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	for(int i = 0; i < balloons.size(); i++){
    		Balloon b = (Balloon)balloons.getSet()[i];
    		b.draw(g);
    	}
    }
    //a listener class for timer to operate at periodical delays
    public class TimerListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		//selected balloons are removed every time
    		balloons.removeSelected();
    		//if there are less than 15 balloons, we add more
    		if(balloons.size() <= 15){
	        	balloons.add(new Balloon((int)(Math.random() * 800),(int)(Math.random() * 600),25));
	        }
	        //we than grow every balloon
	        for(int i = 0; i < balloons.size(); i++){
	        	Balloon b = (Balloon)(Circle)balloons.getSet()[i];
	        	b.grow();
	        	balloons.getSet()[i] = b;
	        }
	        //elapsed time continues to grow
	        elapsedT++;
	        //if the game was on for more than 4 minutes, we ask the user if they want to play again
	        if(elapsedT >= 250){
	        	JOptionPane optionPane = new JOptionPane(this, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);
		        timer.stop();
		        int again = optionPane.showConfirmDialog(BalloonsGamePanel.this, "Play again? ", "Game over", 0);
		        if(again == 0){
		        	init();
	        	}
		        else{
		    		System.exit(0);
		    	} 
	    	}
	    	//we repaint every end of a period
    		repaint();
    	}
    }
    public class ClickListener implements MouseListener {
	    public void mousePressed(MouseEvent e) {
	        //if we managed  to hit more than 1 balloon we get the amount as points
	        //we select those we hit
	        int blown = balloons.selectAllAt(e.getX(),e.getY());
	        if(blown >= 2){
	        	points += blown;
	        	score.setText("Score: " + points);
	        }
	        //we remove selected balloons
	        balloons.removeSelected();
	        repaint();
	    }
	    public void mouseExited(MouseEvent e){}
	    public void mouseEntered(MouseEvent e){}
	    public void mouseReleased(MouseEvent e){}
	    public void mouseClicked(MouseEvent e){}
	}
}