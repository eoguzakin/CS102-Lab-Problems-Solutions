/**
 * @(#)FillBox.java
 *
 *
 * @author 
 * @version 1.00 2021/12/1
 */


public class FillBox {
	public static char[][] createArray(int row, int column){
		char[][] c = new char[row][column];
		for(int i = 0; i < row; i++){
			if(i == 0 || i == row - 1){
				for(int j = 0; j < column; j++){
					c[i][j] = '#';
				}
			}
			else{
				c[i][0] = '#';
				c[i][column-1] = '#';
			}
		}
		for(int i = 1; i < row-1; i++){
			for(int j = 1; j < column-1; j++){
				c[i][j] = ' ';
			}
		}
		return c;
	}
	public static void fillBox(char[][] c, int row, int column, char ch){
		if(c[row][column] == '#'){
			return;
		}
		c[row][column] = ch;
		fillBox(c,row,column-1,ch);
		fillBox(c,row-1,column,ch);
	}
	public static void printArray(char[][] c){
		for(int i = 0; i < c.length; i++){
			for(int j = 0; j < c[i].length; j++){
				System.out.print(c[i][j]);
			}
			System.out.print("\n");
		}
	}
	public static void drawFigure(char[][] c, int x, int y, int size){
		if(size > 7){
			for(int j = 0; j < y+size; j++){
				c[size / 2 + x][j] = '#';
			}
			for(int i = 0; i < x+size; i++){
				c[i][size / 2 + y] = '#';
			}
			drawFigure(c,x,y,size/2);
			drawFigure(c,x+size/2,y,size/2);
			drawFigure(c,x+size/2,y+size/2,size/2);
			drawFigure(c,x,y+size/2,size/2);
		}
		else{
			fillBox(c,x+size-1,y+size-1,'*');
		}
		
	}
    public static void main(String[] args) {
        char[][] array = createArray(10,10);
        printArray(array);
        System.out.println("");
        fillBox(array,8,8,'*');
        printArray(array);
        char[][] array1 = createArray(25,25);
        drawFigure(array1,0,0,25);
        printArray(array1);
    }
}