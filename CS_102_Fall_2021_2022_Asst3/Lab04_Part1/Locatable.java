/**
 * @(#)Locatable.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/28
 */

//an interface to locate objects
public interface Locatable {
    public int getX();
    public int getY();
    public void setLocation(int x, int y);
}