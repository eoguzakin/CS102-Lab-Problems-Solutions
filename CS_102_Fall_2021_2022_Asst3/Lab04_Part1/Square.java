/**
 * @(#)Square.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/27
 */

//a square that is actually a rectangle with even sides
public class Square extends Rectangle{
	//variables
	private int side;
	private int x;
	private int y;
	private boolean selected = false;
	//constructor
    public Square(int side) {
    	super(side,side);
    	this.side = side;
    }
    //getters
    public double getArea(){
    	return super.getArea();
    }
    public int getSide(){
    	return side;
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
    public void setLocation(int x, int y){
    	this.x = x;
    	this.y = y;
    }
    public void setSelected(boolean s){
    	selected = s;
    }
    //a method that checks if the square has (x,y)
    public Shape contains(int x, int y){
    	if(x >= getX() && x <= getX() + side){
    		if(y >= getY() && y <= getY() + side){
    			Square s = new Square(side);
    			s.setLocation(getX(),getY());
    			s.setSelected(getSelected());
    			return s;
    		}
    	}
    	return null;
    }
    //string representation
    public String toString(){
    	String s = "Square with side: " + side + " has area: " + getArea();
    	if(selected){
    		return "Selected " + s + "\nstarts at x = " + getX() + ", y = " + getY();
    	}
    	return "Not selected " + s + "\nstarts at x = " + getX() + ", y = " + getY();
    }
}