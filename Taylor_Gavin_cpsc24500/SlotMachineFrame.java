import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author gavin
 *
 */
public class SlotMachineFrame extends JFrame { //This is declared here so that it is in every function in this class
	private TilePanel slotFrame;
	private JTextField txtBalance;
	private JButton btnMax, btnMid, btnMin;
	/** 
	 * In this class the menu that you see at the top of the screen is made
	 * with a save, load, exit, restart options are under the name file.
	 * There is also the option for help and under that there is an item called about.
	 */
	public void setupMenu() {
		JMenuBar mBar = new JMenuBar();
		JMenu MuFile = new JMenu("File");
		JMenuItem miLoad = new JMenuItem("load");
		JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miPrint = new JMenuItem("Print");
		JMenuItem miRestart = new JMenuItem("Restart");
		JMenuItem miExit = new JMenuItem("Exit");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileRead tr = new TileRead();
				ArrayList<Tile> tiles;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tiles = tr.read(jfc.getSelectedFile());
					if (tiles != null) {
						slotFrame.setTiles(tiles);
						repaint();
					}else {
						JOptionPane.showMessageDialog(null,  "Tiles could not be read.");
					}
				}
			}
		});
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.write(jfc.getSelectedFile(), slotFrame.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles successfully");
					}else {
						JOptionPane.showMessageDialog(null, "Could not write tiles");
					}
				}
			}
		});
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		MuFile.add(miLoad);
		MuFile.add(miSave);
		MuFile.add(miExit);
		miRestart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				slotFrame.clearTiles();
				repaint();
			}
		});
		MuFile.add(miPrint);
		MuFile.add(miRestart);
		mBar.add(MuFile);
		JMenu MuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vaga Baby Vegas by Gavin Taylor <address>");
			}
		});
		MuHelp.add(miAbout);
		mBar.add(MuHelp);
		setJMenuBar(mBar);
		
	}
	public void setupLook() {//This here sets up the look of the game and add the buttons that we made above
		setTitle("Vagas Baby Slot Machine");
		setBounds(100, 100, 750, 300);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		slotFrame = new TilePanel();
		c.add(slotFrame, BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		btnMax = new JButton("Max");
		btnMid = new JButton("Mid");
		btnMin = new JButton("Min");
		panSouth.add(btnMax);
		panSouth.add(btnMid);
		panSouth.add(btnMin);
		c.add(panSouth,BorderLayout.SOUTH);
		slotFrame = new TilePanel();
		c.add(slotFrame,BorderLayout.CENTER);
		JLabel lbBalance = new JLabel("$");
		panSouth.add(lbBalance);
		txtBalance = new JTextField(6);
		txtBalance.setEditable(false);
		txtBalance.setText(String.format("%.2f", 5.0));
		setupMenu();
	}
	/**
	 * This calls the previouse class and tells it to close on exit.
	 */
	public SlotMachineFrame() {//When this is called this makes the window.
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
