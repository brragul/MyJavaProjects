package myProject;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UpdateUser {
	
	private JPasswordField ptextField;
	private JPasswordField ptextField_1;
	private JPasswordField ptextField_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnSubmit;
	
	JFrame frame;
	String connection1="jdbc:sqlserver://RAVI-PC;databaseName=MyBank;integratedSecurity=true;";

	public UpdateUser(){
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Update Details");
		frame.setBounds(100, 100, 640, 384);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(169, 42, 117, 16);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(169, 88, 117, 16);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth(MM/DD/YY):");
		lblDateOfBirth.setBounds(169, 132, 146, 16);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(169, 174, 56, 16);
		frame.getContentPane().add(lblSex);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(169, 209, 117, 16);
		frame.getContentPane().add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setBounds(334, 39, 189, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(334, 85, 189, 22);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(334, 129, 189, 22);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(334, 171, 189, 22);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(334, 206, 189, 22);
		frame.getContentPane().add(textField_4);
		
		btnSubmit = new JButton("Update");
		btnSubmit.setBounds(185, 263, 97, 25);
		frame.getContentPane().add(btnSubmit);
		displayInTextfield();
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection con;
				try {
					con = DriverManager.getConnection(connection1);
					Statement s =con.createStatement();
					s.executeUpdate("update userdetails set firstname='"+ textField.getText()+"',lastname = '"+textField_1.getText()+"',dob ='"+textField_2.getText()+"',sex ='"+textField_3.getText()+"',phoneno ="+textField_4.getText()+" where username ='"+UserLogin.getUser()+"'");
					JOptionPane.showMessageDialog(null, "The account details has been updated");
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(334, 263, 97, 25);
		frame.getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
			
		});
		
		JLabel lblSignUp = new JLabel("Update");
		lblSignUp.setBounds(281, 13, 56, 16);
		frame.getContentPane().add(lblSignUp);
	}
	
	private void displayInTextfield(){
		Connection con;
		try {
			con = DriverManager.getConnection(connection1);
			Statement s =con.createStatement();
			ResultSet rs= s.executeQuery("select firstname,lastname,dob,sex,phoneno from userdetails where username='"+UserLogin.getUser()+"'");
			while(rs.next()){
				String fname =rs.getString(1), lname =rs.getString(2),dob = rs.getString(3),sex=rs.getString(4);
				String phone=Integer.toString(rs.getInt(5));
				textField.setText(fname);
				textField_1.setText(lname);
				textField_2.setText(dob);
				textField_3.setText(sex);
				textField_4.setText(phone);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public UpdateUser(String pass) {
		frame = new JFrame("Update Password");
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setSize(600, 600);
		JLabel lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOldPassword.setBounds(88, 92, 174, 28);
		frame.getContentPane().add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewPassword.setBounds(88, 148, 174, 28);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblRetypeNewPassword = new JLabel("Retype New Password:");
		lblRetypeNewPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRetypeNewPassword.setBounds(88, 203, 220, 28);
		frame.getContentPane().add(lblRetypeNewPassword);
		
		ptextField = new JPasswordField();
		ptextField.setBounds(355, 97, 167, 22);
		frame.getContentPane().add(ptextField);
		ptextField.setColumns(10);
		
		ptextField_1 = new JPasswordField();
		ptextField_1.setColumns(10);
		ptextField_1.setBounds(355, 153, 167, 22);
		frame.getContentPane().add(ptextField_1);
		
		ptextField_2 = new JPasswordField();
		ptextField_2.setColumns(10);
		ptextField_2.setBounds(355, 208, 167, 22);
		frame.getContentPane().add(ptextField_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(146, 276, 97, 25);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pass.equals(ptextField.getText())){
					if(ptextField_1.getText().equals(ptextField_2.getText())){
						try {
							Connection con =DriverManager.getConnection(connection1);
							Statement s =con.createStatement();
							s.executeUpdate("update userdetails set password='"+ ptextField_1.getText()+"' where username ='"+UserLogin.getUser()+"'");
							s.executeUpdate("update userlogin set userpassword='"+ ptextField_1.getText()+"' where username ='"+UserLogin.getUser()+"'");
							JOptionPane.showMessageDialog(null, "The password has been successfully changed");
							frame.dispose();

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(null, "The entered new passwords does not match");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Your old password is wrong");
				}
			}
			
		});
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(282, 276, 97, 25);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
			
		});
		
	}
}
