package myProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpPage {
	private JFrame frmSignUp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField textField_6;
	private JPasswordField textField_7;
	private JTextField textField_8;
	private JLabel lblAccountBalance;
	private JTextField textField_9;

	public SignUpPage(){
		frmSignUp = new JFrame();
		frmSignUp.setVisible(true);
		frmSignUp.setTitle("Sign Up");
		frmSignUp.setBounds(100, 100, 642, 606);
		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignUp.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(169, 42, 117, 16);
		frmSignUp.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(169, 88, 117, 16);
		frmSignUp.getContentPane().add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth(MM/DD/YY):");
		lblDateOfBirth.setBounds(169, 132, 146, 16);
		frmSignUp.getContentPane().add(lblDateOfBirth);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(169, 174, 56, 16);
		frmSignUp.getContentPane().add(lblSex);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setBounds(169, 217, 117, 16);
		frmSignUp.getContentPane().add(lblAccountNumber);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(169, 259, 117, 16);
		frmSignUp.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(169, 296, 117, 16);
		frmSignUp.getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype Password:");
		lblRetypePassword.setBounds(169, 333, 117, 16);
		frmSignUp.getContentPane().add(lblRetypePassword);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(169, 374, 117, 16);
		frmSignUp.getContentPane().add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setBounds(334, 39, 189, 22);
		frmSignUp.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(334, 85, 189, 22);
		frmSignUp.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(334, 129, 189, 22);
		frmSignUp.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(334, 171, 189, 22);
		frmSignUp.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(334, 214, 189, 22);
		frmSignUp.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(334, 256, 189, 22);
		frmSignUp.getContentPane().add(textField_5);
		
		textField_6 = new JPasswordField();
		textField_6.setColumns(10);
		textField_6.setBounds(334, 293, 189, 22);
		frmSignUp.getContentPane().add(textField_6);
		
		textField_7 = new JPasswordField();
		textField_7.setColumns(10);
		textField_7.setBounds(334, 330, 189, 22);
		frmSignUp.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(334, 371, 189, 22);
		frmSignUp.getContentPane().add(textField_8);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(189, 487, 97, 25);
		frmSignUp.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveUser();
			}
		});
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(336, 487, 97, 25);
		frmSignUp.getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frmSignUp.dispose();
			}
		});
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setBounds(281, 13, 56, 16);
		frmSignUp.getContentPane().add(lblSignUp);
		
		lblAccountBalance = new JLabel("Account Balance:");
		lblAccountBalance.setBounds(169, 415, 117, 16);
		frmSignUp.getContentPane().add(lblAccountBalance);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(334, 412, 189, 22);
		frmSignUp.getContentPane().add(textField_9);
	}
	private void saveUser() {
		String connection1="jdbc:sqlserver://RAVI-PC;databaseName=MyBank;integratedSecurity=true;";
		try {
			Connection con=DriverManager.getConnection(connection1);
			Statement s =con.createStatement();
			if(textField_6.getText().equals(textField_7.getText()))
			{
			s.executeUpdate("insert into userdetails values('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"',"+textField_4.getText()+",'"+textField_5.getText()+"','"+textField_6.getText()+"',"+textField_8.getText()+","+textField_9.getText()+")");
			s.executeUpdate("insert into userlogin values('"+textField_5.getText()+"','"+textField_6.getText()+"')");
			JOptionPane.showMessageDialog(null, "Registered Successfully");
			new UserLogin();
			}
			else{
				JOptionPane.showMessageDialog(null, "The password does not match");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
