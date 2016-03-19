package calculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	
	String t="";
	int countx=0,countac=0;
	double result=0.0;
	static JButton button1;
	static JButton button2;
	static JButton button3;
	static JButton button4;
	static JButton button5;
	static JButton button6;
	static JButton button7;
	static JButton button8;
	static JButton button9;
	static JButton button0;
	static JButton buttondot;
	static JButton buttonequal;
	static JButton buttonadd;
	static JButton buttonsub;
	static JButton buttonmul;
	static JButton buttondiv;
	static JButton buttonclear;
	static JTextField txt;
	
public static void main(String[] args){
	JFrame frame = new JFrame("My Calculator");
	txt = new JTextField(10);
	txt.setBounds(31, 37, 375, 26);
	button1 = new JButton("1");
	button2 = new JButton("2");
	button3 = new JButton("3");
	button4 = new JButton("4");
	button5 = new JButton("5");
	button6 = new JButton("6");
	button7 = new JButton("7");
	button8 = new JButton("8");
	button9 = new JButton("9");
	button0 = new JButton("0");
	buttonclear = new JButton("C");
	buttonequal = new JButton("=");
	buttondot = new JButton(".");
	buttonadd = new JButton("+");
	buttonsub = new JButton("-");
	buttonmul = new JButton("x");
	buttondiv = new JButton("/");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	frame.setVisible(true);
	//frame.setSize(600, 500);
	frame.setBounds(100, 100, 699, 583);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel1.setLayout(new GridLayout(4,3,5,5));
	panel2.setLayout(new GridLayout(4,1,10,5));
	panel3.setLayout(new GridLayout(4,1,10,5));
	panel1.add(button9);
	panel1.add(button8);
	panel1.add(button7);
	panel1.add(button6);
	panel1.add(button5);
	panel1.add(button4);
	panel1.add(button3);
	panel1.add(button2);
	panel1.add(button1);
	panel1.add(button0);
	panel1.add(buttonequal);
	panel1.add(buttondot);
	panel2.add(buttonadd);
	panel2.add(buttonsub);
	panel2.add(buttonmul);
	panel2.add(buttondiv);
	panel3.add(buttonclear);
	frame.add(txt,BorderLayout.NORTH);
	frame.add(panel1,BorderLayout.CENTER);
	frame.add(panel2,BorderLayout.EAST);
	frame.add(panel3,BorderLayout.WEST);
	Calculator c = new Calculator();
	
	
	
}
public  Calculator(){
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	button4.addActionListener(this);
	button5.addActionListener(this);
	button6.addActionListener(this);
	button7.addActionListener(this);
	button8.addActionListener(this);
	button9.addActionListener(this);
	button0.addActionListener(this);
	buttonequal.addActionListener(this);
	buttondot.addActionListener(this);
	buttonadd.addActionListener(this);
	buttonsub.addActionListener(this);
	buttonmul.addActionListener(this);
	buttondiv.addActionListener(this);
	buttonclear.addActionListener(this);
	

}

@Override
public void actionPerformed(ActionEvent e) {

	String s=e.getActionCommand();
	switch(s){
	case "1":
		t=t+"1";
		countx++;
		txt.setText(t);
		break;
	case "2":
		t=t+"2";
		countx++;
		txt.setText(t);
		break;
	case "3":
		t=t+"3";
		countx++;
		txt.setText(t);
		break;
	case "4":
		t=t+"4";
		countx++;
		txt.setText(t);
		break;
	case "5":
		t=t+"5";
		countx++;
		txt.setText(t);
		break;
	case "6":
		t=t+"6";
		countx++;
		txt.setText(t);
		break;
	case "7":
		t=t+"7";
		countx++;
		txt.setText(t);
		break;
	case "8":
		t=t+"8";
		countx++;
		txt.setText(t);
		break;
	case "9":
		t=t+"9";
		countx++;
		txt.setText(t);
		break;
	case "0":
		t=t+"0";
		countx++;
		txt.setText(t);
		break;
	case "=":
		try{
		String x,y,fn;
		x=t.substring(0, countac-1);
		y=t.substring(countac, countx);
		double dx=Double.parseDouble(x);
		double dy=Double.parseDouble(y);
		fn=t.substring(countac-1, countac);
		switch(fn){
		case "+":
			result=dx+dy;
			break;
		case "-":
			result=dx-dy;
			break;
		case "x":
			result=dx*dy;
			break;
		case "/":
			result=dx/dy;
			break;
		}
		t=String.valueOf(result);
		txt.setText(t);
		countx=t.length();}
		catch(NumberFormatException n){
			txt.setText("Invalid input");
			t="";
			countx=0;
			countac=0;
		}
		break;
	case ".":
		t=t+".";
		txt.setText(t);
		countx++;
		break;
	case "+":
		t=t+"+";
		countx++;
		txt.setText(t);
		countac=countx;
		break;
	case "-":
		t=t+"-";
		countx++;
		txt.setText(t);
		countac=countx;
		break;
	case "x":
		t=t+"x";
		countx++;
		txt.setText(t);
		countac=countx;
		break;
	case "/":
		t=t+"/";
		countx++;
		txt.setText(t);
		countac=countx;
		break;
	case "C":
		t="";
		countx=0;
		countac=0;
		txt.setText(t);
		break;
	}
}
}
