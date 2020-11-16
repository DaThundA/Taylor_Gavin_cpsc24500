import java.io.Serializable;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Point;
/**
 * In this class the varibles for the color and shape are determined and sent to TilePanel.java
 * This also set varibles to posX and posY for the location of each tile.
 * @author gavin
 *
 */
public class Tile implements Serializable {
	Random rand = new Random();
	private int color;
	private int shape;
	private int posX;
	private int posY;
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		color = rand.nextInt(2);//This picks a random number 0 or 1
		this.color = color;
	}
	public int getShape() {
		return shape;
	}
	public void setShape(int shape) {
		shape = rand.nextInt(5);//this picks a random number between 0 and 4
		this.shape = shape;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY; 
	}
	public Tile() {
		color = 1;
		shape = 1;
		posX = 1;
		posY = 1;
	}
	public Tile(int color, int shape, int posX, int posY) {//This is all the data that is in the Tile
		setColor(color);
		setShape(shape);
		setPosX(posX);
		setPosY(posY);
	}
	public String toString() {
		return String.format("%d %d %d %d", color, shape, posX, posY);//This is what will be read will be read
	}
}
