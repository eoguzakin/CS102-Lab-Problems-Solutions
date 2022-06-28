/**
 * @(#)Term.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/20
 */
//Term class for words and their counts of appearances
public class Term {
	//variables
	private String word;
	private int count;
	//constructor
    public Term(String word) {
    	this.word = word;
    	count = 0;
    }
    //getters and setters
    public int getCount(){
    	return count;
    }
    public String getWord(){
    	return word;
    }
    public void setCount(int count){
    	this.count = count;
    }
    public void setWord(String word){
    	this.word = word;
    }
    //count incrementer method for a term object
    public void incrementCount(){
    	count++;
    }
    
}