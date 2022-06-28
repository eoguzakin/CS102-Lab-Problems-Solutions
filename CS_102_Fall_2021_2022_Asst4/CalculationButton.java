/**
 * @(#)CalculationButton.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/11/11
 */

import javax.swing.*;
import java.awt.event.*;
//a button class for binary operations
public class CalculationButton extends JButton implements ActionListener{
	//variables
	private Operation op;
	private JTextField num1;
	private JTextField num2;
	private JLabel res;
	private CountInformer informer;
	//constructor
    public CalculationButton(String name,JLabel result,JTextField no1,JTextField no2,Operation oper, CountInformer inf) {
    	//we instantiate the parent class and initialize parameters
    	super(name);
    	super.addActionListener(this);
    	num1 = no1;
    	num2 = no2;
    	op = oper;
    	informer = inf;
    	res = result;
    }
    //method for button actions
    public void actionPerformed(ActionEvent e){
    	//if the fields are not empty we calculate the result and update the operation count for this button
    	if(!num1.getText().equals("") && !num2.getText().equals("")){
	    	int no1 = Integer.parseInt(num1.getText());
	    	int no2 = Integer.parseInt(num2.getText());
	    	res.setText("result: " + op.calculateResult(no1,no2));
	    	informer.countUpdated();
    	}
    	//else, we show an error message
    	else{
    		JOptionPane.showMessageDialog(null,"Text fields are empty!","ERROR",2);
    	}
    }
    //gettters
    public JTextField getF1(){
    	return num1;
    }
    public JTextField getF2(){
    	return num2;
    }
    public JLabel getResLabel(){
    	return res;
    }
    public Operation getOperation(){
    	return op;
    }
    public CountInformer getInformer(){
    	return informer;
    }
    //setters
    public void setF1(JTextField no1){
    	num1 = no1;
    }
    public void setF2(JTextField no2){
    	num2 = no2;
    }
    public void setResLabel(JLabel result){
    	res = result;
    }
}