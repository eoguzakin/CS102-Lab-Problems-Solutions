/**
 * @(#)Rectangle.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/8
 */

/**
 *This class represents a rectangle in a 2D space with its attributes
 */
public class Rectangle {
	//Variables
	private double height;
	private double width;
	private Point corner;
	//Constructor
    public Rectangle(double rHeight, double rWidth){
    	height = rHeight;
    	width = rWidth;
    	corner = new Point(0,0);
    }
    //Getters
    public double getHeight(){
    	return height;
    }
    public double getWidth(){
    	return width;
    }
    //Setters
    public void setHeight(double h){
    	height = h;
    }
    public void setWidth(double w){
    	width = w;
    }
    //This methods checks if a random point exists in the rectangle
    public boolean contains(Point point){
    	//if inside true else false
    	return (point.getX() <= width && point.getY() <= height);
    }
    //This method generates a random point in rectangle
    public Point getRandomPoint(){
    	double randomX = Math.random() * width;
    	double randomY = Math.random() * height;
    	Point randomPoint = new Point(randomX,randomY);
    	return randomPoint;
    }
    //This method returns a string representation of the rectangle
    public String toString(){
    	String s = "This rectangle has height: " + height + ", width: " + width;
    	s += "\nCorner point coordinates are: (" + corner.getX() + ", " + corner.getY() + ")";
    	return s;
    }
}