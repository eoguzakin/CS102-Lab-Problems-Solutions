/**
 * @(#)Operation.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/11/11
 */

//a class for calculation operations
public abstract class Operation {
	//variables
	private int count;
	private int result;
	private boolean unary;
	private String operationName;
	//constructor
	public Operation(String name, boolean uOrB){
		operationName = name;
		unary = uOrB;
		count = 0;
	}
	//a generic calculation method for all operations
	public abstract int calculateResult(int before, int input);
	public int getCount(){
		return count;
	}
	//incrementor
	public void incrementCount(){
		count++;
	}
	//getters
	public boolean getUnary(){
		return unary;
	}
	public String getOperationName(){
		return operationName;
	}
	public int getResult(){
		return result;
	}
	//updater
	public void updateResult(int nova){
		result = nova;
	}
}