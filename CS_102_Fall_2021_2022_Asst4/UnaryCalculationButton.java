/**
 * @(#)UnaryCalculationButton.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/11/11
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
//a button for unary calculations which is a child class of the binary calculation button class
public class UnaryCalculationButton extends CalculationButton{
	//constructor
    public UnaryCalculationButton(String name,JLabel result,JTextField f1, JTextField f2,Operation oper, CountInformer inf) {
    	//we initialize the parent class and set button color to red
    	super(name,result,f1,f2,oper,inf);
    	super.setBackground(Color.RED);
    }
    //button action method
    public void actionPerformed(ActionEvent e){
    	//if fields are not empty we calculate the result and update the operation count
    	if(!super.getF1().getText().equals("")){
	    	int no1 = Integer.parseInt(super.getF1().getText());
	    	super.getF2().setText("");
	    	super.getResLabel().setText("result: " + super.getOperation().calculateResult(no1,0));
	    	super.getInformer().countUpdated();
    	}
    	//else, we show an error
    	else{
    		JOptionPane.showMessageDialog(null,"Text fields are empty!","ERROR",2);
    	}
    }
    
}