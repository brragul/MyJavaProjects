package myProject;

import javax.swing.JFrame;
import java.sql.*;

public class Main {
public static void main(String[] args){
	new Main();
	}
public Main(){
	JFrame frame =new JFrame();
	frame.setTitle("My Frame");
	frame.setVisible(true);
	frame.setSize(300, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	while(true){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Print");
	}
}
}
