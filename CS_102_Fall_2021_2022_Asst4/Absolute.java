/**
 * @(#)Absolute.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/11/11
 */

//a class for absolute operations that extends form the operation parent class
public class Absolute extends Operation{
	//constructor
    public Absolute() {
    	super("Absolute",true);
    }
    //result calculating method that increments operation count and returns the result
    public int calculateResult(int first, int second){
    	incrementCount();
    	return (int) Math.abs(first);
    }
    //count incrementer
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
	//a result updater method
	public void updateResult(int nova){
		super.updateResult(nova);
	}
    
}