package myProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Transaction {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField textField_2;
	JLabel lblCurrentBalance;
	
	static int frmacc=0,toacc=0,amttran=0,totbalfrom=0,totbalto=0;
	String dt="";
	
	public JPanel tranc(){
		JPanel p= new JPanel();
		p.setLayout(null);
		JLabel lblTransferToAccount = new JLabel("Transfer to Account:");
		lblTransferToAccount.setBounds(96, 135, 132, 16);
		p.add(lblTransferToAccount);
		
		textField = new JTextField();
		textField.setBounds(226, 132, 165, 22);
		p.add(textField);
		textField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(96, 175, 56, 16);
		p.add(lblAmount);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(226, 172, 165, 22);
		p.add(textField_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(96, 217, 118, 16);
		p.add(lblPassword);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(226, 214, 165, 22);
		p.add(textField_2);
		textField_2.setColumns(10);
		
		 lblCurrentBalance = new JLabel();
		 lblCurrentBalance.setBounds(96, 75, 195, 16);
		p.add(lblCurrentBalance);
		
		displayTotal();
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(111, 272, 97, 25);
		p.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String con="jdbc:sqlserver://RAVI-PC;databaseName=MyBank;integratedSecurity=true;";
				amttran=Integer.parseInt(textField_1.getText());
				try {
					Connection c=DriverManager.getConnection(con);
					Statement s = c.createStatement();
					int amt=Integer.parseInt(textField_1.getText());
					ResultSet r= s.executeQuery("select rtrim(password),accountno,acc_bal from userdetails where username='"+UserLogin.getUser()+"'");
					while(r.next()){
						int acc1 = r.getInt(3)-amt;
						totbalfrom=acc1;
						frmacc=r.getInt(2);
						if(r.getString(1).equals(textField_2.getText())){
							s.executeUpdate("update userdetails set acc_bal="+acc1+"where username='"+UserLogin.getUser()+"'");
							System.out.println("Transaction processed");
							displayTotal();
						}
					}
					
				} catch (SQLException e) {
					//e.printStackTrace();
				}
				try{
				Connection c2=DriverManager.getConnection(con);
				Statement s2 = c2.createStatement();
				int amt=Integer.parseInt(textField_1.getText());
				ResultSet r2=s2.executeQuery("select acc_bal from userdetails where accountno="+textField.getText());
				while(r2.next()){
					toacc=Integer.parseInt(textField.getText());
					int acc2=r2.getInt(1)+amt;
					totbalto=acc2;
					s2.executeUpdate("update userdetails set acc_bal="+acc2+"where accountno="+textField.getText());
					JOptionPane.showMessageDialog(null, "Transaction is Successfull");
				}
				}catch(SQLException e){
					//e.printStackTrace();
				}
				saveTransaction();
			}
		});
		
		
		return p;
	}
	public void displayTotal(){
		String con="jdbc:sqlserver://RAVI-PC;databaseName=MyBank;integratedSecurity=true;";
		try {
			Connection c1=DriverManager.getConnection(con);
			Statement s1 = c1.createStatement();
			ResultSet r1=s1.executeQuery("select acc_bal from userdetails where username='"+UserLogin.getUser()+"'");
			while(r1.next()){
				lblCurrentBalance.setText("Current Balance: $"+r1.getString(1));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	public JPanel trancSumm(){
		return null;
	}
	public void saveTransaction(){
		String con="jdbc:sqlserver://RAVI-PC;databaseName=MyBank;integratedSecurity=true;";
		try {
			Connection c3=DriverManager.getConnection(con);
			Statement s3 = c3.createStatement();
			s3.executeUpdate("insert into trandetail values("+frmacc+","+toacc+","+amttran+","+totbalfrom+","+totbalto+",'"+getDate()+"')");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public String getDate(){
		String time;
		Date d = new Date();
		SimpleDateFormat formt = new SimpleDateFormat("hh:mm:ss a  d MMMM yyyy E");
		time=formt.format(d);
		return(time);
	}
}
