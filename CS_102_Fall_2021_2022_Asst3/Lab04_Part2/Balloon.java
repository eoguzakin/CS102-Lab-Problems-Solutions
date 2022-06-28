/**
 * @(#)Balloons.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/28
 */
import shapes.*;
import java.awt.*;
//a balloon object that is a circle and is drawable
public class Balloon extends Circle implements Drawable{
	//variables
	private int x;
	private int y;
	private int radius;
	private boolean selected = false;
	//constructor
    public Balloon(int x, int y, int radius){
    	//constructing the super class object
    	super(radius);
    	super.setLocation(x,y);
    	this.x = x;
    	this.y = y;
    	this.radius = radius;
    	this.selected = super.getSelected();
    }
    //a method that draws balloons
    public void draw(Graphics g){
    	g.drawOval(x - radius, y - radius, radius * 2, radius*2);
    }
    //a method that makes balloons grow to a maximum of 100
    //at that phase the balloon becomes selected and removed
    public void grow(){
    	radius += 1;
    	if(radius >= 100){
    		radius = 0;
    		setSelected(true);
    	}
    }
    //a object to determine if our balloon is at(x,y)
    public shapes.Shape contains(int x, int y){
    	double distance = Math.pow(Math.abs(x-this.x),2)+Math.pow(Math.abs(y-this.y),2);
    	if(distance <= radius*radius){
    		Balloon b = new Balloon(this.x,this.y,radius);
    		return b;
    	}
    	return null;
    }
}