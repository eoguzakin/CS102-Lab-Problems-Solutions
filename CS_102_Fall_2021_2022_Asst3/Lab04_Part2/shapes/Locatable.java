/**
 * @(#)Locatable.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/28
 */

package shapes;
//an interface to locate objects with their x and y coordinates
public interface Locatable {
    public int getX();
    public int getY();
    public void setLocation(int x, int y);
}