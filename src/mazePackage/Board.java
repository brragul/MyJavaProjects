package mazePackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Board extends JPanel implements ActionListener,KeyListener{

	public static boolean solvebool;
	private Timer timer;
	public static boolean winbool=false;
	private Map m;
	private Player p;
	Image img;
	
	InputStream in;
	AudioStream audio,winaudio;
	public Board(){
		
		m= new Map();
		p= new Player();
		addKeyListener(this);
		setFocusable(true);
		timer = new Timer(25,this);
		timer.start();
		initiateSounds();
	}
	
	private void initiateSounds() {
		try {
			in = new FileInputStream("D://Maze sound//ding.wav");
			audio = new AudioStream(in);
			in = new FileInputStream("D://Maze sound//win.wav");
			winaudio = new AudioStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		if(!solvebool){
				if(!winbool){
				for(int y=0;y<MazeWind.getMazeSize();y++){
					for(int x=0;x<MazeWind.getMazeSize();x++){
						if(m.getMap(x, y).equals("g")){
						g.drawImage(m.getGrass(), x*30, y*30,30,30, null);
						}
						if(m.getMap(x, y).equals("w")){
						g.drawImage(m.getWall(), x*30, y*30,30,30, null);
						}
						if(m.getMap(x, y).equals("d")){
							g.drawImage(m.getDoor(), x*30, y*30,30,30, null);
						}
						if(m.getMap(x, y).equals("r")){
							g.drawImage(m.getReach(), x*30, y*30,30,30, null);
						}
					}
					
				}
				
				g.drawImage(p.getPlayer(), p.getTileX()*30, p.getTileY()*30,30,30, null);
				}else{
					ImageIcon ic  = new ImageIcon("D://Maze img//winner.png");
					img = ic.getImage();
					g.drawImage(img, 0, 0,500,500, null);
				}
		}else{
			g.drawImage(m.getSolve(), 0,0,500,500, null);
		}
		
		}
	@Override
	public void keyPressed(KeyEvent e){
		System.out.println("Key Pressed event called");
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_UP){
			System.out.println("Up Pressed");
			if(!m.getMap(p.getTileX(), p.getTileY()-1).equals("w")&&!m.getMap(p.getTileX(), p.getTileY()-1).equals("d")){
			p.move( 0, -1);}else{
				AudioPlayer.player.start(audio);
			}
		}else if(keycode == KeyEvent.VK_DOWN){
			System.out.println("Down Pressed");
			if(!m.getMap(p.getTileX(), p.getTileY()+1).equals("w")&&!m.getMap(p.getTileX(), p.getTileY()+1).equals("d")){
			p.move(0, 1);}else{
				AudioPlayer.player.start(audio);
			}
		}else if(keycode == KeyEvent.VK_LEFT){
			System.out.println("Right Pressed");
			if(!m.getMap(p.getTileX()-1, p.getTileY()).equals("w")&&!m.getMap(p.getTileX()-1, p.getTileY()).equals("d")){
			p.move(-1, 0);}else{
				AudioPlayer.player.start(audio);
			}
		}else if(keycode == KeyEvent.VK_RIGHT){
			System.out.println("Left Pressed");
			if(!m.getMap(p.getTileX()+1, p.getTileY()).equals("w")&&!m.getMap(p.getTileX()+1, p.getTileY()-1).equals("d")&&!m.getMap(p.getTileX()+1, p.getTileY()).equals("r")){
			p.move(1, 0);}else{
				AudioPlayer.player.start(audio);
			}
			if(m.getMap(p.getTileX()+1, p.getTileY()).equals("r")){
				winbool=true;
				System.out.println("Reached");
				AudioPlayer.player.start(winaudio);
			}
		}else if(keycode == KeyEvent.VK_ENTER){
			if(m.getMap(p.getTileX(), p.getTileY()-1).equals("d")){
				p.move(0, -2);
			}
			if(m.getMap(p.getTileX(), p.getTileY()+1).equals("d")){
				p.move(0, 2);
			}
			if(m.getMap(p.getTileX()-1, p.getTileY()).equals("d")){
				p.move(-2, 0);
			}
			if(m.getMap(p.getTileX()+1, p.getTileY()-1).equals("d")){
				p.move(2, 0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	}


