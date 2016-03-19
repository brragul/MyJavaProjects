package sortImplementation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SelectionDraw extends JComponent{
	//Selection Display
	static int size=0;
	static DisplaySort ds = new DisplaySort();
	static int count=0;
	public void drawRect() {
		size=ds.iii.length;
		System.out.println("Selection Drawing Running");
		repaint();
		
	}

	public void paintComponent(Graphics g)
	{
		
		g.setColor(Color.BLUE);
		for(int i=0;i<size;i++){
			if(ds.graphic==1)
			{
		g.fillRect(20*i,50,10,ds.iii[i]*20);}
			else if(ds.graphic==2){
				int xpoints[] = {20*i,(20*i)+10,(20*i)+5};
			    int ypoints[] = {50,50,50+(ds.iii[i]*20)};
			    int npoints = 3;
			    
			    g.drawPolygon(xpoints, ypoints, npoints);
			}
			else if(ds.graphic==3){
				g.drawRoundRect(20*i,50,10,ds.iii[i]*20, 10, 20);
			}
		}
		
		}
		
		
	}

