/**
 * @(#)ShapeContainer.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/27
 */

//a container for objects
public class ShapeContainer implements Selectable{
	//variables
	private Shape[] set = new Shape[0];
    //constructor
    public ShapeContainer() {
    }
    //a method to add objects
    public void add(Shape s){
    	Shape modified[] = new Shape[set.length + 1];
    	for(int i = 0; i < set.length; i++){
    		modified[i] = set[i];
    	}
    	modified[modified.length - 1] = s;
    	set = modified;
    }
    //a method to get total area of objects
    public double getArea(){
    	double total = 0;
    	for(int i = 0; i < set.length; i++){
    		total += set[i].getArea();
    	}
    	return total;
    }
    public Shape[] getSet(){
    	return set;
    }
    //methods of the selectable interface
    public boolean getSelected(){
    	return false;
    }
    public void setSelected(boolean s){}
    //a method that returns the first object that has (x,y)
    public Shape contains(int x, int y){
    	for(int i = 0; i < set.length; i++){
    		if(set[i] instanceof Circle){
    			Circle c = (Circle) set[i];
    			return c.contains(x,y);
    		}
    		else if(set[i] instanceof Rectangle){
    			Rectangle r = (Rectangle) set[i];
    			return r.contains(x,y);
    		}
    		else{
    			Square s = (Square) set[i];
    			return s.contains(x,y);
    		}
    	}
    	return null;
    }
    //string representation
    public String toString(){
    	if(set.length != 0){
    		String s = "";
    		for(int i = 0; i < set.length; i++){
    		s += "Shape " + i + " is a " + set[i].toString() + "\n";
    		}
    		return s;
    	}
    	return "Empty!";
    }
}