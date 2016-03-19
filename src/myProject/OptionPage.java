package myProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class OptionPage{
	private JFrame frame;
	public static boolean dwnbool = false;
	
	public  OptionPage() {
		System.out.println("Option Page Called");
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 648, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.BLUE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 0, 568, 421);
		frame.getContentPane().add(tabbedPane);

		tabbedPane.add("Account Detail", accntSumm());
		tabbedPane.add("Start Transaction", startTran() );
		tabbedPane.add("Transaction Summary", tranSumm());
		tabbedPane.add("Contact Support", querySumm());
		//tabbedPane.setLayout(null);
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(478, 437, 113, 25);
		frame.getContentPane().add(btnLogout);
		
		btnLogout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
					
					new UserLogin();
					frame.dispose();
			}
			
		});
		
		
	}
	
	private JPanel accntSumm(){
		JPanel asum = new JPanel();
		asum.setLayout(null);
		String fname="",lname="",dob="",sex="",accno="",uname="",phone="";
		Statement s;
		String connection1="jdbc:sqlserver://RAVI-PC;databaseName=MyBank;integratedSecurity=true;";
		try {
			Connection con=DriverManager.getConnection(connection1);
			 s =con.createStatement();
			ResultSet r = s.executeQuery("select firstname,lastname,dob,sex,accountno,username,phoneno from userdetails where username='"+UserLogin.getUser()+"'");
			while(r.next()){
				
				 fname="First Name: "+r.getString(1);
				 lname="Last Name:  "+r.getString(2);
				 dob="DOB:      "+r.getString(3);
				 sex="Gender:     "+r.getString(4);
				 accno="Account No: "+r.getBigDecimal(5).toString();
				 uname="User Name:  "+r.getString(6);
				 phone="Phone No:   "+r.getBigDecimal(7).toString();
				
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		JLabel lblFirstName = new JLabel(fname);
		lblFirstName.setBounds(73, 55, 407, 16);
		
		JLabel lblLastName = new JLabel(lname);
		lblLastName.setBounds(73, 93, 407, 16);
		
		JLabel lblDob = new JLabel(dob);
		lblDob.setBounds(73, 129, 407, 16);
		
		JLabel lblAccountNo = new JLabel(accno);
		lblAccountNo.setBounds(73, 158, 407, 16);
		
		JLabel lblUserName = new JLabel(uname);
		lblUserName.setBounds(73, 193, 407, 16);
		
		JLabel lblPhoneNo = new JLabel(phone);
		lblPhoneNo.setBounds(73, 228, 407, 16);
		
		JLabel lblGender = new JLabel(sex);
		lblGender.setBounds(73, 257, 407, 16);
		
		JButton btnUpdateUserDetails = new JButton("Update User Details");
		btnUpdateUserDetails.setBounds(396, 339, 164, 25);
		asum.add(btnUpdateUserDetails);
		
		btnUpdateUserDetails.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new UpdateUser();
			}
			
		});
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(224, 339, 140, 25);
		asum.add(btnChangePassword);
		
		btnChangePassword.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection con =DriverManager.getConnection(connection1);
					Statement s =con.createStatement();
					ResultSet r1= s.executeQuery("select rtrim(password) from userdetails where username ='"+UserLogin.getUser()+"'");
					while(r1.next()){
						String pass = r1.getString(1);
						new UpdateUser(pass);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		asum.add(lblFirstName);
		asum.add(lblLastName);
		asum.add(lblDob);
		asum.add(lblAccountNo);
		asum.add(lblUserName);
		asum.add(lblPhoneNo);
		asum.add(lblGender);
		
		return asum;
		
	}
	public JPanel startTran(){
		JPanel str = new JPanel();
		Transaction t = new Transaction();
		str =t.tranc();
		return str;
	}
	
	public JPanel tranSumm(){
		JPanel tsum = new JPanel();
		tsum.setLayout(null);
		JButton btnShowTransactionSummary = new JButton("Show Transaction Summary");
		btnShowTransactionSummary.setBounds(167, 101, 233, 25);
		btnShowTransactionSummary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new ShowSummary();
			}
		});
		JButton btndwnldsum = new JButton("Download Transaction Summary");
		btndwnldsum.setBounds(167, 158, 233, 25);
		btndwnldsum.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dwnbool=true;
				new ShowSummary();
			}
		});
		
		
		
		tsum.add(btnShowTransactionSummary);
		tsum.add(btndwnldsum);
		return tsum;
	}
	public JPanel querySumm(){
		JPanel qp = new JPanel();
		JTextPane textPane = new JTextPane();
		textPane.setBounds(83, 94, 397, 157);
		qp.setLayout(null);
		
		JLabel lblSubmitQuery = new JLabel("Submit Query");
		lblSubmitQuery.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubmitQuery.setBounds(83, 56, 152, 25);
		qp.add(lblSubmitQuery);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(374, 52, 97, 25);
		qp.add(btnSubmit);
		qp.add(textPane);
		
		
		btnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String user = UserLogin.getUser();
				String query = textPane.getText();
				String connectionurl="jdbc:sqlserver://Ravi-PC;databaseName=MyBank;integratedSecurity=true;";
				try {
					Connection c = DriverManager.getConnection(connectionurl);
					Statement s =c.createStatement();
					s.executeUpdate("insert into userquery values('"+user+"','"+query+"')");
					JOptionPane.showMessageDialog(null,"Your query has been raised");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		return qp;
	}
	
}
