package sortImplementation;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Test2 extends JComponent{

	public static void main(String[] args) {
		JFrame sframe = new JFrame();
		sframe.setVisible(true);
		sframe.setSize(600,600);
		sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		TestDraw td = new TestDraw();
		sframe.add(td);
		td.draw();
	}
	
}
