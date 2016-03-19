package mazePackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Maze {
	public static void main(String[] args) {
		new Maze();
	}
	public Maze(){
		JFrame frame = new JFrame("Maze");
		frame.setVisible(true);
		frame.setSize(690, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		JLabel mazeselectlabel = new JLabel("Select maze size");
		JComboBox<String> combosize = new JComboBox<String>();
		JComboBox<String> combotheme = new JComboBox<String>();
		JButton startbutton = new JButton("Start Maze");
		String[] smaze = new String[]{"10X10","20x20","30x30","40x40"} ;
		String[] cmaze = new String[]{"Snow White","Breaking Bad","Harry Potter",""};
		for(int i=0;i<smaze.length;i++){
			combosize.addItem(smaze[i]);
		}
		for(int i=0;i<cmaze.length;i++){
			combotheme.addItem(cmaze[i]);
		}
		
		frame.add(mazeselectlabel);
		frame.add(combosize);
		frame.add(combotheme);
		frame.add(startbutton);
		startbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new MazeGame();
				frame.dispose();
			}
		});
	}
}
