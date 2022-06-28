/**
 * @(#)Shape.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/27
 */

//an interface that is too generic to be a shape and it is locatable
public abstract class Shape implements Locatable{
    public abstract double getArea();
    public abstract int getX();
    public abstract int getY();
    public abstract void setLocation(int x, int y);
}