/**
 * @(#)PiCalculator.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/8
 */
import java.util.Arrays;
import java.util.Scanner;
public class PiCalculator {
    public static void main(String[] args) {
    	//scanner and rectangle objects
    	Scanner input = new Scanner(System.in);
    	Rectangle rectangle = new Rectangle(16,16);
    	//circle object that is inserted in the rectangle
    	Circle circle = new Circle(rectangle.getHeight() / 2, rectangle.getWidth() / 2);
    	//hits are set to 0
    	double hits = 0;
    	//taking trial number input
    	System.out.print("Please enter the number of trials:");
    	int tries = input.nextInt();
    	//shot array
    	Point shots[] = new Point[tries];
    	for(int i = 0; i < shots.length; i++){
    		//creating random shots and stroing them to compare
    		Point shot = rectangle.getRandomPoint();
    		System.out.println("our new point at i="+i+" is " + shot.toString());
    		shots[i] = shot;
    		//if its a hit, we increment it
    		if(circle.contains(shots[i])){
    			hits++;
    			System.out.println("hit!!!");
    		}
    		else{
    			System.out.println("no hit!");
    		}
    	}
    	//calculating pi
    	double pi = 4 * hits / tries;
    	System.out.println("our pi is " + pi);
    }
}
