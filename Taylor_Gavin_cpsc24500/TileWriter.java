import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


public class TileWriter {
	/**
	 * These two functions deal with converting the data into a text file.
	 * @param fname
	 * @param tiles
	 * @return
	 */
	public boolean writeToText(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToText(f, tiles);
	}
	public boolean writeToText(File f, ArrayList<Tile> tiles) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Tile tile : tiles) {
				pw.println(tile);
			}
			pw.close();
			return true;
		}catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	/**
	 * These two functions takes the data and turns it into a binary file.
	 * @param fname
	 * @param tiles
	 * @return
	 */
	public boolean writeToBinary(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToBinary(f, tiles);
	}
	public boolean writeToBinary(File f, ArrayList<Tile> tiles) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(tiles);
			oos.close();
			return true;
		}catch (Exception ex) {
			return false;
		}
	}
	/**
	 * These functions are used to convert data in to a XML file.
	 * @param fname
	 * @param tiles
	 * @return
	 */
	public boolean writeToXML(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToXML(f, tiles);
	}
	public boolean writeToXML(File f, ArrayList<Tile> tiles) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(tiles);
			enc.close();
			return true;
		}catch (Exception ex) {
			return false;
		}
	}
	public boolean write(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return write(f, tiles);
	}
	/**
	 * After hitting the save button and giving the file a name
	 * whatever is at the end "TXT, BIN, XML" then it will turn
	 * that save into the corisponding data.
	 * @param f
	 * @param tiles
	 * @return
	 */
	public boolean write(File f, ArrayList<Tile> tiles) {
		String fname = f.getName().toUpperCase();
		if (fname.endsWith(".TXT")) {
			return writeToText(f, tiles);
		}
		if (fname.endsWith(".BIN")) {
			return writeToBinary(f, tiles);
		}
		if (fname.endsWith(".XML")) {
			return writeToXML(f, tiles);
		}
		return false;
	}
}

