package myProject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ooptionpgtttt {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_8;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ooptionpgtttt window = new ooptionpgtttt();
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
	public ooptionpgtttt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Update Details");
		frame.setBounds(100, 100, 640, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(334, 206, 189, 22);
		frame.getContentPane().add(textField_8);
		
		btnSubmit = new JButton("Update");
		btnSubmit.setBounds(185, 263, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					saveUser();
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
	private void saveUser() throws SQLException {
		
	}
}
