/**
 * @(#)APanel.java
 *
 *
 * @author 
 * @version 1.00 2021/11/22
 */

import java.awt.*;
import javax.swing.*;
public class APanel extends JPanel implements CountInformer{
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
    public APanel(int x, int y) {
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
    	add.setSize(20,10);
    	sub = new CalculationButton("Subtract",result,f1,f2,subtraction,this);
    	sub.setSize(20,10);
    	mul = new CalculationButton("Multiply",result,f1,f2,multiplication,this);
    	mul.setSize(20,10);
    	div = new CalculationButton("Divide",result,f1,f2,division,this);
    	div.setSize(20,10);
    	sqr = new UnaryCalculationButton("Square",result,f1,f2,square,this);
    	sqr.setSize(20,10);
    	mod = new CalculationButton("Mod",result,f1,f2,modulus,this);
    	mod.setSize(20,10);
    	sqrt = new UnaryCalculationButton("Sqrt",result,f1,f2,squareRoot,this);
    	sqrt.setSize(20,10);
    	factor = new UnaryCalculationButton("Factor",result,f1,f2,factorization,this);
    	factor.setSize(20,10);
    	absolute = new UnaryCalculationButton("Abs",result,f1,f2,abs,this);
    	absolute.setSize(20,10);
    	natLog = new UnaryCalculationButton("Log",result,f1,f2,nLog,this);
    	natLog.setSize(20,10);
    	//we set the bottom label by checking counts
    	calculateAndUpdateCountMessage();
    	//we use grid bag layout to place what we assigned before
    	setLayout(new GridLayout(5,1));
    	JPanel p0 = new JPanel();
    	p0.add(appName);
    	JPanel p1 = new JPanel();
    	p1.add(no1);
    	p1.add(f1);
    	p1.add(no2);
    	p1.add(f2);
    	p1.add(result);
    	JPanel p2 = new JPanel();
    	p2.add(add);
    	p2.add(sub);
    	p2.add(mul);
    	p2.add(div);
    	p2.add(mod);
    	JPanel p3 = new JPanel();
    	p3.add(sqr);
    	p3.add(sqrt);
    	p3.add(factor);
    	p3.add(absolute);
    	p3.add(natLog);
    	JPanel p4 = new JPanel();
    	p4.add(bottom);
    	add(p0);
    	add(p1);
    	add(p2);
    	add(p3);
    	add(p4);
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