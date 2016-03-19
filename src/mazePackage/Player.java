package mazePackage;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	
	private int tilex,tiley;
	private Image pl;
	public Player(){
		
		ImageIcon img = new ImageIcon("D://Maze img//"+MazeWind.getTheme()+"//img.png");
		pl =img.getImage();
		
		tilex=1;
		tiley=1;
	}
	
	public Image getPlayer(){
		return pl;
	}
	
	
	public int getTileX(){
		return tilex;
	}
	public int getTileY(){
		return tiley;
	}
	
	public void move(int dx,int dy){
		
		tilex+=dx;
		tiley+=dy;
		
	}
}
