package midtermExam;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class MainClass {
	static int curfl1=1;
	static int curfl2=1;
	static int curfl3=1;
	static boolean mov1=false;
	static boolean mov2=false;
	static boolean mov3=false;
	int[] co1 = new int[4];
	int[] co2 = new int[4];
	int[] co3 = new int[4];
	private JFrame frame;
	JLabel lblCF3;
	JLabel lblCF2;
	JLabel lblCF1;
	JLabel mvlbl5;
	JLabel mvlbl4;
	JLabel mvlbl3;
	JLabel mvlbl2;
	JLabel mvlbl1;
	
	JToggleButton btnUp1;
	JButton btnMove1;
	JButton btnMove2;
	JButton btnMove3;
	
	JPanel lift1;
	JPanel lift2;
	JPanel lift3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass window = new MainClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainClass() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setTitle("My Lift");
		frame.setBounds(100, 100, 823, 714);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 642, 641);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lift1 = new JPanel();
		lift1.setBackground(Color.RED);
		co1=GetEleCoord.getCoordinate(1,1);
		lift1.setBounds(co1[0], co1[1], co1[2], co1[3]);
		panel.add(lift1);
		lift1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(53, 40, 41, 22);
		lift1.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setMaximumRowCount(5);
		
		btnMove1 = new JButton("Move");
		btnMove1.setBounds(31, 75, 97, 25);
		lift1.add(btnMove1);
		btnMove1.disable();
		
		lblCF1 = new JLabel("Current Floor:");
		lblCF1.setBounds(22, 13, 156, 16);
		lift1.add(lblCF1);
		btnMove1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lift1.setBackground(Color.GREEN);
				String s =(String) comboBox.getSelectedItem();
				switch(s){
				case "1":
					curfl1=1;
					moveLift(1,1);
					break;
				case "2":
					curfl1=2;
					moveLift(2,1);
					break;
				case "3":
					curfl1=3;
					moveLift(3,1);
					break;
				case "4":
					curfl1=4;
					moveLift(4,1);
					break;
				case "5":
					curfl1=5;
					moveLift(5,1);
					break;
				}
			}
			
		});
		
		lift2 = new JPanel();
		lift2.setBackground(Color.RED);
		co2=GetEleCoord.getCoordinate(2,1);
		lift2.setBounds(co2[0], co2[1], co2[2], co2[3]);
		panel.add(lift2);
		lift2.setLayout(null);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_5.setMaximumRowCount(5);
		comboBox_5.setBounds(71, 40, 41, 22);
		lift2.add(comboBox_5);
		
		btnMove2 = new JButton("Move");
		btnMove2.setBounds(41, 75, 97, 25);
		lift2.add(btnMove2);
		btnMove2.disable();
		
		lblCF2 = new JLabel("Current Floor:");
		lblCF2.setBounds(12, 13, 156, 16);
		lift2.add(lblCF2);
		btnMove2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lift2.setBackground(Color.GREEN);
				String s =(String) comboBox_5.getSelectedItem();
				switch(s){
				case "1":
					curfl2=1;
					moveLift(1,2);
					break;
				case "2":
					curfl2=2;
					moveLift(2,2);
					break;
				case "3":
					curfl2=3;
					moveLift(3,2);
					break;
				case "4":
					curfl2=4;
					moveLift(4,2);
					break;
				case "5":
					curfl2=5;
					moveLift(5,2);
					break;
				}
			}
		});
		
		lift3 = new JPanel();
		lift3.setBackground(Color.RED);
		co3=GetEleCoord.getCoordinate(3,1);
		lift3.setBounds(co3[0], co3[1], co3[2], co3[3]);
		panel.add(lift3);
		lift3.setLayout(null);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_6.setMaximumRowCount(5);
		comboBox_6.setBounds(76, 40, 41, 22);
		lift3.add(comboBox_6);
		
		btnMove3 = new JButton("Move");
		btnMove3.setBounds(49, 75, 97, 25);
		lift3.add(btnMove3);
		btnMove3.disable();
		
		lblCF3 = new JLabel("Current Floor:");
		lblCF3.setBounds(12, 13, 156, 16);
		lift3.add(lblCF3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RAVI\\Desktop\\Untitled1.png"));
		lblNewLabel.setBounds(0, 0, 642, 641);
		panel.add(lblNewLabel);
		btnMove3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lift3.setBackground(Color.GREEN);
				String s =(String) comboBox_6.getSelectedItem();
				switch(s){
				case "1":
					curfl3=1;
					moveLift(1,3);
					break;
				case "2":
					curfl3=2;
					moveLift(2,3);
					break;
				case "3":
					curfl3=3;
					moveLift(3,3);
					break;
				case "4":
					curfl3=4;
					moveLift(4,3);
					break;
				case "5":
					curfl3=5;
					moveLift(5,3);
					break;
				}
				
				
			}
			
		});
		
		JLabel lblFloor = new JLabel("Floor 5");
		lblFloor.setBounds(679, 33, 56, 16);
		frame.getContentPane().add(lblFloor);
		
		JToggleButton btnDown5 = new JToggleButton("Down");
		btnDown5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDown5.setBounds(666, 65, 73, 25);
		frame.getContentPane().add(btnDown5);
		btnDown5.setBackground(Color.GRAY);
		btnDown5.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mvlbl5.setIcon(new ImageIcon("C:\\Users\\RAVI\\Desktop\\down.png"));
				btnDown5.setBackground(Color.YELLOW);
				int l=findNearLift(5);
				if(l==1){
					curfl1=5;
				}else if(l==2){
					curfl2=5;
				}else if(l==3){
					curfl3=5;
				}
				moveLift(5,l);
			}
			
		});
		
		JLabel lblFloor_1 = new JLabel("Floor 4");
		lblFloor_1.setBounds(679, 133, 56, 16);
		frame.getContentPane().add(lblFloor_1);
		
		JToggleButton btnUp4 = new JToggleButton("UP");
		btnUp4.setBounds(667, 163, 73, 25);
		btnUp4.setBackground(Color.GRAY);
		frame.getContentPane().add(btnUp4);
		btnUp4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mvlbl4.setIcon(new ImageIcon("C:\\Users\\RAVI\\Desktop\\up.png"));
				btnUp4.setBackground(Color.YELLOW);
				int l=findNearLift(4);
				if(l==1){
					curfl1=4;
				}else if(l==2){
					curfl2=4;
				}else if(l==3){
					curfl3=4;
				}
				moveLift(4,l);
			}
			
		});
		
		JToggleButton btnDown4 = new JToggleButton("Down");
		btnDown4.setBounds(666, 201, 73, 25);
		btnDown4.setBackground(Color.GRAY);
		frame.getContentPane().add(btnDown4);
		btnDown4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mvlbl4.setIcon(new ImageIcon("C:\\Users\\RAVI\\Desktop\\down.png"));
				btnDown4.setBackground(Color.YELLOW);
				int l=findNearLift(4);
				if(l==1){
					curfl1=4;
				}else if(l==2){
					curfl2=4;
				}else if(l==3){
					curfl3=4;
				}
				moveLift(4,l);
			}
			
		});
		
		JLabel lblFloor_2 = new JLabel("Floor 3");
		lblFloor_2.setBounds(679, 261, 56, 16);
		frame.getContentPane().add(lblFloor_2);
		
		JToggleButton btnUp3 = new JToggleButton("UP");
		btnUp3.setBounds(667, 291, 73, 25);
		btnUp3.setBackground(Color.gray);
		frame.getContentPane().add(btnUp3);
		btnUp3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mvlbl3.setIcon(new ImageIcon("C:\\Users\\RAVI\\Desktop\\up.png"));
				btnUp3.setBackground(Color.YELLOW);
				int l=findNearLift(3);
				if(l==1){
					curfl1=3;
				}else if(l==2){
					curfl2=3;
				}else if(l==3){
					curfl3=3;
				}
				moveLift(3,l);
			}
			
		});
		
		JToggleButton btnDown3 = new JToggleButton("Down");
		btnDown3.setBounds(666, 329, 73, 25);
		btnDown3.setBackground(Color.GRAY);
		frame.getContentPane().add(btnDown3);
		btnDown3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mvlbl3.setIcon(new ImageIcon("C:\\Users\\RAVI\\Desktop\\down.png"));
				btnDown3.setBackground(Color.YELLOW);
				int l=findNearLift(3);
				if(l==1){
					curfl1=3;
				}else if(l==2){
					curfl2=3;
				}else if(l==3){
					curfl3=3;
				}
				moveLift(3,l);
			}
			
		});
		
		JLabel lblFloor_3 = new JLabel("Floor 2");
		lblFloor_3.setBounds(679, 399, 56, 16);
		frame.getContentPane().add(lblFloor_3);
		
		JToggleButton btnUp2 = new JToggleButton("UP");
		btnUp2.setBounds(667, 429, 73, 25);
		btnUp2.setBackground(Color.gray);
		frame.getContentPane().add(btnUp2);
		btnUp2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mvlbl2.setIcon(new ImageIcon("C:\\Users\\RAVI\\Desktop\\up.png"));
				btnUp2.setBackground(Color.YELLOW);
				int l=findNearLift(2);
				if(l==1){
					curfl1=2;
				}else if(l==2){
					curfl2=2;
				}else if(l==3){
					curfl3=2;
				}
				moveLift(2,l);
			}
			
		});
		
		JToggleButton btnDown2 = new JToggleButton("Down");
		btnDown2.setBounds(666, 467, 73, 25);
		btnDown2.setBackground(Color.GRAY);
		frame.getContentPane().add(btnDown2);
		btnDown2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mvlbl2.setIcon(new ImageIcon("C:\\Users\\RAVI\\Desktop\\down.png"));
				btnDown2.setBackground(Color.YELLOW);
				int l=findNearLift(2);
				if(l==1){
					curfl1=2;
				}else if(l==2){
					curfl2=2;
				}else if(l==3){
					curfl3=2;
				}
				moveLift(2,l);
			}
			
		});
		JLabel label_3 = new JLabel("Floor 1");
		label_3.setBounds(679, 544, 56, 16);
		frame.getContentPane().add(label_3);
		
		btnUp1 = new JToggleButton("Up");
		btnUp1.setBounds(666, 573, 73, 25);
		btnUp1.setBackground(Color.gray);
		frame.getContentPane().add(btnUp1);
		
		mvlbl5 = new JLabel("");
		mvlbl5.setBounds(747, 43, 46, 49);
		frame.getContentPane().add(mvlbl5);
		
		 mvlbl4 = new JLabel("");
		mvlbl4.setBounds(747, 167, 46, 49);
		frame.getContentPane().add(mvlbl4);
		
		 mvlbl3 = new JLabel("");
		mvlbl3.setBounds(747, 295, 46, 49);
		frame.getContentPane().add(mvlbl3);
		
		 mvlbl2 = new JLabel("");
		mvlbl2.setBounds(747, 433, 46, 49);
		frame.getContentPane().add(mvlbl2);
		
		 mvlbl1 = new JLabel("");
		mvlbl1.setBounds(747, 554, 46, 49);
		frame.getContentPane().add(mvlbl1);
		btnUp1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mvlbl1.setIcon(new ImageIcon("C:\\Users\\RAVI\\Desktop\\up.png"));
				btnUp1.setBackground(Color.yellow);
				int l=findNearLift(1);
				if(l==1){
					curfl1=1;
				}else if(l==2){
					curfl2=1;
				}else if(l==3){
					curfl3=1;
				}
				
				moveLift(1,l);
			}
			
		});
	}
	
	public void graphLift(int l, int curfl, int recfl){
		int pos = Math.abs(curfl-recfl);
				for(int i=curfl;i<=pos+1;i++)
				{
					if(l==1){
						curfl1=i;
					}else if(l==2){
						curfl2=i;
					}else if(l==3){
						curfl3=i;
					}
					Timer timer = new Timer(1000, new TimeActionListener());
					timer.start();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					moveLift(i,l);
					timer.stop();
					//sleepFor1Sec();
					
				}
	}
	
	private void sleepFor1Sec() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	protected void moveLift(int i, int l) {
		if(l==1){
			lblCF1.setText("Current Floor "+curfl1);
			co1=GetEleCoord.getCoordinate(1, i);
			lift1.setBounds(co1[0], co1[1], co1[2], co1[3]);
		}else if(l==2){
			lblCF2.setText("Current Floor "+curfl2);
			co2=GetEleCoord.getCoordinate(2, i);
			lift2.setBounds(co2[0], co2[1], co2[2], co2[3]);
		}else if(l==3){
			lblCF3.setText("Current Floor "+curfl3);
			co3=GetEleCoord.getCoordinate(3, i);
			lift3.setBounds(co3[0], co3[1], co3[2], co3[3]);
		}
	}


	public int findNearLift(int l){
		int x1=0,x2=0,x3=0;
		int near=0;
		x1=l-curfl1;
		x2=l-curfl2;
		x3=l-curfl3;
		System.out.println("Distance l1 "+x1+" l2 "+x2+" l3 "+x3);
		x1=Math.abs(x1);
		x2=Math.abs(x2);
		x3=Math.abs(x3);
		if(x1<=x2 && x1<=x3){
			near=1;
			btnMove1.enable();
		}else if(x2<=x3){
			near=2;
			btnMove2.enable();
		}else{
			near =3;
			btnMove3.enable();
		}
		System.out.println("Distance l1 "+x1+" l2 "+x2+" l3 "+x3+" nearst "+ near);
		return near;
	}
}
class TimeActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
