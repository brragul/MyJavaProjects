package drawingPad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DrawCircle extends JPanel implements KeyListener {
static JFrame frame = new JFrame();
public static void main(String[] args)
{
	JColorChooser cc = new JColorChooser();
	JButton b =new JButton("Color Chooser");
	JLabel l =new JLabel("I am a label");
	frame.setVisible(true);
	frame.setSize(600, 600);
	//frame.add(b, BorderLayout.WEST);
	//frame.add(l, BorderLayout.NORTH);
	//frame.add(cc,BorderLayout.SOUTH);
	//frame.getContentPane().setBackground(Color.BLUE);
	frame.getContentPane().add(CreateMenuBar.addMenu(),BorderLayout.NORTH);
	b.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Color mycolor =cc.getColor();
			System.out.println(mycolor);
			//l.setForeground(mycolor);
			//frame.setBackground(mycolor);
			DrawCircle dc = new DrawCircle();
		}
		
	});
}
DrawCircle(){
	repaint();
}
protected void paintComponent(Graphics g){
	g.drawString(s, 500, 500);
	frame.addKeyListener(this);
}
@Override
public void keyPressed(KeyEvent e) {

}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent e) {
	s=s+String.valueOf(e.getKeyChar());
	System.out.println(s);
	repaint();	
}
String s="";
}
