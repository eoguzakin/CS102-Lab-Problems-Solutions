/**
 * @(#)Point.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/8
 */

/**
 *This class represents a point in a 2D space with its attributes
 */
public class Point {
	//Variables
	private double x;
	private double y;
	//Constructor
    public Point(double xVal, double yVal){
    	x = xVal;
    	y = yVal;
    }
    //Getters
    public double getX(){
    	return x;
    }
    public double getY(){
    	return y;
    }
    //Setters
    public void setX(double xVal){
    	x = xVal;
    }
    public void setY(double yVal){
    	y = yVal;
    }
    //String representation method
    public String toString(){
    	String s = "(" + x + ", " + y + ")";
    	return s;
    }
}