/**
 * @(#)Document.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/20
 */
//Document object which includes an array of Term object that it fills from the document passed as a parameter
import java.io.*;
public class Document {
	//variables
	private String fileName;
	private Term[] terms;
	private int totalCount;
	//contructor that creates terms and processes the document passed as parameter
    public Document(String fileName) throws Exception{
    	this.fileName = fileName;
    	//upper limit for the terms array is set to 10000 but it can change in processDocument() method
    	terms = new Term[10000];
    	totalCount = 0;
    	processDocument();
    }
    //getters
    public Term[] getTerms(){
    	return terms;
    }
    public String getFileName(){
    	return fileName;
    }
    //setters
    public void setFileName(String fileName){
    	this.fileName = fileName;
    }
    //this method processes the document by reading all the words in it,
    //creating term objects for each of them and storing them in the terms array
    public void processDocument() throws Exception{
    	//a file reader object to find and read the document
    	FileReader fr = new FileReader("C:/Users/Asus/Desktop/Java Codes/CS 102/CS 102 Lab/CS_102_Fall_2021_2022_Asst2/" + fileName);
        //an integer so that we can later store the content of the document and turn it to a string
        int x;
        String text = "";
        //as reading process still goes on, we take everything, store in integer x and type cast it to char,
        //because we cannot typecast it to a string as the type is primitive.
        //then we concatnate our char x value to an empty string which grows as we read the document.
        while ((x = fr.read()) != -1){
        	text = text + (char)x;
        }
        text = text.replaceAll("\n", " ");
        text = text.replaceAll("[\\p{Punct}&&[^'-]]+", "");
        //then we get rid of all other quotations, empty spaces and punctuations to get all words
        //which are stored in a string array by the split method
    	String words[] = text.toLowerCase().split(" ");
    	totalCount = words.length;
    	//we create a brand new termArray and the reason for this is that we want to count all the words and their appearances
    	//so that we can only store the words that no longer has an identical word in the words array in further indexes
    	Term[] termArray = new Term[words.length];
    	for(int i = 0; i < words.length; i++){
    		//we set all words appearances to 1 by default
    		int wAppearance = 1;
    		for(int a = i + 1; a < words.length; a++){
    			//if there is an equality with words from different indexes
    			//we increment the appearance by 1 and turn the latter word into a space string
    			//so that later on we can get rid of this identically empty word.
    			if(words[i].equals(words[a])){
    				wAppearance++;
    				words[a] = " ";
    			}
    		}
    		//we later on create a term object for the prior word and initialize it with the word's count
    		Term t = new Term(words[i]);
    		t.setCount(wAppearance);
    		//term is added the termArray which contains both real words and empty space strings
    		termArray[i] = t;
    	}
    	//we later on try to find the valid term objects in the termArray by comparing the terms if they are space words or not
    	//if not then the term is valid and we increment the termArrayLength variable by 1
    	int termArrayLength = 0;
    	for(int i = 0; i < termArray.length; i++){
    		if(!termArray[i].getWord().equals(" ")){
    			termArrayLength++;
    		}
    	}
    	//as we now found the real 'valid' length of the termArray, we now initialize this length to our main term array for the document
    	terms = new Term[termArrayLength];
    	//we create an index variable to iterate through our main array
    	int termsIndex = 0;
    	for(int i = 0; i < termArray.length; i++){
    		//if the term in the termArray is a valid one, we initialize it to our main array and iterate through it
    		if(!termArray[i].getWord().equals(" ")){
    			terms[termsIndex] = termArray[i];
    			termsIndex++;
    		}
    	}
    }
    //this method returns the count of a given word in the document
    public double getCount(String word){
    	for(int i = 0; i < terms.length; i++){
    		Term t = terms[i];
    		if(t.getWord().equals(word)){
    			return t.getCount();
    		}
    	}
    	return 0;
    }
    //this method calculates the frequency of the given word, using its count and total number of words.
    public double getFrequency(String word){
    	return (double)getCount(word) / totalCount;
    }
    public int getTotalCount(){
    	return totalCount;
    }
}