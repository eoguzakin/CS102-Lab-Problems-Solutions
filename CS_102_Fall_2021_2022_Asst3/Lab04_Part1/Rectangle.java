/**
 * @(#)Rectangle.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/27
 */

//a rectangle that is a shape and selectable
public class Rectangle extends Shape implements Selectable{
	//variables
	private int width;
	private int height;
	private int x;
	private int y;
	private boolean selected = false;
	//constructor
    public Rectangle(int width, int height){
    	this.width = width;
    	this.height = height;
    }
    //getters
    public int getWidth(){
    	return width;
    }
    public int getHeight(){
    	return height;
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
    public double getArea(){
    	return width * height;
    }
    //setters
    public void setLocation(int x, int y){
    	this.x = x;
    	this.y = y;
    }
    public void setSelected(boolean s){
    	selected = s;
    }
    //a method that checks if our objects has (x,y)
    public Shape contains(int x, int y){
    	if(x >= getX() && x <= getX() + width){
    		if(y >= getY() && y <= getY() + height){
    			Rectangle r = new Rectangle(getWidth(),getWidth());
    			r.setLocation(getX(),getY());
    			r.setSelected(getSelected());
    			return r;
    		}
    	}
    	return null;
    }
    //string representation
    public String toString(){
    	String s = "Rectangle with height: " + height + " and width: " + width + " has area: " + getArea();
    	if(selected){
    		return "Selected " + s + "\nstarts at x = " + getX() + ", y = " + getY();
    	}
    	return "Not selected " + s + "\nstarts at x = " + getX() + ", y = " + getY();
    }
}