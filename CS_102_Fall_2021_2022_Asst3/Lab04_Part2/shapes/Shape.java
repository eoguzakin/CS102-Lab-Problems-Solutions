/**
 * @(#)Shape.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/27
 */

package shapes;
//a generic interface for other shapes
public abstract class Shape implements Locatable{
    public abstract double getArea();
    public abstract int getX();
    public abstract int getY();
    public abstract void setLocation(int x, int y);
}