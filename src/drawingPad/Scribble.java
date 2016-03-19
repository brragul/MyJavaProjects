package drawingPad;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

public class Scribble extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x1,y1,x2,y2;
	Color getcolor;
	boolean loadbool=false;
	boolean undobool=false;
	boolean redobool=false;
	int[] tx = new int[3];
	int[] ty = new int[3];

	int[] px = new int[5];
	int[] py = new int[5];
 	protected List<Shape> stroke = new ArrayList<Shape>();
 	protected List<Shape> strokeredo = new ArrayList<Shape>();
public void assignment(int x1,int y1,int x2,int y2, Color c){
	if(DrawPad.drawlinebool)
	{
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		
	}
	else if(DrawPad.drawtribool)
	{
		tx[0]=(int)(x2-x1)/2;
		tx[1]=x2-x1;
		tx[2]=x2;
		ty[0]=y1;
		ty[1]=y2;
		ty[2]=y2;
	}
	else if(DrawPad.drawcirclebool|| DrawPad.drawsquarebool)
	{
		this.x1=Math.min(x1, x2);
		this.y1=Math.min(y1, y2);
		this.x2=Math.abs(x1-x2)+1;
		this.y2=Math.abs(y1-y2)+1;
	}
	else if(DrawPad.drawpenbool)
	{
		px[0]=(int)(x2-x1)/2;
		px[1]=x1;
		px[2]=x2;
		px[3]=x1;
		px[4]=x2;
		py[0]=y1;
		py[1]=(int)(y2-y1)/2;
		py[2]=(int)(y2-y1)/2;
		py[3]=y2;
		py[4]=y2;

	}
	else
	{
	this.x1=x1;
	this.y1=y1;
	this.x2=x2;
	this.y2=y2;
	}
	getcolor=c;
	System.out.println(DrawPad.drawcirclebool+" "+DrawPad.drawlinebool);
	repaint();
}
public void paintComponent(Graphics g){
	 g.setColor(getcolor);
	 if(DrawPad.drawlinebool)
	 {
		 System.out.println("Line Drawn");
		 g.drawLine(x1, y1, x2, y2);
		 stroke.add(new Line2D.Float(x1, y1, x2, y2));
	 }
	 else if(DrawPad.drawcirclebool)
	 {
		 if(DrawPad.filltoggle.isSelected())
		 {
			 g.fillOval(x1, y1, x2, y2);
		 }
		 else
		 {

		 g.drawOval(x1, y1, x2, y2);
		 stroke.add(new Ellipse2D.Float(x1, y1, x2, y2));

		 }
		 System.out.println("Circle Drawn");
		 

	 }
	 else if(DrawPad.drawsquarebool)
	 {
		 if(DrawPad.filltoggle.isSelected())
		 {
			 g.fillRect(x1, y1, x2, y2);

		 }
		 
		 else{
			 g.drawRect(x1, y1, x2, y2);
			 stroke.add(new Rectangle2D.Float(x1, y1, x2, y2));

		}
		 System.out.println("Rectangle Drawn");

	}
	 else if(DrawPad.drawtribool)
	 {
		 if(DrawPad.filltoggle.isSelected())
			{
			 g.fillPolygon(tx, ty, 3);
			}
		 else{
		 g.drawPolygon(tx, ty, 3);
		 stroke.add(new Polygon(tx,ty,3));

		 }
	 }
	 else if(DrawPad.drawpenbool)
	 {
		 if(DrawPad.filltoggle.isSelected())
		 {
			 g.fillPolygon(px, py, 5);
		 }
		 else{
			 g.drawPolygon(px, py, 5);
		 }
	 }
	 else if(loadbool)
	 {
		 Iterator it1 =stroke.iterator();
		 if(it1 !=null)
		 {
			 Point pre =(Point)it1.next();
			 while(it1.hasNext())
			 {
				 Point cur =(Point)it1.next();
				 g.drawLine(pre.x, pre.y, cur.x, cur.y);
				 pre= cur;
			 }
		 }
		
	 }
	 else if(DrawPad.clearrectbool)
	 {
		 g.clearRect(x1, y1, (x2-x1), (y2-y1));
	 }
	 else if(DrawPad.erasebool)
	 {
		 g.clearRect(x1, y1,DrawPad.erasersize , DrawPad.erasersize);
		 
		 
	 }
	 else if(undobool){
		 for(Shape s: stroke)
		 {
			 
			 Graphics2D gg = (Graphics2D)g;
			 gg.draw(s);
		 }
	 }
	 else if(redobool)
	 {
		 for(Shape s: stroke)
		 {
			 
			 Graphics2D gg = (Graphics2D)g;
			 gg.draw(s);
		 }
		 for(Shape s1 : strokeredo)
		 {
			 Graphics2D ggg = (Graphics2D)g;
			 ggg.draw(s1);
		 }
	 }
	 
	 else{
		 
		 System.out.println("Scribble Drawn");
		 g.drawLine(x1, y1, x2, y2);
	 }
	 if(DrawPad.text!=null){
		 String fonttype=DrawPad.getFont();
		 int fontsize=DrawPad.getFontSize();
		 g.setFont(new Font(fonttype,Font.PLAIN,fontsize));
		 g.drawString(DrawPad.text, x1, y1);
	 }
}
public void newFile() {
removeAll();
revalidate();
repaint();
}
public void saveFile(String string)  {
	try {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(string));
		out.writeObject(stroke);
		out.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public void printPoints(String filename){
	try {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		stroke= (List)in.readObject();
		in.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	loadbool=true;
	repaint();
	System.out.println(stroke);
}
public void undoShape(){
	DrawPad.clearrectbool=false;
	DrawPad.drawlinebool=false;
	DrawPad.drawcirclebool=false;
	DrawPad.drawsquarebool=false;
	DrawPad.textbool=false;
	DrawPad.erasebool=false;
	DrawPad.text=null;
	DrawPad.drawtribool=false;
	DrawPad.drawpenbool=false;
	redobool =false;
	undobool = true;
	int siz=stroke.size()-1;
	strokeredo.add(stroke.get(siz));
	stroke.remove(stroke.size()-1);
	
	repaint();
}
public void redoShape(){
	DrawPad.clearrectbool=false;
	DrawPad.drawlinebool=false;
	DrawPad.drawcirclebool=false;
	DrawPad.drawsquarebool=false;
	DrawPad.textbool=false;
	DrawPad.erasebool=false;
	DrawPad.text=null;
	DrawPad.drawtribool=false;
	DrawPad.drawpenbool=false;
	undobool = false;
	redobool=true;
	repaint();
}
}
