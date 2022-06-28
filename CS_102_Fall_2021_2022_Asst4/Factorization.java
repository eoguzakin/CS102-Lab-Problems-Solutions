/**
 * @(#)Factorization.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/11/11
 */

//a factoriazationn class that extends from the operation parent class
public class Factorization extends Operation{
	//constructor
    public Factorization() {
    	super("Factorization",true);
    }
    //calculates and increments the operation count
    public int calculateResult(int first, int second){
    	incrementCount();
    	if(first >= 0){
    		int factorized = 1;
	    	while(first > 0){
	    		factorized *= first;
	    		first--;
	    	}
	    	return factorized;
    	}
    	else{
    		return -1;
    	}
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