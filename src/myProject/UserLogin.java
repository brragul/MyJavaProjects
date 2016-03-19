package myProject;

import java.awt.Color;
import java.awt.EventQueue;
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

public class UserLogin {

	private static JFrame frame;
	private JTextField userTxt;
	private JPasswordField passTxt;
	private JButton btnLogin;
	public static String user="",pass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin window = new UserLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserLogin() {
		initialize();
	}


	public void initialize() {
		System.out.println("Frame Created");
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 105, 30));
		frame.setVisible(true);
		frame.setBounds(100, 100, 530, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBackground(Color.BLUE);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserName.setBounds(144, 104, 93, 33);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(144, 150, 93, 33);
		frame.getContentPane().add(lblPassword);
		
		userTxt = new JTextField();
		userTxt.setBounds(260, 110, 116, 22);
		frame.getContentPane().add(userTxt);
		userTxt.setColumns(10);
		
		passTxt = new JPasswordField();
		passTxt.setColumns(10);
		passTxt.setBounds(260, 156, 116, 22);
		frame.getContentPane().add(passTxt);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(156, 211, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(279, 211, 97, 25);
		frame.getContentPane().add(btnCancel);
		
		JButton btnNewUserSign = new JButton("New User? Sign Up");
		btnNewUserSign.setBounds(205, 273, 156, 33);
		frame.getContentPane().add(btnNewUserSign);
		
		JLabel lblRavisTrustedBank = new JLabel("Ravi's Trusted Bank");
		lblRavisTrustedBank.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblRavisTrustedBank.setBounds(156, 58, 220, 33);
		frame.getContentPane().add(lblRavisTrustedBank);
		
		
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
			
		});
		btnNewUserSign.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
					new SignUpPage();
			}
			
		});
		
			checkLoginDetails();
		
	}
	public void checkLoginDetails(){
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setUser(userTxt.getText());
				pass=passTxt.getText();
				
				String connectionUrl = "jdbc:sqlserver://RAVI-PC;databaseName=MyBank;integratedSecurity=true;";
				Connection con;
				try {
					con = DriverManager.getConnection(connectionUrl);
					Statement s = con.createStatement();
					ResultSet r = s.executeQuery("SELECT username,rtrim(userpassword) FROM userlogin where username='"+user+"'");
					while (r.next()) {
						String s1=r.getString(2);
					    if(s1.equals(pass)){
					    	System.out.println("login Success");
					    	frame.dispose();
					    	new OptionPage();
					    	
					    }else{
					    	JOptionPane.showMessageDialog(null, "The user name or password is not correct");
					    }
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
	}
	public void setUser(String user){
		this.user=user;
	}
	public static String getUser(){
		return user;
	}
}
