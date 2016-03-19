package sortImplementation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplaySort extends JFrame {
	static JFrame frame = new JFrame("Sorting");
	static JFrame bframe = new JFrame("Bubble Sorting");
	static JFrame sframe = new JFrame("Selection Sorting");
	static JFrame iframe = new JFrame("Insertion Sorting");
	static InsertionDraw draw = new InsertionDraw();
	static SelectionDraw secdraw = new SelectionDraw();
	static BubbleDraw bubdraw =new BubbleDraw();
	static String[] ii = null;
	static int[]iii;
	static JPanel panel1 =new JPanel();
	static int temp=0;
	static int sorting=0;
	static int graphic=0;
	public static void main(String[] args) {
		JLabel label = new JLabel("Elements to sort");
		JLabel label1 = new JLabel("1->Rectangle  2->Triangle  3->Cylinder");
		JTextField t_sort = new JTextField(15);
		JTextField gtxt = new JTextField(5);
		JButton button = new JButton("Create Array");
		JButton gbutton = new JButton("Select Graphics");
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel1.setLayout(new FlowLayout());
		panel1.add(label1);
		panel1.add(gtxt);
		panel1.add(gbutton);
		panel1.add(label);
		panel1.add(t_sort);
		panel1.add(button);
		frame.add(panel1, BorderLayout.NORTH);
		
		gbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s= gtxt.getText();
				graphic=Integer.parseInt(s);
			}
			
		});
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s=t_sort.getText();
				ii=s.split(" ");
				iii = new int[ii.length];
				for(int k=0;k<iii.length;k++){
					iii[k]=Integer.parseInt(ii[k]);
				}
				for(int k=0;k<iii.length;k++){
					System.out.println("Entered value"+iii[k]);
				}
				
				
				new Thread(new Runnable(){
					public void run(){
						//Insertion Sort
						iframe.setVisible(true);
						iframe.setSize(600,600);
						iframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
						iframe.add(draw);
						for (int c=0;c<iii.length;c++)
						{
							for(int b=c;b>0;b--)
							{
								if(iii[b]<iii[b-1])
								{
									temp=iii[b];
									iii[b]=iii[b-1];
									iii[b-1]=temp;
									try{
										Thread.sleep(1500);
									}catch(InterruptedException e1){
										
									}
									draw.drawRect();					
								}
								
							}
							
							
							
						}
					}
				}).start();
				new Thread(new Runnable(){
					public void run(){
						//Selection Sort
						sframe.setVisible(true);
						sframe.setSize(600,600);
						sframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
						sframe.add(secdraw);
						int min=-1,ks;
						for(int j=0;j<iii.length-1;j++){
							min=j;
							for( ks=j+1;ks<iii.length;ks++)
							{
								if(iii[j]>iii[ks])
								{
									min=ks;
									
								}
							}
							if(j!=min){
							temp=iii[j];
							iii[j]=iii[min];
							iii[min]=temp;}
							try{
								Thread.sleep(1500);
							}catch(InterruptedException e1){
								
							}
							secdraw.drawRect();
							
						}
					}
					}).start();
				new Thread(new Runnable(){
					public void run(){
						//Bubble Sort
						bframe.setVisible(true);
						bframe.setSize(600,600);
						bframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
						bframe.add(bubdraw);
						for (int j=0;j<iii.length;j++)
						{
							for(int k=1;k<iii.length;k++)
							{

								if(iii[k]<iii[k-1])
								{
									temp=iii[k-1];
									iii[k-1]=iii[k];
									iii[k]=temp;
									try{
										Thread.sleep(1500);
									}catch(InterruptedException e1){
										
									}
									bubdraw.drawRect();
								}
							}
						}
					}}).start();
			}
		});
	}
}
