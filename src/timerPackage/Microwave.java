package timerPackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Microwave extends JFrame {
	static JFrame frame = new JFrame("Microwave");
	static JLabel timelabel = new JLabel();
	static JButton microwavebutton = new JButton("Micro Wave");
	public static void main(String[] args) {
		
		
		
		frame.setVisible(true);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		
		frame.add(timelabel);
		frame.add(microwavebutton);
		
		try{
		while(true){
			//System.out.printlnime());
			timelabel.setText(time());
			microwavebutton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					setTimer(5);
				}

				
			});
			Thread.sleep(1000);
		}}catch(InterruptedException e){
			System.out.println("Thread exception raised. Please check code");
		}
	}
public static String time()
{
	String time;
	Date d =new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
	time=sdf.format(d);
	return time;
}
public static void setTimer(int i) {
	Timer timer = new Timer(1000, new TimerActionListener1());
	timer.start();
	try{
		Thread.sleep(i*1000);
	}catch(InterruptedException e)
	{
		
	}
	timer.stop();
}
}
class TimerActionListener1 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
