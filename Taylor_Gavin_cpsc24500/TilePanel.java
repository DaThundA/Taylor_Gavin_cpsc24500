import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
/**
 * This class gives the get and set functions for the tiles,
 * which included the color and shape of them as well
 * @author gavin
 *
 */
public class TilePanel extends JPanel implements MouseListener {
	private ArrayList<Tile> tiles;
	private Random rnd;
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {//This here listens for when the mouse is clicked and then randomizes the tiles shape and color.
		int whichTile = e.getX()/(this.getWidth()/4);
		Tile tile = tiles.get(whichTile);
		tile.setRandomly(rnd);
		repaint();
	}
	public void clearTiles() {
		tiles.clear();
	}
	public TilePanel() {
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
		addMouseListener(this);
	}
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	public void paintComponent(Graphics g) {//This sets the color, shape, and location of the tiles.
		super.paintComponent(g);
		int cellWidth = this.getWidth() / 4;
		int tileSize = 4*cellWidth/5;
		int shape;
		Color color;
		Tile tile;
		for (int i = 0; i < tiles.size(); i++) {
		tile = tiles.get(i);
		shape = tile.getShape();
		color = tile.getRealColor();
		g.setColor(
		color);
		if (shape == 0) {
			g.fillOval(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
		} else if (shape == 1) {
			g.fillRect(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
		}
	}
	}
}


