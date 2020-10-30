import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * This would be the half-billion thing I need to import to make shapes and panels and all that fun jazz.
 * @author gavin
 *PicturePanel is used to to bring forth all of the private variables need and make their set and get functions.
 */
class PicturePanel extends JPanel{
	private int thingHeight;
	private int thingWidth;
	private int left;
	private int top;
	private String eyeType;
	private String noseType;
	private String mouthType;
	private Color color;
	public void setThingHeight(int h) {
		thingHeight = h;
	}
	public int getThingHeight() {
		return thingHeight;
	}
	public void setThingWidth(int w) {
		thingWidth = w;
	}
	public int getThingWidth() {
		return thingWidth;
	}
	public void setLeft(int l) {
		left = l;
	}
	public int getLeft() {
		return left;
	}
	public void setTop(int t) {
		top = t;
	}
	public int getTop() {
		return top;
	}
	public void setEyeType(String e) {
		if (!e.equalsIgnoreCase("c") && !e.equalsIgnoreCase("t") && !e.equalsIgnoreCase("s")) {//These here have if statements so that if something is not put in correctly the program doesn't crash all you need a pumpkin with a face.
			e = "c";
		}
		else {
			eyeType = e;
		}	
		}
	public String getEyeType() {
		return eyeType;
	}
	public void setNoseType(String n) {
		if (!n.equalsIgnoreCase("c") && !n.equalsIgnoreCase("t") && !n.equalsIgnoreCase("s")) {
			n = "t";
		}
		else {
			noseType = n;
		}
	}
	public String getNoseType() {
		return noseType;
	}
	public void setMouthType(String m) {
		if (!m.equalsIgnoreCase("o") && !m.equalsIgnoreCase("r")) {
			mouthType = "r";
		}
		else {
			mouthType = m;
		}
		
	}
	public String getMouthType() {
		return mouthType;
	}
	public void paintComponent(Graphics g) {//This is all the math to make sure that every peace of the pumpkin goes where in need to go.
		super.paintComponent(g);
		g.setColor(Color.ORANGE);
		g.fillOval(left, top, thingWidth, thingHeight);
		if (noseType.equalsIgnoreCase("s")) {
			g.setColor(Color.WHITE);
			g.fillRect((left + (thingWidth/2) - ((thingWidth/8)/2)), (top + (thingHeight/3) - ((thingHeight/22)/3)), (thingWidth/8), (thingHeight/8));
		}
		else if (noseType.equalsIgnoreCase("c")) {
			g.setColor(Color.WHITE);
			g.fillOval((left + (thingWidth/2) - ((thingWidth/8)/2)), (top + (thingHeight/3) - ((thingHeight/22)/3)), (thingWidth/8), (thingHeight/8));
		}
		else if (noseType.equalsIgnoreCase("t")){
			g.setColor(Color.WHITE);
			g.fillPolygon(new int[] {(left + (thingWidth/2) + ((thingWidth/8)/2)), (left + (thingWidth/2) + ((thingWidth/8)/2) - (thingWidth/8)), left + (thingWidth/2) + ((thingWidth/8)/2) - ((thingWidth/8)/2)}, new int[] {(top + (thingHeight/3) + (thingHeight/8) - ((thingHeight/22)/3)), (top + (thingHeight/3) + (thingHeight/8)) - ((thingHeight/22)/3), (top + (thingHeight/3) - ((thingHeight/22)/3))}, 3);
		}
		if (mouthType.equalsIgnoreCase("o")) {
			g.setColor(Color.WHITE);
			g.fillOval((left + (thingWidth/2) - ((thingWidth/2)/2)), (top + (2*(thingHeight)/3)), (thingWidth/2), (thingHeight/8));
		}
		else if (mouthType.equalsIgnoreCase("r")) {
			g.setColor(Color.WHITE);
			g.fillRect((left + (thingWidth/2) - ((thingWidth/2)/2)), (top + (2*(thingHeight)/3)), (thingWidth/2), (thingHeight/8));
		
		}
		if (eyeType.equalsIgnoreCase("c")) {
			g.setColor(Color.WHITE);
			g.fillOval((left + (thingWidth/4) - ((thingWidth/8)/2)), (top + (thingHeight/8)), (thingWidth/8), (thingHeight/8));
			g.fillOval((left + ((3*thingWidth)/4) - ((thingWidth/8)/2)), (top + (thingHeight/8)), (thingWidth/8), (thingHeight/8));
		}
		else if (eyeType.equalsIgnoreCase("s")) {
			g.setColor(Color.WHITE);
			g.fillRect((left + (thingWidth/4) - ((thingWidth/8)/2)), (top + (thingHeight/8)), (thingWidth/8), (thingHeight/8));
			g.fillRect((left + ((3*thingWidth)/4) - ((thingWidth/8)/2)), (top + (thingHeight/8)), (thingWidth/8), (thingHeight/8));
		}
		else if (eyeType.equalsIgnoreCase("t")) {
			g.setColor(Color.WHITE);
			g.fillPolygon(new int [] {(left + (thingWidth/3)), (left + (thingWidth/3) - ((thingWidth/8))), (left + (thingWidth/3) - ((thingWidth/8)/2))}, new int [] {(top + (thingHeight/3)), (top + (thingHeight/3)),(top + ((thingHeight/4)/2))}, 3);
			g.fillPolygon(new int[] {(left + (3*thingWidth)/4)+ ((thingWidth/8)/2), (left + ((3*thingWidth)/4) - (2*(thingWidth/8)/2)) + ((thingWidth/8)/2), (left + ((3*thingWidth)/4) - ((thingWidth/8)/2)) + ((thingWidth/8)/2)}, new int [] {(top + (thingHeight/3)), (top + (thingHeight/3)),(top + (thingHeight/4)/2)}, 3 ) ;
		}
	}
}
class PumpkinFrame extends JFrame{//This class sets all the defaults and sets the window size and where the window shows up.
	private PicturePanel panCenter;
	public void centerPumpkin() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int screenWidth = (int)dim.getWidth();
		int screenHeight = (int)dim.getHeight();
		int frameWidth = 800;
		int frameHeight = 480;
		int left = (screenWidth - frameWidth)/2;
		int top = (screenHeight - frameHeight)/2;
		setBounds(left, top, frameWidth, frameHeight);
	}
	public void pumpkinLook() {
		setTitle("Pumpkin Maker");
		centerPumpkin();
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		panCenter = new PicturePanel();
		panCenter.setThingHeight(100);//These are the defaults for the pumpkin.
		panCenter.setThingWidth(200);
		panCenter.setLeft(100);
		panCenter.setTop(100);
		panCenter.setEyeType("c");
		panCenter.setMouthType("o");
		panCenter.setNoseType("s");
		c.add(panCenter, BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JLabel lblLeft = new JLabel("Left:");//These are all the inputs that you will see at the bottom of the window.
		panSouth.add(lblLeft);
		JTextField txtLeft = new JTextField(3);
		panSouth.add(txtLeft);
		JLabel lblTop = new JLabel("Top:");
		panSouth.add(lblTop);
		JTextField txtTop = new JTextField(3);
		panSouth.add(txtTop);
		JLabel lblWidth = new JLabel("Width:");
		panSouth.add(lblWidth);
		JTextField txtWidth = new JTextField(3);
		panSouth.add(txtWidth);
		JLabel lblHeight = new JLabel("Height");
		panSouth.add(lblHeight);
		JTextField txtHeight = new JTextField(3);
		panSouth.add(txtHeight);
		JLabel lblEye = new JLabel("Eye (C S T):");
		panSouth.add(lblEye);
		JTextField txtEye = new JTextField(1);
		panSouth.add(txtEye);
		JLabel lblNose = new JLabel("Nose (C S T):");
		panSouth.add(lblNose);
		JTextField txtNose = new JTextField(1);
		panSouth.add(txtNose);
		JLabel lblMouth = new JLabel("Mouth (O R):");
		panSouth.add(lblMouth);
		JTextField txtMouth = new JTextField(1);
		panSouth.add(txtMouth);
		JButton btnDraw = new JButton("Draw");//This is the button that change everything the user wanted to change about the pumpkin
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				panCenter.setLeft(Integer.parseInt(txtLeft.getText()));
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "You either enter in a negative number or didn't enter anything for how far from the left side of the window. Try again");
				}
				try {
				panCenter.setTop(Integer.parseInt(txtTop.getText()));
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "You either enter in a negative number or didn't enter anything for how far from the top side of the window. Try again");
				}
				try {
				panCenter.setThingHeight(Integer.parseInt(txtHeight.getText()));
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "You either enter in a negative number or didn't enter anything for how tall you want the pumpkin to be. Try again");
				}
				try {
				panCenter.setThingWidth(Integer.parseInt(txtWidth.getText()));
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "You either enter in a negative number or didn't enter anything for how Wid you want the pumpkin to be. Try again");
				}
				panCenter.setEyeType(txtEye.getText().trim());
				panCenter.setNoseType(txtNose.getText().trim());
				panCenter.setMouthType(txtMouth.getText().trim());
				repaint();
			}
		});
		panSouth.add(btnDraw);
		c.add(panSouth, BorderLayout.SOUTH);
	}
		
	
	public PumpkinFrame() {
		pumpkinLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
public class Pumpkin {//This is the thing that makes the whole thing run.
	public static void main(String[] args) {
		PumpkinFrame  frm = new PumpkinFrame();
		frm.setVisible(true);
	}
}

