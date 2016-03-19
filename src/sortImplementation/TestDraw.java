package sortImplementation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class TestDraw extends JComponent{
	public  void draw(){
		repaint();
	}
	public void paintComponent(Graphics g)
	{
		int[] a = new int[]{5,4,3,2,1};
		for(int q=0;q<a.length;q++)
		{
		
		g.setColor(Color.RED);
		int xpoints[] = {20*q,(20*q)+10,(20*q)+5};
	    int ypoints[] = {50,50,50+(a[q]*20)};
	    int npoints = 3;
	    
	    g.drawPolygon(xpoints, ypoints, npoints);
		g.drawRoundRect(20*q,50,10,a[q]*20, 10, 20);
		//g.draw3DRect(20*q,50,10,a[q]*20,true);
		}
	}
}
