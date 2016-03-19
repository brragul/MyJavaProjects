package myProject;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTable;

public class tttt {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * @wbp.parser.entryPoint
	 */
	private void OptionPage() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.getContentPane().setLayout(null);
		
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
		
		textField = new JTextField();
		textField.setBounds(355, 97, 167, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(355, 153, 167, 22);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(355, 208, 167, 22);
		frame.getContentPane().add(textField_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(146, 276, 97, 25);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(282, 276, 97, 25);
		frame.getContentPane().add(btnCancel);
		
		
	}
	private String showTime() {
		
		String time;
		Date d = new Date();
		SimpleDateFormat formt = new SimpleDateFormat("hh:mm:ss a  d MMMM yyyy E");
		time=formt.format(d);
		return(time);
		
	}
}
