/**
 * @(#)CalculatorPanel.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/11/11
 */

import java.awt.*;
import javax.swing.*;
//panel class for our calculator
public class CalculatorPanel extends JPanel implements CountInformer{
	//variables
	public final int PANEL_X;
	public final int PANEL_Y;
	public JTextField f1;
	public JTextField f2;
	public JLabel no1 = new JLabel("Number 1:");
	public JLabel no2 = new JLabel("Number 2:");
	public JLabel appName = new JLabel("Calculator");
	public JLabel result;
	public JLabel bottom;
	public CalculationButton add;
	public CalculationButton sub;
	public CalculationButton mul;
	public CalculationButton div;
	public CalculationButton sqr;
	public CalculationButton mod;
	public UnaryCalculationButton sqrt;
	public UnaryCalculationButton factor;
	public UnaryCalculationButton absolute;
	public UnaryCalculationButton natLog;
	public Operation[] ops;
	//constructor
    public CalculatorPanel(int x, int y) {
    	super();
    	PANEL_X = x;
    	PANEL_Y = y;
    	init();
    }
    //a method to initialize our variables and place them accordingly
    public void init(){
    	setVisible(true);
    	setPreferredSize(new Dimension(PANEL_X,PANEL_Y));
    	//filling operation array
    	Operation addition = new Addition();
    	Operation subtraction = new Subtraction();
    	Operation multiplication = new Multiplication();
    	Operation division = new Division();
    	Operation modulus = new Modular();
    	Operation squareRoot = new SquareRoot();
    	Operation factorization = new Factorization();
    	Operation square = new Square();
    	Operation abs = new Absolute();
    	Operation nLog = new NaturalLogarithm();
    	Operation[] ops = {addition, subtraction, multiplication, division, modulus, squareRoot, factorization, square, abs, nLog};
    	//assigning other variables
    	bottom  = new JLabel();
    	f1 = new JTextField(10);
    	f2 = new JTextField(10);
    	result = new JLabel("result: ");
    	//creating buttons
    	add = new CalculationButton("Add",result,f1,f2,addition,this);
    	sub = new CalculationButton("Subtract",result,f1,f2,subtraction,this);
    	mul = new CalculationButton("Multiply",result,f1,f2,multiplication,this);
    	div = new CalculationButton("Divide",result,f1,f2,division,this);
    	sqr = new UnaryCalculationButton("Square",result,f1,f2,square,this);
    	mod = new CalculationButton("Mod",result,f1,f2,modulus,this);
    	sqrt = new UnaryCalculationButton("Sqrt",result,f1,f2,squareRoot,this);
    	factor = new UnaryCalculationButton("Factor",result,f1,f2,factorization,this);
    	absolute = new UnaryCalculationButton("Abs",result,f1,f2,abs,this);
    	natLog = new UnaryCalculationButton("Log",result,f1,f2,nLog,this);
    	//we set the bottom label by checking counts
    	calculateAndUpdateCountMessage();
    	//we use grid bag layout to place what we assigned before
    	setLayout(new GridBagLayout());
    	GridBagConstraints gbs = new GridBagConstraints();
    	//we assign app name to top center first
    	gbs.gridx = 2;
    	gbs.gridy = 0;
    	gbs.gridwidth = 1;
    	gbs.gridheight = 1;
    	gbs.weightx = 0;
    	gbs.weighty = 1;
    	add(appName,gbs);
    	//then we assign text fields and labels at appropiate positions
    	gbs.anchor = GridBagConstraints.LINE_END;
    	gbs.gridy = 1;
    	gbs.gridx = 0;
    	add(no1,gbs);
    	gbs.gridx = 1;
    	gbs.anchor = GridBagConstraints.LINE_START;
    	add(f1,gbs);
    	gbs.gridx = 2;
    	gbs.anchor = GridBagConstraints.LINE_END;
    	add(no2,gbs);
    	gbs.gridx = 3;
    	gbs.anchor = GridBagConstraints.LINE_START;
    	add(f2,gbs);
    	gbs.gridx = 4;
    	gbs.anchor = GridBagConstraints.CENTER;
    	add(result, gbs);
    	//then we add our buttons which fills the horizon
    	gbs.fill = GridBagConstraints.HORIZONTAL;
    	gbs.weightx = 1;
    	gbs.weighty = 0;
    	gbs.gridx = 0;
    	gbs.gridy = 2;
    	add(add,gbs);
    	gbs.gridx = 1;
    	add(sub,gbs);
    	gbs.gridx = 2;
    	add(mul,gbs);
    	gbs.gridx = 3;
    	add(div,gbs);
    	gbs.gridx = 4;
    	add(mod,gbs);
    	gbs.gridx = 0;
    	gbs.gridy = 3;
    	add(sqr,gbs);
    	gbs.gridx = 1;
    	add(sqrt,gbs);
    	gbs.gridx = 2;
    	add(factor,gbs);
    	gbs.gridx = 3;
   		add(absolute,gbs);
   		gbs.gridx = 4;
    	add(natLog,gbs);
    	//at last, we add out operation count label to bottom
    	gbs.gridy = 5;
    	gbs.gridx  = 0;
    	gbs.gridwidth = 5;
    	gbs.weighty = 1;
    	add(bottom,gbs);
    }
    //this method updates operation count for all operations
    public void calculateAndUpdateCountMessage(){
    	String s = "Add: " + add.getOperation().getCount() + " Subtract: " + sub.getOperation().getCount();
    	s += " Multiply: " + mul.getOperation().getCount() + " Division: " + div.getOperation().getCount();
    	s += " Mod: " + mod.getOperation().getCount() + " Square: " + sqr.getOperation().getCount();
    	s += " Sqrt: " + sqrt.getOperation().getCount() + " Factor: " + factor.getOperation().getCount();
    	s += " Abs: " + absolute.getOperation().getCount() + " Log: " + natLog.getOperation().getCount();
    	bottom.setText(s);
    }
    //this method is called when a button is pressed
    public void countUpdated(){
    	calculateAndUpdateCountMessage();
    }
    
}