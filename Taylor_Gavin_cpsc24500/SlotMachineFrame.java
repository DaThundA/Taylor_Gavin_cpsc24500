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
public class SlotMachineFrame extends JFrame { 
	private TilePanel slotFrame;
	/** 
	 * In this class the menu that you see at the top of the screen is made
	 * with a save, load, exit, restart options are under the name file.
	 * There is also the option for help and under that there is an item called about.
	 */
	public void setupMenu() {
		JMenuBar mBar = new JMenuBar();
		JMenu mFile = new JMenu("File");
		JMenuItem miSave = new JMenuItem("Save Tiles");
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.write(jfc.getSelectedFile(), slotFrame.getTiles()));
						JOptionPane.showMessageDialog(null, "Wrote tile to file." );
				}else {
					JOptionPane.showMessageDialog(null, "Could not write tiles to file.");
				}
			}
		});
		mFile.add(miSave);
		JMenuItem miLoad = new JMenuItem("Load Tiles");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileRead tr = new TileRead();
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					ArrayList<Tile> tilesRead = tr.readFromBinary(jfc.getSelectedFile());
					if (tilesRead == null) {
						JOptionPane.showMessageDialog(null, "Could not read tiles from file");;
					}else {
						slotFrame.setTiles(tilesRead);
						repaint();
					}
				}
			}
		});
		mFile.add(miLoad);
		JMenuItem miRestart = new JMenuItem("Restart");
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slotFrame.setMouseStaus("");
				slotFrame.clearTiles();
				repaint();
			}
		});
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				System.exit(0);
			}
		});
		mFile.add(miRestart);
		mFile.add(miExit);
		mBar.add(mFile);
		JMenu mHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"https://github.com/DaThundA/Taylor_Gavin_cpsc24500");
			}
		});
		mHelp.add(miAbout);
		mBar.add(mHelp);
		setJMenuBar(mBar);
	}
	/**
	 * This sets the look of the panel: the size the name and the buttons that are at the bottom
	 */
	public void setupLook() {
		setTitle("Vagas Baby");
		setBounds(100, 100, 500, 500);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		slotFrame = new TilePanel();
		c.add(slotFrame, BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JButton btnMax = new JButton("Max");
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You pressed the Max button");
			}
		});
		panSouth.add(btnMax);
		JButton btnMid = new JButton("Mid");
		btnMid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You pressed the Mid button");
			}
		});
		panSouth.add(btnMid);
		JButton btnMin = new JButton("Min");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You pressed the Min button");
			}
		});
		panSouth.add(btnMin);
		panSouth.add(new JLabel("$"));
		JTextField txt$ = new JTextField(5);
		panSouth.add(txt$);
		c.add(panSouth, BorderLayout.SOUTH);
		setupMenu();
	}
	/**
	 * This calls the previouse class and tells it to close on exit.
	 */
	public SlotMachineFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

