/**
 * @(#)Circle.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/27
 */

//a circle object that is a shape and selectable
public class Circle extends Shape implements Selectable{
	//variables
	private int radius;
	private int x;
	private int y;
	private boolean selected = false;
	//constructor
    public Circle(int radius){
    	this.radius = radius;
    }
    //getters
    public double getArea(){
    	return Math.PI * Math.pow(radius,2);
    }
    public int getRadius(){
    	return radius;
    }
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    public boolean getSelected(){
    	return selected;
    }
    //setters
    public void setRadius(int r){
    	radius = r;
    }
    public void setLocation(int x, int y){
    	this.x = x;
    	this.y = y;
    }
    public void setSelected(boolean s){
    	selected = s;
    }
    //a method that checks if our circle containts (x,y)
    public Shape contains(int x, int y){
    	double distance = Math.pow(Math.pow(Math.abs(x-getX()),2)+Math.pow(Math.abs(y-getY()),2), 0.5);
    	if(distance <= radius){
    		Circle c = new Circle(radius);
    		c.setLocation(x,y);
    		c.setSelected(getSelected());
    		return c;
    	}
    	return null;
    }
    //string representation
    public String toString(){
    	String s = "Circle with radius: " + radius + " has area: " + getArea();
    	if(selected){
    		return "Selected " + s + "\nstarts at x = " + getX() + ", y = " + getY();
    	}
    	return "Not selected " + s + "\nstarts at x = " + getX() + ", y = " + getY();
    }
}