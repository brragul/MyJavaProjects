package drawingPad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

public class DrawPad implements MouseListener,MouseMotionListener,ActionListener,KeyListener {
	int x1,y1,x2,y2;
	private static JFrame frame;
	static Scribble te = new Scribble();
	static JColorChooser cc = new JColorChooser();
	static boolean mousepressed =false;
	static boolean drawlinebool=false;
	static boolean drawcirclebool=false;
	static boolean drawsquarebool=false;
	static boolean clearrectbool = false;
	static boolean erasebool = false;
	static boolean textbool = false;
	static boolean drawtribool=false;
	static boolean drawpenbool=false;
	static Color c=Color.BLACK;
	static JToggleButton filltoggle;
	static int erasersize =10;
	static String text="";
	JFileChooser fc = new JFileChooser();
	JTextPane temp;
	static String font="TimesNew";
	static int fontsize=14;
	static BufferedImage img;
	static JLabel lbl;
	public static void main(String[] args) {
		frame = new JFrame("Draw Pad");
		frame.setVisible(true);
		frame.setSize(1332,761);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel bpanel = new JPanel();
		bpanel.setBounds(0, 0, 258, 308);
		bpanel.setLayout(new GridLayout(6,2));
		JButton circle = new JButton("Circle");
		JButton line = new JButton("Line");
		JButton square = new JButton("Rectangle");
		JButton scribble = new JButton("Scribble");
		
		bpanel.add(scribble);
		bpanel.add(circle);
		bpanel.add(line);
		bpanel.add(square);
		frame.getContentPane().setLayout(null);
		te.setBounds(0, -31, 1295, 792);
		frame.getContentPane().add(te);
		
		lbl = new JLabel();
		te.add(lbl);
		
		
		
		//te.setLayout(new BorderLayout(0, 0));
		cc.setBounds(0, 313, 258, 263);
		frame.getContentPane().add(cc);
		frame.getContentPane().add(bpanel);
		filltoggle = new JToggleButton("Fill Color");
		bpanel.add(filltoggle);
		
		JButton clearRect = new JButton("Clear Rectangle");
		bpanel.add(clearRect);
		JButton choosercolor= new JButton("Choose Color");
		bpanel.add(choosercolor);
		
		JButton erasebutton = new JButton("Eraser");
		bpanel.add(erasebutton);
		
		JButton bgncolor = new JButton("Fill Background");
		bpanel.add(bgncolor);
		
		JButton textbtn = new JButton("Text");
		bpanel.add(textbtn);
		
		JButton tributton = new JButton("Triangle");
		bpanel.add(tributton);
		
		JButton penbutton = new JButton("Pentagon");
		bpanel.add(penbutton);
		bgncolor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color c1 =cc.getColor();
				frame.getContentPane().setBackground(c1);
			}
			
		});
		choosercolor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				c=cc.getColor();
			}
		});
		frame.getContentPane().add(CreateMenuBar.addMenu(),BorderLayout.EAST);
		
		
		
		DrawPad dp = new DrawPad();
		dp.mouseInit();
		dp.menuInit();
		
		
		circle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				drawcirclebool=true;
				drawlinebool=false;
				drawsquarebool=false;
				text=null;
				
				
			}
		});
		line.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				drawlinebool=true;
				drawcirclebool=false;
				drawsquarebool=false;
				text=null;
			}
		});
		square.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				drawlinebool=false;
				drawcirclebool=false;
				drawsquarebool=true;
				text=null;
			}
		});
		scribble.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				drawlinebool=false;
				drawcirclebool=false;
				drawsquarebool=false;
				mousepressed=true;
				text=null;
				drawtribool=false;
				textbool=false;
			}
		});
		clearRect.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					clearrectbool=true;
					drawlinebool=false;
					drawcirclebool=false;
					drawsquarebool=false;
					textbool=false;
					text=null;
					drawtribool=false;
			}
			
		});
		erasebutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options ={"10","20","30","40"};
				int choice =JOptionPane.showOptionDialog(null, "Choose size", "Eraser", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,options , "10");
				System.out.println(choice);
				if(choice == 0 )
				{
				erasersize=10;
				}
				else if(choice ==1)
				{
					erasersize=20;
				}
				else if(choice ==2)
				{
					erasersize=30;
				}
				else if(choice ==3)
				{
					erasersize=40;
				}
				clearrectbool=false;
				drawlinebool=false;
				drawcirclebool=false;
				drawsquarebool=false;
				textbool=false;
				erasebool=true;
				text=null;
				drawtribool=false;
			}
			
		});
		tributton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearrectbool=false;
				drawlinebool=false;
				drawcirclebool=false;
				drawsquarebool=false;
				textbool=false;
				erasebool=false;
				text=null;
				drawtribool=true;
			}
			
		});
		penbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearrectbool=false;
				drawlinebool=false;
				drawcirclebool=false;
				drawsquarebool=false;
				textbool=false;
				erasebool=false;
				text=null;
				drawtribool=false;
				drawpenbool=true;
			}
			
		});
		
		
	}
	private void menuInit(){
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnNewMenu.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mnNewMenu.add(mntmLoad);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mnNewMenu.add(mntmSaveAs);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		
		JMenu mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		JMenu mnFont = new JMenu("Font");
		mnOption.add(mnFont);
		
		JMenuItem mntmTimesNewRoman = new JMenuItem("Times New Roman");
		mnFont.add(mntmTimesNewRoman);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Calibri");
		mnFont.add(mntmNewMenuItem);
		
		JMenuItem mntmSanSerif = new JMenuItem("San Serif");
		mnFont.add(mntmSanSerif);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mono Spaced");
		mnFont.add(mntmNewMenuItem_1);
		
		JMenu mnFontSize = new JMenu("Font Size");
		mnOption.add(mnFontSize);
		
		JMenuItem m12 = new JMenuItem("12");
		mnFontSize.add(m12);
		
		JMenuItem m14 = new JMenuItem("14");
		mnFontSize.add(m14);
		
		JMenuItem m16 = new JMenuItem("16");
		mnFontSize.add(m16);
		
		JMenuItem m18 = new JMenuItem("18");
		mnFontSize.add(m18);
		
		JMenuItem m20 = new JMenuItem("20");
		mnFontSize.add(m20);
		
		JMenuItem m22 = new JMenuItem("22");
		mnFontSize.add(m22);
		
		JMenuItem m24 = new JMenuItem("24");
		mnFontSize.add(m24);
		
		JMenuItem btnUndo = new JMenuItem("Undo");
		mnOption.add(btnUndo);
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mnOption.add(mntmRedo);
		mntmNew.addActionListener(this);
		mntmOpen.addActionListener(this);
		mntmSave.addActionListener(this);
		mntmSaveAs.addActionListener(this);
		mntmExit.addActionListener(this);
		mntmLoad.addActionListener(this);
		mntmTimesNewRoman.addActionListener(this);
		mntmNewMenuItem.addActionListener(this);
		mntmSanSerif.addActionListener(this);
		mntmNewMenuItem_1.addActionListener(this);
		m12.addActionListener(this);
		m16.addActionListener(this);
		m18.addActionListener(this);
		m20.addActionListener(this);
		m14.addActionListener(this);
		m22.addActionListener(this);
		m24.addActionListener(this);
		btnUndo.addActionListener(this);
		mntmRedo.addActionListener(this);
		
		
	}
	private void mouseInit(){
		frame.addMouseMotionListener(this);
		frame.addMouseListener(this);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		
	}
	
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mousepressed=true;
		Point p = arg0.getPoint();
		if(mousepressed)
		{
			if(drawlinebool || drawcirclebool ||drawsquarebool||clearrectbool||textbool||drawtribool||drawpenbool){
				//do nothing
			}
			else{
		x2=p.x;
		y2=p.y;		
		te.assignment(x1, y1, x2, y2,c);		
		x1=p.x;
		y1=p.y;
			}
		}
	}

	
	@Override
	public void mousePressed(MouseEvent arg0) {		
		p1=arg0.getPoint();
		Point p= arg0.getPoint();
		if(erasebool)
		{
			x1=p.x;
			y1=p.y;
			x2=x1+10;
			y2=y1+10;
			
			//System.out.println(x1+" "+y1+" "+x2+" "+y2);
			te.assignment(x1, y1, x2, y2,c);
		}
		else{
		x1=p.x;
		y1=p.y;
		System.out.println("Mouse is pressed"+x1+" "+y1);}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(drawlinebool || drawcirclebool|| drawsquarebool||clearrectbool||drawtribool||drawpenbool)
		{
			Point p =arg0.getPoint();
			x2=p.x;
			y2=p.y;
			te.assignment(x1, y1, x2, y2,c);
		}
		mousepressed = false;
		System.out.println("Mouse is released"+x2+" "+y2);

	}
	@Override
	public void mouseMoved(MouseEvent arg0) {}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e){
		String s =e.getActionCommand();
		switch(s){
		case "New":
			te.newFile();
			break;
		case "Open":
			System.out.println("Open called");
			int retval = fc.showDialog(null, "Open");
		      if (retval == JFileChooser.APPROVE_OPTION) {
			File theFile = fc.getSelectedFile();
			if (theFile != null) {
			  if (theFile.isFile()) {
			    String filename = fc.getSelectedFile().getAbsolutePath();
			    bufferimg(filename);
			    System.out.println(filename);
			  }
			}
		      }
				
			break;
		case "Load":
			int retval1 = fc.showDialog(null, "Load");
		      if (retval1 == JFileChooser.APPROVE_OPTION) {
			File theFile = fc.getSelectedFile();
			if (theFile != null) {
			  if (theFile.isFile()) {
			    String filename = fc.getSelectedFile().getAbsolutePath();
			  te.printPoints(filename);
			  }
			}
		      }
			break;
		case "Save":
			System.out.println("Save Pressed");
			te.saveFile("Untitled11");
			break;
		case "Save As":
			int ret =fc.showDialog(null, "Save As");
			if(ret==JFileChooser.APPROVE_OPTION)
				theFile = fc.getSelectedFile();
			if(theFile != null)
				if(theFile.isDirectory())
				{
					String filename = fc.getSelectedFile().getAbsolutePath();
					te.saveFile(filename);
				}
			break;
		case "Exit":
			frame.dispose();
			break;
		case "Times New Roman":
			font="TimesNew";
			break;
		case "Calibri":
			font="Calibri";
			break;
		case "San Serif":
			font="Sans-serif";
			break;
		case "Mono Spaced":
			font="Monospaced";
			break;
		case "12":
			fontsize=12;
			break;
		case "14":
			fontsize=14;
			break;
		case "16":
			fontsize=16;
			break;
		case "18":
			fontsize=18;
			break;
		case "20":
			fontsize=20;
			break;
		case "22":
			fontsize=22;
			break;
		case "24":
			fontsize=24;
			break;
		case "Undo":
			te.undoShape();
			break;
		case "Redo":
			te.redoShape();
			break;
				
		}
	}
	private void bufferimg(String filename) {
		img=null;
		try {
			img=ImageIO.read(new File(filename));
			ImageIcon ic = new ImageIcon(img);
			lbl.setIcon(ic);
			lbl.setBounds(0, 300, 600, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	File theFile;

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("Key Event called");
		text=text+String.valueOf(arg0.getKeyChar());
		
		te.assignment(p1.x, p1.y, p1.x, p1.y, c);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	Point p1;
	public static String getFont() {
		// TODO Auto-generated method stub
		return font;
	}
	public static int getFontSize() {
		// TODO Auto-generated method stub
		return fontsize;
	}
}
