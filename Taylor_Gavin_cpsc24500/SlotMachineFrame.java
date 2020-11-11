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

public class SlotMachineFrame {
	private DrawingPanel slotFrame;
	public void setupMenu() {
		JMenuBar mBar = new JMenuBar();
		JMenu mFile = new JMenu("File");
		JMenuItem miSave = new JMenuItem("Save Tiles");
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.writeToBinary(jfc.getSelectedFile(), slotFrame.getTiles())) {
					JOptionPane.showMessageDialog(null,  "Wrote tiles to file");
				}else {
					JOptionPane.showMessageDialog(null, "Could not write tiles to the file");
				}
			}
		});
		mFile.add(miSave);
		JMenuItem miLoad = new JMenuItem("Load Tiles");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileRead tr = new TileRead();
				if (jfc.showMessageDialog(null) == JFileChooser.APPROVE_OPTION) {
					ArrayList<Tile> tilesRead = tr.readFromBinary(jfc.getSelectedFile());
					if (tilesRead == null) {
						JOptionPane.showMessageDialog(null, "Could not read tiles from file");;
					}else {
						slotFrame.setDots(tilesRead);
						repaint();
					}
				}
			}
		});
		mFile.add(miLoad);
		JMenuItem miRestart = new JMenuItem("Restart");
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slotFrame.setMouseSatus("");
				slotFrame.clearTile();
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
				JOptionPane.showMessageDialog(null," ");
			}
		});
		mHelp.add(miAbout);
		mBar.add(mHelp);
		setJMenuBar(mBar);
	}
	public void setupLook() {
		setBounds(100, 100, 500, 500);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		slotFrame = new DrawingPanel();
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
		JButton btnMin = new JButton("Mid");
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
	public SlotMachineFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
