/**
 * @(#)Selectable.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/10/28
 */

package shapes;
//an interface to select objects that contain our point at (x,y)
public interface Selectable {
	public boolean getSelected();
	public void setSelected(boolean s);
	public Shape contains(int x, int y);
}