package drawingPad;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawSquare extends JPanel {
	int x1,y1,x2,y2;
	public void displaySquare(int x1,int y1,int x2,int y2){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		//System.out.println("X1 Y1 X2 Y2 :"+this.x1+" "+this.y1+" "+this.x2+" "+this.y2+" ");
		repaint();
	}
	public void paint(Graphics g){
		System.out.println("Paint method called");
		 g.setColor(Color.BLACK);
		 g.drawRect(x1, y1, x2, y2);
	}
}
