import java.awt.Color;
import java.io.Serializable;
import java.util.Random;
/**
 * In this class the varibles for the color and shape are determined and sent to TilePanel.java
 * This also set varibles to posX and posY for the location of each tile.
 * @author gavin
 *
 */
public class Tile implements Serializable {
	//The the first three private varibles are constants and can only be accessed in this class
	private static final Color[] colors = {Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE};
	private static final String[] colorNames = {"yellow", "green", "orange", "red", "blue"};
	private static final String[] shapes = {"circle", "square"};
	private int color;
	private int shape;
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		if (color < 0) {
			this.color = 0;
		}else if (color > 4){
			this.color = 4;
		}else {
			this.color = color;
		}
	}
	public int getShape() {
		return shape;
	}
	public void setShape(int shape) {
		if (shape < 0) {
			this.shape = 0;
		}else if (shape > 1) {
			this.shape = 1;
		}else {
			this.shape = shape;
		}
	}
	//Here this function randomizes the color and shape from a the arraylist
	//and assigns a random color and shape accordingly 
	public void setRandomly(Random rn) {
		color = rn.nextInt(colors.length);
		shape = rn.nextInt(shapes.length);
	}
	public Color getRealColor() {
		return colors[color];
	}
	public String getColorName() {
		return colorNames[color];
	}
	public String getShapeName() {
		return shapes[shape];
	}
	public Tile() {
		color = 3;
		shape = 0;
	}
	public Tile(int color, int shape) {//This is all the data that is in the Tile
		setColor(color);
		setShape(shape);
	}
	//All three of these are used when the data is saved eith to and XML file,
	//BIN file or TXT file
	public String toStringNice(){
		return String.format("%s %s", getColorName(), getShapeName());
	}
	public String toString() {
		return String.format("%d %d", color, shape);//This is what will be read will be read
	}
	public int getCode() {
		return color*10+shape;
	}
}
