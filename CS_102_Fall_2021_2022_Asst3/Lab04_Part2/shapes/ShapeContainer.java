/**
 * @(#)ShapeContainer.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/27
 */

package shapes;
public class ShapeContainer{
	//variables
	private Shape[] set = new Shape[0];
    //constructor
    public ShapeContainer() {
    }
    //getters
    public Shape[] getSet(){
    	return set;
    }
    public int size(){
    	return set.length;
    }
    //a method to add shapes to the container
    public void add(Shape s){
    	Shape modified[] = new Shape[set.length + 1];
    	for(int i = 0; i < set.length; i++){
    		modified[i] = set[i];
    	}
    	modified[modified.length - 1] = s;
    	set = modified;
    }
    //a method that removes the selected shapes
    public void removeSelected(){
    	//number of empty objects in the array
    	int empty = 0;
    	for(int i = 0; i < set.length; i++){
    		//we typecast the shape to circle here to check if our object is selected
    		Selectable s = (Selectable) set[i];
    		if(s.getSelected()){
    			//if it is selected we turn it to a null object and increment the number of empty objects
    			set[i] = null;
    			empty++;
    		}
    	}
    	//we declare an array to fill with its index setted to 0, and it has length of our set - empty objects
    	int filledIndex = 0;
    	Shape[] filled = new Shape[set.length - empty];
    	for(int i = 0; i < set.length; i++){
    		//if the object is not empty we add it and iterate through
    		if(set[i] != null){
    			filled[filledIndex] = set[i];
    			filledIndex++;
    		}
    	}
    	//then we assign our non selected shape array to our set
    	set = filled;
    }
    //a method to select all objects at (x,y)
    public int selectAllAt(int x, int y){
    	int count = 0;
    	for(int i = 0; i < set.length; i++){
    			Selectable c = (Selectable) set[i];
	    		if(c.contains(x,y) != null){
	    			c.setSelected(true);
	    			count++;
	    		}
    		
    	}
	    return count;
    }
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