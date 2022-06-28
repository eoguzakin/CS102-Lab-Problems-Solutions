/**
 * @(#)Circle.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/8
 */

/**
 *This class represents a circle object in a 2D space with its attributes
 */
public class Circle {
	//Variables
	Point center;
	private double radius;
	//Constructor
    public Circle(double centerX, double centerY){
    	center = new Point(centerX,centerY);
    	if(centerX == centerY){
    		radius = centerX;
    	}
    }
    //Getters
    public double getRadius(){
    	return radius;
    }
    public Point getCenter(){
    	return center;
    }
    //radius has no setters as it is modified by the center point
    //This method sets the center coordinates
    public void setCenter(double newX, double newY){
    	center = new Point(newX,newY);
    }
    //This method checks if the point exists in the circle
    public boolean contains(Point point){
    	double length = Math.abs(point.getX() - center.getX());
    	double height = Math.abs(point.getY() - center.getY());
    	double hypotenuse = Math.pow(Math.pow(height,2) + Math.pow(length,2),0.5);
    	return (hypotenuse <= radius);
    }
    //String representation method
    public String toString(){
    	String s = "This circle has radius: " + radius + " and center (" + center.getX();
    	s+= ", " + center.getY() + ")";
    	return s;
    }
}