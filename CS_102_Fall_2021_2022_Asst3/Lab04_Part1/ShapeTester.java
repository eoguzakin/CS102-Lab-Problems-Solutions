/**
 * @(#)ShapeTester.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/28
 */
import java.util.Scanner;
//a tester class for objects
public class ShapeTester {
    public static void main(String[] args) {
    	//we take user inputs and store objects with input values in a container
    	//then we display result that the user wants
    	ShapeContainer container = new ShapeContainer();
    	Scanner input = new Scanner(System.in);
    	int choice;
    	do{
    		System.out.println("1) Adding circles\n2) Adding rectangles\n3) Adding squares");
    		System.out.println("4) Checking if shapes in the container has the point you give");
    		System.out.println("5) Displaying container\n6) Emptying the container\n7) Exit");
    		System.out.print("Enter your choice: ");
    		choice = input.nextInt();
    		if(choice == 1){
    			System.out.print("Enter how many circles you want: ");
    			int numOfCircles = input.nextInt();
    			while(numOfCircles != 0){
    			System.out.print("Enter the radius for the circle: ");
    			Circle c = new Circle(input.nextInt());
    			System.out.print("Enter the center-x coordianate of the circle: ");
    			int cx = input.nextInt();
    			System.out.print("Enter the center-y coordianate of the circle: ");
    			int cy = input.nextInt();
    			c.setLocation(cx,cy);
    			container.add(c);
    			numOfCircles--;
    			}
    		}
    		else if(choice == 2){
    			System.out.print("Enter how many rectangles you want: ");
		    	int numOfRectangles = input.nextInt();
		    	while(numOfRectangles != 0){
		    		System.out.print("Enter the width for the rectangle: ");
		    		int width = input.nextInt();
		    		System.out.print("Enter the height for the rectangle: ");
		    		int height = input.nextInt();
		    		System.out.print("Enter the bottom left-x coordianate of the rectangle: ");
		    		int rx = input.nextInt();
		    		System.out.print("Enter the bottom left-y coordianate of the rectangle: ");
		    		int ry = input.nextInt();
		    		Rectangle r = new Rectangle(width, height);
		    		r.setLocation(rx,ry);
		    		container.add(r);
		    		numOfRectangles--;
		    	}
    		}
    		else if(choice == 3){
    			System.out.print("Enter how many squares you want: ");
		    	int numOfSquares = input.nextInt();
		    	while(numOfSquares != 0){
		    		System.out.print("Enter the side length for the square: ");
		    		int side = input.nextInt();
		    		Square sq = new Square(side);
		    		System.out.print("Enter the bottom left-x coordianate of the square: ");
		    		int sx = input.nextInt();
		    		System.out.print("Enter the bottom left-y coordianate of the square: ");
		    		int sy = input.nextInt();
		    		sq.setLocation(sx,sy);
		    		container.add(sq);
		    		numOfSquares--;
		    	}
    		}
    		else if(choice == 4){
    			System.out.print("Enter the x coordinate of the point you want to check: ");
		    	int x = input.nextInt();
		    	System.out.print("Enter the y coordinate of the point you want to check: ");
		    	int y = input.nextInt();
		    	System.out.print(container.contains(x,y).toString() + " contains your point.\n");
    		}
    		else if(choice == 5){
    			System.out.println(container.toString());
    		}
    		else if(choice == 6){
    			container = new ShapeContainer();
    		}
    		//if user inputs 7 we exit
    	}while(choice != 7);
    	System.out.println("Bye!");
    	//if I comment out the getArea method in circle class it gives a compiler error as
    	//The abstract Shape class has funtionalities that are not implemented in the child
    	//class. And if I turn circle into an abstract class, I cannot instantiate it.
    }
}
