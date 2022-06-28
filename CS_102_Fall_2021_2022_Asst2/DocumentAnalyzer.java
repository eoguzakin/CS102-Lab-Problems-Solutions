/**
 * @(#)DocumentAnalyzer.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/20
 */
import java.util.Scanner;
import java.io.*;
public class DocumentAnalyzer {
    //this method takes a word, document and a collection of documents as parameters to calculate tf-idf
    //for the specific document
    public static double calcTfidf(String t, Document d, Document[] D){
    	//tf is calculated according to the formula
    	double tf = d.getFrequency(t);
    	//wanted is  the variable for the number of documents that has the specified word
    	double wanted = 0;
    	//we check each document's terms to find the count number of the specified word
    	for(int i = 0; i < D.length; i++){
    		Document x = D[i];
    		Term[] terms = x.getTerms();
    		//a condition boolean which decides if this document contains our word
    		for(int a = 0; a < terms.length; a++){
    			if(terms[a].getWord().equals(t)){
    				wanted++;
    			}
    		}
    	}
    	//calculating idf and returning the result
    	double idf;
    	if(wanted == 0){
    		idf = 0;
    	}
    	else{
    		idf = Math.log(D.length / wanted);
    	}
    	return tf * idf;
    }
    //this method calculates tfidf for all documents and prints the results
    public static void allCalcTfidf(String word, Document[] D){
    	for(int i = 0; i < D.length; i++){
    		System.out.println("\nDocument " + (i + 1));
    		System.out.println("word: " + word);
    		System.out.println("tf-idf: " + calcTfidf(word,D[i],D));
    	}
    }
    public static void main(String[] args) throws Exception{
        //scanner object
        Scanner input = new Scanner(System.in);
        //takin the number of documents to initialize document array
        System.out.print("Enter the number of documents: ");
        int numOfDoc = input.nextInt();
        Document[] docs = new Document[numOfDoc];
        //taking the names for documents
        for(int i = 0; i < numOfDoc; i++){
	       	System.out.print("Enter the name of the document " + (i + 1) + ": ");
	       	String docName = input.next();
	       	Document document = new Document(docName);
	       	docs[i] = document;
	    }
	    //taking users option choice, if it is x, we quit
	    String option;
        do{
        	String s = "Menu Options\n1. Display the frequency of a word\n2. Display the most frequent words and their number of appearances in each document\n3. Calculate the tf-idf of a word\nEnter the option (enter 4 to quit):";
        	System.out.println(s);
	        option = input.next();
	        //if one, then we take the owrd for frequency and display it for each document
	        if(option.equals("1")){
	        	System.out.print("Enter the word which you want to find the frequency: ");
	        	String word = input.next();
	        	for(int i = 0; i < docs.length; i++){
	        		System.out.println("\nDocument " + (i + 1));
	        		System.out.println(" word: " + word);
	        		System.out.println(" term frequency: " + docs[i].getFrequency(word));
	        	}
	        }
	        //if 2, then we print out the most frequent word in each document
	        else if(option.equals("2")){
	        	String w;
	        	for(int i = 0; i < docs.length; i++){
	        		Term[] terms = docs[i].getTerms();
	        		int max = 0;
	        		Term frequent = new Term("");
	        		for(int a = 0; a < terms.length; a++){
	        			if(max < terms[a].getCount()){
	        				frequent = terms[a];
	        				max = terms[a].getCount();
	        			}
	        		}
	        		System.out.println("\nDocument " + i);
	        		System.out.println("word: " + frequent.getWord());
	        		System.out.println("number of appearance: " + frequent.getCount());
	        	}
	        }
	        //if 3, we take the word input to calculate tf-idf for each document
	        else if(option.equals("3")){
	        	System.out.print("Enter the word which you want to calculate tf-idf: ");
	        	String word = input.next();
	        	allCalcTfidf(word,docs);
	        }
        }while(!option.equals("4"));
        System.out.println("Done!");
    }
}
