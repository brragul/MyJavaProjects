package sortImplementation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class ButtonTesting extends JFrame{
	static JFrame frame = new JFrame("Sorting");
	static ButtonGroup bg = new ButtonGroup();
	public static void main(String[] args) {
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(10,1));
		JRadioButton bubble = new JRadioButton("Bubble Sort");
		JRadioButton selection = new JRadioButton("Selection Sort");
		JRadioButton insertion = new JRadioButton("Insertion Sort");

		frame.add(bubble);
		frame.add(selection);
		frame.add(insertion);
		bubble.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("bubble Sort Selected");
			}
		});
	}

}
