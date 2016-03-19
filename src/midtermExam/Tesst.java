package midtermExam;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Tesst {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tesst window = new Tesst();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tesst() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 839, 727);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 29, 564, 612);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 114, 113);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(8, 5, 97, 25);
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(8, 37, 97, 25);
		panel_1.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(8, 75, 97, 25);
		panel_1.add(button_1);
		
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setBounds(12, 139, 114, 126);
			}
			
		});
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("Timer Started");
			}
			
		},2, 1000);
		
	}

}
