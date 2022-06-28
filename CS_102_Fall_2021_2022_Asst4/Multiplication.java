/**
 * @(#)Multiplication.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/11/11
 */

//a multiplication class that extends from the operation parent class
public class Multiplication extends Operation{
	//constructor
    public Multiplication() {
    	super("Multiplication",false);
    }
    //calculates and increments operation count
    public int calculateResult(int first, int second){
    	incrementCount();
    	return first * second;
    }
    //incrementer
	public void incrementCount(){
		super.incrementCount();
	}
	//getters
    public int getCount(){
		return super.getCount();
	}
	public boolean getUnary(){
		return super.getUnary();
	}
	public String getOperationName(){
		return super.getOperationName();
	}
	public int getResult(){
		return super.getResult();
	}
	//updater
	public void updateResult(int nova){
		super.updateResult(nova);
	}
    
}