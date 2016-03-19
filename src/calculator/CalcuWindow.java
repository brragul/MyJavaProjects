package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class CalcuWindow implements ActionListener{
	String t="";
	int countx=0,countac=0;
	double result=0.0,radian;
	String memory="";
	
	static JFrame frmCalculator;
	
	private static JButton button9;
	private static JButton button8;
	private static JButton button7;
	private static JButton button6;
	private static JButton button5;
	private static JButton button4;
	private static JButton button3;
	private static JButton button2;
	private static JButton button1;
	private static JButton button0;
	private static JButton buttonadd;
	private static JButton buttonsub;
	private static JButton buttonmul;
	private static JButton buttondiv;
	private static JButton buttonequal;
	private static JButton buttonclear;
	private static JButton buttondot;
	private static JButton buttonsqrt;
	private static JButton buttonsquare;
	private static JButton buttonlog;
	private static JButton buttone;
	private static JButton buttonsin;
	private static JButton buttoncos;
	private static JButton buttontan;
	private static JButton buttonmadd;
	private static JButton buttonmsub;
	private static JButton buttonmclear;
	private static JButton buttonmrecall;
	private static JButton buttonA;
	private static JButton buttonB;
	private static JButton buttonC;
	private static JButton buttonD;
	private static JButton buttonE;
	private static JButton buttonF;
	
	static  JTextField txt;
	static JLabel mlabel;
	static JTextArea ftxt;
	static JToggleButton HexToggle;
	private static JToggleButton toggleBinary;
	private static JPanel panel_1;
	
	public static void main(String[] args) {
		
		frmCalculator = new JFrame();
		frmCalculator.getContentPane().setBackground(new Color(220, 220, 220));
		frmCalculator.setTitle("Calculator");
		frmCalculator.setVisible(true);
		frmCalculator.setBounds(-108, -141, 845, 546);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		txt = new JTextField();
		txt.setBackground(Color.LIGHT_GRAY);
		txt.setFont(new Font("Tahoma", Font.BOLD, 24));
		txt.setBounds(22, 7, 375, 79);
		frmCalculator.getContentPane().add(txt);
		txt.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(121, 102, 244, 248);
		frmCalculator.getContentPane().add(panel);
		panel.setLayout(null);

		button9 = new JButton("9");
		button9.setBounds(15, 26, 57, 36);
		panel.add(button9);

		button8 = new JButton("8");
		button8.setBounds(92, 26, 57, 36);
		panel.add(button8);

		button7 = new JButton("7");
		button7.setBounds(169, 27, 57, 36);
		panel.add(button7);

		button6 = new JButton("6");
		button6.setBounds(15, 75, 57, 36);
		panel.add(button6);

		button5 = new JButton("5");
		button5.setBounds(93, 77, 57, 36);
		panel.add(button5);

		button4 = new JButton("4");
		button4.setBounds(169, 78, 57, 36);
		panel.add(button4);

		button3 = new JButton("3");
		button3.setBounds(15, 132, 57, 36);
		panel.add(button3);

		button2 = new JButton("2");
		button2.setBounds(93, 131, 57, 36);
		panel.add(button2);

		button1 = new JButton("1");
		button1.setBounds(169, 134, 57, 36);
		panel.add(button1);

		button0 = new JButton("0");
		button0.setBounds(15, 186, 129, 36);
		panel.add(button0);

		buttondot = new JButton(".");
		buttondot.setBounds(169, 186, 57, 36);
		panel.add(buttondot);

		buttonadd = new JButton("+");
		buttonadd.setBounds(392, 96, 76, 66);
		frmCalculator.getContentPane().add(buttonadd);

		buttonsub = new JButton("-");
		buttonsub.setBounds(392, 174, 76, 36);
		frmCalculator.getContentPane().add(buttonsub);

		buttonmul = new JButton("x");
		buttonmul.setBounds(392, 231, 76, 36);
		frmCalculator.getContentPane().add(buttonmul);

		buttondiv = new JButton("/");
		buttondiv.setBounds(392, 283, 76, 36);
		frmCalculator.getContentPane().add(buttondiv);

		buttonequal = new JButton("=");
		buttonequal.setBounds(373, 335, 95, 84);
		frmCalculator.getContentPane().add(buttonequal);

		buttonclear = new JButton("CLR");
		buttonclear.setBounds(421, 25, 76, 50);
		frmCalculator.getContentPane().add(buttonclear);

		buttonsqrt = new JButton("Sqrt");
		buttonsqrt.setBounds(22, 111, 84, 50);
		frmCalculator.getContentPane().add(buttonsqrt);

		buttonsquare = new JButton("Square");
		buttonsquare.setBounds(22, 174, 84, 50);
		frmCalculator.getContentPane().add(buttonsquare);

		buttonlog = new JButton("log");
		buttonlog.setBounds(22, 235, 84, 50);
		frmCalculator.getContentPane().add(buttonlog);

		buttone = new JButton("e");
		buttone.setBounds(22, 300, 84, 50);
		frmCalculator.getContentPane().add(buttone);

		buttonsin = new JButton("sin");
		buttonsin.setBounds(22, 369, 84, 50);
		frmCalculator.getContentPane().add(buttonsin);

		buttoncos = new JButton("cos");
		buttoncos.setBounds(121, 369, 84, 50);
		frmCalculator.getContentPane().add(buttoncos);

		buttontan = new JButton("tan");
		buttontan.setBounds(220, 369, 84, 50);
		frmCalculator.getContentPane().add(buttontan);

		buttonmadd = new JButton("M+");
		buttonmadd.setBounds(494, 96, 84, 50);
		frmCalculator.getContentPane().add(buttonmadd);

		buttonmsub = new JButton("M-");
		buttonmsub.setBounds(494, 163, 84, 50);
		frmCalculator.getContentPane().add(buttonmsub);

		buttonmclear = new JButton("MC");
		buttonmclear.setBounds(494, 231, 84, 50);
		frmCalculator.getContentPane().add(buttonmclear);

		buttonmrecall = new JButton("MR");
		buttonmrecall.setBounds(494, 300, 84, 50);
		frmCalculator.getContentPane().add(buttonmrecall);

		HexToggle = new JToggleButton("Hex");
		HexToggle.setBounds(22, 435, 84, 50);
		frmCalculator.getContentPane().add(HexToggle);

		buttonA = new JButton("A");
		buttonA.setBounds(131, 435, 57, 36);
		frmCalculator.getContentPane().add(buttonA);

		buttonB = new JButton("B");
		buttonB.setBounds(201, 435, 57, 36);
		frmCalculator.getContentPane().add(buttonB);

		buttonC = new JButton("C");
		buttonC.setBounds(273, 435, 57, 36);
		frmCalculator.getContentPane().add(buttonC);

		buttonD = new JButton("D");
		buttonD.setBounds(340, 435, 57, 36);
		frmCalculator.getContentPane().add(buttonD);

		buttonE = new JButton("E");
		buttonE.setBounds(411, 435, 57, 36);
		frmCalculator.getContentPane().add(buttonE);

		buttonF = new JButton("F");
		buttonF.setBounds(483, 435, 57, 36);
		frmCalculator.getContentPane().add(buttonF);

		toggleBinary = new JToggleButton("Binary");
		toggleBinary.setBounds(494, 363, 84, 50);
		frmCalculator.getContentPane().add(toggleBinary);

		mlabel = new JLabel("Memory:");
		mlabel.setBounds(586, 25, 202, 35);
		frmCalculator.getContentPane().add(mlabel);
		mlabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		panel_1 = new JPanel();
		panel_1.setBounds(585, 76, 223, 382);
		frmCalculator.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		ftxt = new JTextArea();
		ftxt.setBounds(0, 0, 223, 383);
		panel_1.add(ftxt);
		ftxt.setFont(new Font("Monospaced", Font.PLAIN, 16));
		ftxt.setBackground(Color.GRAY);
		ftxt.setText("List of Computations:");

		new CalcuWindow();
	}


	public CalcuWindow() {
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
		buttonsqrt.addActionListener(this);
		buttonsquare.addActionListener(this);
		buttone.addActionListener(this);
		buttonlog.addActionListener(this);
		buttonsin.addActionListener(this);
		buttoncos.addActionListener(this);
		buttontan.addActionListener(this);
		buttonmadd.addActionListener(this);
		buttonmsub.addActionListener(this);
		buttonmclear.addActionListener(this);
		buttonmrecall.addActionListener(this);
		buttonA.addActionListener(this);
		buttonB.addActionListener(this);
		buttonC.addActionListener(this);
		buttonD.addActionListener(this);
		buttonE.addActionListener(this);
		buttonF.addActionListener(this);
		
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
		case "A":
			t=t+"A";
			countx++;
			txt.setText(t);
			break;
		case "B":
			t=t+"B";
			countx++;
			txt.setText(t);
			break;
		case "C":
			t=t+"C";
			countx++;
			txt.setText(t);
			break;
		case "D":
			t=t+"D";
			countx++;
			txt.setText(t);
			break;
		case "E":
			t=t+"E";
			countx++;
			txt.setText(t);
			break;
		case "F":
			t=t+"F";
			countx++;
			txt.setText(t);
			break;
		case "=":
			try{
				if(HexToggle.isSelected())//Hexadecimal Addition and Subtraction
				{
					String x,y,fn;
					x=t.substring(0, countac-1);
					y=t.substring(countac, countx);
					int hx=Integer.parseInt(x,16);
					int hy=Integer.parseInt(y,16);
					fn=t.substring(countac-1, countac);
					switch(fn){
					case "+":
						result=hx+hy;
						break;
					case "-":
						result=hx-hy;
						break;
					}
					String str=ftxt.getText();
					str=str+String.format("%n")+"___________________"+String.format("%n")+t+"="+String.valueOf(Integer.toHexString((int)result));
					ftxt.setText(str);
					t=String.valueOf(Integer.toHexString((int)result));
					txt.setText(t);
					countx=t.length();
				}
				else if(toggleBinary.isSelected())//Binary Addition and Subraction
				{
					String x,y,fn;
					x=t.substring(0, countac-1);
					y=t.substring(countac, countx);
					int hx=Integer.parseInt(x,2);
					int hy=Integer.parseInt(y,2);
					fn=t.substring(countac-1, countac);
					switch(fn){
					case "+":
						result=hx+hy;
						break;
					case "-":
						result=hx-hy;
						break;
					}
					String str=ftxt.getText();
					str=str+String.format("%n")+"___________________"+String.format("%n")+t+"="+String.valueOf(Integer.toBinaryString((int)result));
					ftxt.setText(str);
					t=String.valueOf(Integer.toBinaryString((int)result));
					txt.setText(t);
					countx=t.length();
				}
				else//Integer or Double Calculations
				{
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
					String str=ftxt.getText();
					str=str+String.format("%n")+"___________________"+String.format("%n")+t+"="+String.valueOf(result);
					ftxt.setText(str);
					//System.out.println(str);
					t=String.valueOf(result);
					txt.setText(t);
					countx=t.length();
			}
				}
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
		case "CLR":
			t="";
			countx=0;
			countac=0;
			txt.setText(t);
			break;
		case "Sqrt":
			double d1=Double.parseDouble(t);
			double sqrt=Math.sqrt(d1);
			t=String.valueOf(sqrt);
			txt.setText(t);
			break;
		case "Square":
			double d2=Double.parseDouble(t);
			d2*=d2;
			t=String.valueOf(d2);
			txt.setText(t);
			break;
		case "log":
			System.out.println(t);
			double d3=Double.parseDouble(t);
			d3=Math.log10(d3);
			t=String.valueOf(d3);
			txt.setText(t);
			break;
		case "e":
			double d4=Double.parseDouble(t);
			d4=Math.exp(d4);
			t=String.valueOf(d4);
			txt.setText(t);
			break;
		case "sin":
			double d5= Double.parseDouble(t);
			d5=Math.toRadians(d5);
			d5=Math.sin(d5);
			t=String.valueOf(d5);
			txt.setText(t);
			break;
		case "cos":
			double d6= Double.parseDouble(t);
			d6=Math.toRadians(d6);
			d6=Math.cos(d6);
			t=String.valueOf(d6);
			txt.setText(t);
			break;
		case "tan":
			double d7= Double.parseDouble(t);
			d7=Math.toRadians(d7);
			d7=Math.tan(d7);
			t=String.valueOf(d7);
			txt.setText(t);
			break;
		case "M+":
			if(memory==""){
				memory=t;
				mlabel.setText("Memory:"+memory);
			}
			else{
				double m1=Double.parseDouble(t);
				double m2=Double.parseDouble(memory);
				double m3=m1+m2;
				memory=String.valueOf(m3);
				mlabel.setText("Memory:"+memory);
			}
			
			break;
		case "M-":
			double m1=Double.parseDouble(t);
			double m2=Double.parseDouble(memory);
			double m3=m2-m1;
			memory=String.valueOf(m3);
			mlabel.setText("Memory:"+memory);
			break;
		case "MC":
			memory="";
			mlabel.setText("Memory:"+memory);
			break;
		case "MR":
			t=memory;
			txt.setText(t);
			break;
		}		
	}
}
