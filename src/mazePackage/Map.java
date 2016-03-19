package mazePackage;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Map {
	
	private Scanner m;
	String[] tile = new String[MazeWind.getMazeSize()];
	
	private Image grass, wall,door,reach,solve;
	
	public Map(){
		
		ImageIcon img =new ImageIcon("D://Maze img//"+MazeWind.getTheme()+"//grass.png");
		grass=img.getImage();
		img = new ImageIcon("D://Maze img//"+MazeWind.getTheme()+"//wall.png");
		wall = img.getImage();
		img = new ImageIcon("D://Maze img//"+MazeWind.getTheme()+"//door.png");
		door= img.getImage();
		img = new ImageIcon("D://Maze img//destiny.png");
		reach = img.getImage();
		img = new ImageIcon("D://Maze solve//maze"+String.valueOf(MazeWind.getMazeSize())+".png");
		solve = img.getImage();
		openFile();
		readFile();
		closeFile();
	}

	public Image getGrass(){
		return grass;
	}
	public Image getWall(){
		return wall;
	}
	public Image getDoor(){
		return door;
	}
	public Image getReach(){
		return reach;
	}
	public Image getSolve(){
		return solve;
	}
	public String getMap(int x,int y){
		String index = tile[y].substring(x, x+1);
		return index;
	}
	
	private void closeFile() {
		// TODO Auto-generated method stub
		
	}

	private void readFile() {
		while(m.hasNext()){
			for(int i=0;i<MazeWind.getMazeSize();i++){
				tile[i]=m.next();
			}
		}
	}

	private void openFile() {
		try {
			String s =String.valueOf(MazeWind.getMazeSize()).substring(0, 1);
			m = new Scanner(new File("D://Maze txt//maze"+s+".txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
