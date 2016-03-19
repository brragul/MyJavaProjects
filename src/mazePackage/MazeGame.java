package mazePackage;

import javax.swing.JFrame;

public class MazeGame {
	//Referenced the maze game tutorial in the youtube link https://www.youtube.com/watch?v=64V8CC7nSok
	public static JFrame frame;
	public MazeGame(){
		 frame = new JFrame();
		frame.setTitle("My Maze");
		frame.add(new Board());
		frame.setVisible(true);
		frame.setSize(690, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
