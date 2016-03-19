package timerPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MicroWave1 extends JFrame {

	private JPanel contentPane;
	static JLabel lblNewLabel;
	static JLabel lblNewLabel_1;
	static JButton btnStart;

	static boolean timebool = false;
	static Timer timer;
	static int second = 60;
	static int minuit = 0;

	public static void main(String[] args) {

		MicroWave1 ts = new MicroWave1();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MicroWave1 frame = new MicroWave1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		try {
			while (true) {
				lblNewLabel_1.setText("Your Food is preparing");

				if (timebool == false) {
					String s = time();
					lblNewLabel.setText(s);
				}
				if (second == 0 && minuit == 0) {
					lblNewLabel_1.setText("Your Food id ready");
				}
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("");
		}

	}

	public static void setTimer1() {
		long delay = 1000;
		long period = 1000;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				lblNewLabel.setText(setTimer());
			}
		}, delay, period);
	}
	private static String setTimer() {
		--second;
		if (second == 0 && minuit == 0) {
			timer.cancel();
			timebool = false;
		}

		if (second == 0 && minuit != 0) {
			minuit--;
			second = 59;
		}
		String ti = minuit + " : " + second;
		return ti;
	}

	public static String time() {
		String time;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		time = sdf.format(d);
		return time;
	}

	public MicroWave1() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(36, 42, 144, 42);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(25, 135, 72, 42);
		contentPane.add(btnNewButton);

		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 1;
			}
		});
		button.setBounds(126, 135, 72, 42);
		contentPane.add(button);

		JButton button_1 = new JButton("3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 2;
			}
		});
		button_1.setBounds(223, 135, 72, 42);
		contentPane.add(button_1);

		btnStart = new JButton("Start");
		btnStart.setBounds(25, 333, 115, 29);
		contentPane.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timebool = true;
				second = 60;
				setTimer1();

			}
		});

		JButton button_2 = new JButton("4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 3;
			}
		});
		button_2.setBounds(25, 203, 72, 42);
		contentPane.add(button_2);

		JButton button_3 = new JButton("5");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 4;
			}
		});
		button_3.setBounds(126, 203, 72, 42);
		contentPane.add(button_3);

		JButton button_4 = new JButton("6");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 5;
			}
		});
		button_4.setBounds(223, 203, 72, 42);
		contentPane.add(button_4);

		JButton button_5 = new JButton("7");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 6;
			}
		});
		button_5.setBounds(25, 261, 72, 42);
		contentPane.add(button_5);

		JButton button_6 = new JButton("8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 7;
			}
		});
		button_6.setBounds(126, 261, 72, 42);
		contentPane.add(button_6);

		JButton button_7 = new JButton("9");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 8;
			}
		});
		button_7.setBounds(223, 261, 72, 42);
		contentPane.add(button_7);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timebool = false;
				second = 1;
				minuit = 0;
			}
		});
		btnStop.setBounds(178, 333, 115, 29);
		contentPane.add(btnStop);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(15, 92, 310, 336);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnDfrost = new JButton("Dfrost");
		btnDfrost.setBounds(15, 291, 115, 29);
		panel.add(btnDfrost);

		JButton btnBeverage = new JButton("Beverage");
		btnBeverage.setBounds(166, 291, 115, 29);
		panel.add(btnBeverage);

		JLabel lblSetTimer = new JLabel("Set Timer");
		lblSetTimer.setBounds(15, 16, 69, 20);
		panel.add(lblSetTimer);
		btnBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 1;
				second = 40;
			}
		});
		btnDfrost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 19;
			}
		});

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(499, 81, 414, 42);
		contentPane.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(515, 166, 301, 182);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.GRAY);
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\RAVI\\Pictures\\download.jpg"));
		lblNewLabel_2.setBounds(0, -33, 310, 242);
		panel_1.add(lblNewLabel_2);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuit = 0;
			}
		});

	}

}
