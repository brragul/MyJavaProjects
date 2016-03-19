import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


public class test extends JFrame implements ActionListener{
	
public static void main(String[] args){
	JFrame frame = new test();
	frame.setVisible(true);
	frame.setSize(300, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.requestFocus();
	
}
public test(){
	this.setFocusable(true);
	addKeyListener(new Al());
	}

public class Al extends KeyAdapter{
public void keyPressed(KeyEvent e){
	System.out.println("Key Pressed event called");
	int keycode = e.getKeyCode();
	
	if(keycode == KeyEvent.VK_W){
		System.out.println("Up Pressed");
	}else if(keycode == KeyEvent.VK_S){
		System.out.println("Down Pressed");
	}else if(keycode == KeyEvent.VK_D){
		System.out.println("Right Pressed");
	}else if(keycode == KeyEvent.VK_A){
		System.out.println("Left Pressed");
	}
}
public void keyReleased(KeyEvent e){
	
}
public void keyTyped(KeyEvent e){
	
}
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
