import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JOptionPane;
/**
 * This class is used to take the information from Tile.java and print it out 
 * on the panel.
 * @author gavin
 *
 */
public class TilePanel extends JPanel implements MouseListener, MouseMotionListener {
	private String mouseStatus;
	private ArrayList<Tile> tiles;
	public void clearTiles() {
		tiles.clear();
	}
	public ArrayList<Tile> getTiles(){
		return tiles;
	}
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	/**
	 * This take are pre-set varibles for the tiles so there is something there when 
	 * the game starts.
	 */
	public TilePanel() {
		ArrayList<Tile> tiles = new ArrayList<Tile>();// I know you did want this here but it was the only way that the frame would even show up.
		addMouseListener(this);//The error I got was the NullPointerExpetion still working on it.
		addMouseMotionListener(this);
		tiles.add(new Tile(0,0,10,10));
		tiles.add(new Tile(1,1,220,10));
		tiles.add(new Tile(0,1,430,10));
		tiles.add(new Tile(0,1,640,10));
	}
	/**
	 * In this it takes in the random varible that is made in Tile.java and assigns it a color
	 * and a shape and the size.
	 * @param g
	 */
	public void colorVar(Graphics g) {
		super.paintComponent(g);
		for(Tile tile: tiles) {
			if(tile.getColor() == 0) {
				g.setColor(Color.RED);
				repaint();
			}else if (tile.getColor() == 1) {
				g.setColor(Color.ORANGE);
				repaint();
			}else if (tile.getColor() == 2) {
				g.setColor(Color.YELLOW);
				repaint();
			}else if (tile.getColor() == 3) {
				g.setColor(Color.GREEN);
				repaint();
			}else if (tile.getColor() == 4) {
				g.setColor(Color.BLUE);
				repaint();
			}
			if (tile.getShape() == 0) {
				g.fillOval(tile.getPosX(), tile.getPosY(), 200, 200);
				repaint();
			}else if (tile.getShape() == 1) {
				g.fillRect(tile.getPosX(), tile.getPosY(), 200, 200);
				repaint();
			}
		}
	}
	
	/**
	 * All of these are things to do with the mouse 
	 * this will work with clicking on the tile and changing the shape and color.
	 * @return
	 */
	public String getMouseStatus() {
		return mouseStatus;
	}
	public void setMouseStaus(String ms) {
		mouseStatus = ms;
	}
	public void mouseEntered(MouseEvent e) {
		mouseStatus = "Mouse entered the panel";
		repaint();
	}
	public void mouseExited(MouseEvent e) {
		mouseStatus = "Mouse exited the panel";
		repaint();
	}
	public void mouseClicked(MouseEvent e) {
		mouseStatus = String.format("Mouse clicked at (%d, %d)", e.getX(), e.getY());// This will be used to change the tile color and tile shape
		repaint();
	}
	public void mousePressed(MouseEvent e) {
		mouseStatus = String.format("Mouse pressed at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	public void mouseReleased(MouseEvent e) {
		mouseStatus = String.format("Mouse released at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	public void mouseMoved(MouseEvent e) {
		mouseStatus = String.format("MOuse moved at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	public void mouseDragged(MouseEvent e) {
		mouseStatus = String.format("MOuse Dragging at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
}
