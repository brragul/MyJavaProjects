package mazePackage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class MazeWind {

	private JFrame frmChooseMaze;
	public static int x=10;
	public int y=10;
	public static String theme="Default";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MazeWind window = new MazeWind();
					window.frmChooseMaze.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MazeWind() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Board.solvebool=false;
		String[] smaze = new String[]{"10X10","20x20","30x30","40x40"} ;
		String[] cmaze = new String[]{"Snow White","Breaking Bad","Harry Potter","Default"};
		
		frmChooseMaze = new JFrame();
		frmChooseMaze.setTitle("Choose Maze");
		frmChooseMaze.setBounds(100, 100, 459, 277);
		frmChooseMaze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChooseMaze.getContentPane().setLayout(null);
		
		JLabel mazeselectlabel = new JLabel("Select maze size");
		mazeselectlabel.setBounds(78, 30, 119, 20);
		frmChooseMaze.getContentPane().add(mazeselectlabel);
		
		JComboBox combosize = new JComboBox(smaze);
		combosize.setBounds(212, 27, 90, 26);
		frmChooseMaze.getContentPane().add(combosize);
		
		JLabel themeselectlabel = new JLabel("Select maze theme");
		themeselectlabel.setBounds(58, 76, 139, 20);
		frmChooseMaze.getContentPane().add(themeselectlabel);
		
		JComboBox combotheme = new JComboBox(cmaze);
		combotheme.setBounds(212, 73, 166, 26);
		frmChooseMaze.getContentPane().add(combotheme);
		
		JButton startbutton = new JButton("Start Maze");
		startbutton.setBounds(78, 132, 115, 29);
		frmChooseMaze.getContentPane().add(startbutton);
		
		JButton solvebutton = new JButton("Solve");
		solvebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Board.solvebool=true;
				new MazeGame();
				frmChooseMaze.dispose();
			}
		});
		solvebutton.setBounds(214, 132, 115, 29);
		frmChooseMaze.getContentPane().add(solvebutton);
		
		startbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new MazeGame();
				frmChooseMaze.dispose();
			}
		});
		
		combosize.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s =(String) combosize.getSelectedItem();
				
				switch(s){
				case "10x10":
					setMazeSize(10);
					break;
				case "20x20":
					setMazeSize(20);
					break;
				case "30x30":
					setMazeSize(30);
					break;
				case "40x40":
					setMazeSize(40);
					break;
				}
			}
			
		});
		combotheme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String s1=(String) combotheme.getSelectedItem();
					setTheme(s1);				
			}
			
		});
		
	}
	
	public void setMazeSize(int x){
		this.x=x;
	}
	
	public static int getMazeSize(){
		return x;
	}
	
	public void setTheme(String theme){
		this.theme=theme;
	}
	
	public static String getTheme(){
		return theme;
	}
	
}
