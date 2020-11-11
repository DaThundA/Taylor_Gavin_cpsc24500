import java.io.Serializable;

public class Tile implements Serializable {
	private int color;
	private int shape;
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getShape() {
		return shape;
	}
	public void setShape(int shape) {
		this.shape = shape;
	}
	public Tile() {
		color = -1;
		shape = -1;
	}
	public Tile(int color, int shape) {
		setColor(color);
		setShape(shape);
	}
	public String toString() {
		return String.format("%d %d", color, shape);
	}
}
