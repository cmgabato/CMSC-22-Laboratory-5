import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.math.BigInteger.*;

public class Calculator extends JFrame implements ActionListener{
	private static final int WIDTH =  300;
	private static final int HEIGHT = 400;
	
	private JFrame calc;
	private JTextArea box;
	private JPanel buttons1;	
	private JButton multiply;		private JButton divide;
	private JButton add;			private JButton subtract;
	private JButton decimal;		private JButton dlt;
	private JButton clr;			private JButton equals;
	private JButton percent;		private JButton posneg;

	private JButton[] buttonNums = new JButton[10];
	private BigDecimal[] temporary1 = {BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
	private boolean[] function = new boolean[4];
	private Font font = new Font("Calibri", Font.PLAIN, 20);
	private BigDecimal result2;

	Calculator(){
		for(int i=0; i<4; i++) function[i] = false;		

		calc = new JFrame("CALCULATOR");
		calc.setTitle("CALCULATOR");
		calc.setSize(WIDTH, HEIGHT);
		calc.setBackground(Color.GRAY);
		calc.setResizable(false);

		buttons1 = new JPanel(new GridLayout(5, 4, 0, 0));

		box = new JTextArea();
		box.setPreferredSize(new Dimension(200, 50));
		box.setBackground(Color.WHITE);
		box.setDisabledTextColor(Color.BLACK);
		box.setFont(font);

		for(int i=0; i!=10; i++) {
			buttonNums[i] = new JButton(Integer.toString(i));
			buttonNums[i].setBackground(Color.WHITE); 
		}
		multiply = new JButton("*");	multiply.setBackground(Color.ORANGE);
		divide = new JButton("/");		divide.setBackground(Color.ORANGE);
		add = new JButton("+");			add.setBackground(Color.ORANGE);
		subtract = new JButton("-");	subtract.setBackground(Color.ORANGE);
		decimal = new JButton(".");		decimal.setBackground(Color.WHITE);
		dlt = new JButton("()");		dlt.setBackground(Color.PINK);
		clr = new JButton("clr");		clr.setBackground(Color.PINK);
		percent = new JButton("%");		percent.setBackground(Color.PINK);
		equals = new JButton("=");		equals.setBackground(Color.ORANGE);
		posneg = new JButton("+/-");	posneg.setBackground(Color.WHITE);

		buttons1.add(clr);				buttons1.add(dlt);
		buttons1.add(percent);			buttons1.add(divide);
		buttons1.add(buttonNums[7]);	buttons1.add(buttonNums[8]);
		buttons1.add(buttonNums[9]);	buttons1.add(multiply);
		buttons1.add(buttonNums[4]);	buttons1.add(buttonNums[5]);
		buttons1.add(buttonNums[6]);	buttons1.add(subtract);
		buttons1.add(buttonNums[1]);	buttons1.add(buttonNums[2]);
		buttons1.add(buttonNums[3]);	buttons1.add(add);
		buttons1.add(buttonNums[0]);	buttons1.add(posneg);
		buttons1.add(decimal);			buttons1.add(equals);

		buttonNums[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[0]) box.append("0");
			}
		});

		buttonNums[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[1]) box.append("1");
			}
		});

		buttonNums[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[2]) box.append("2");
			}
		});

		buttonNums[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[3]) box.append("3");
			}
		});

		buttonNums[4].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[4]) box.append("4");
			}
		});

		buttonNums[5].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[5]) box.append("5");
			}
		});

		buttonNums[6].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[6]) box.append("6");
			}
		});

		buttonNums[7].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[7]) box.append("7");
			}
		});

		buttonNums[8].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[8]) box.append("8");
			}
		});

		buttonNums[9].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == buttonNums[9]) box.append("9");
			}
		});

		percent.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == percent) {
					String str = box.getText();
					BigDecimal num = new BigDecimal(str);
					temporary1[0] = num;
					percento();
				}
			}
		});

		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == add) {
					String str = box.getText();
					BigDecimal num = new BigDecimal(str);
					temporary1[0] = num;
					function[0] = true;
					box.setText("");
				}
			}
		});

		subtract.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == subtract) {
					String str = box.getText();
					BigDecimal num = new BigDecimal(str);
					temporary1[0] = num;
					function[1] = true;
					box.setText("");
				}
			}
		});

		multiply.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == multiply) {
					String str = box.getText();
					BigDecimal num = new BigDecimal(str);
					temporary1[0] = num;
					function[2] = true;
					box.setText("");
				}
			}
		});

		divide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == divide) {
					String str = box.getText();					
					BigDecimal num = new BigDecimal(str);
					temporary1[0] = num;					
					function[3] = true;
					box.setText("");
				}
			}
		});

		decimal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == decimal) box.append(".");
			}
		});

		clr.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == clr) clear();
			}
		});

		equals.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == equals) getResult();
			}
		});

		posneg.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == posneg) getPosNeg();
			}
		});

		result2 = temporary1[0];		
		calc.setVisible(true);
		calc.add(box, BorderLayout.NORTH);
		calc.add(buttons1, BorderLayout.CENTER);
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent we) {
                 System.exit(0);
             }
         });
	}

	public void clear(){
		try{
			box.setText("");
			for(int i=0; i<4; i++) function[i] = false;
			for(int i=0; i<2; i++) temporary1[i] = BigDecimal.valueOf(0);	
		}
		catch(NullPointerException e){}
	}

	public void getPosNeg(){	
		BigDecimal neg = BigDecimal.valueOf(-1);
		try{
			BigDecimal value = new BigDecimal(box.getText());
			value = value.multiply(neg);
			String m = ""+value;
			box.setText(m); 
		}
		catch(NumberFormatException e){}
	}

	public void percento(){
		try{
			BigDecimal dec = temporary1[0];
			BigDecimal imal = BigDecimal.valueOf(100);
			dec = dec.divide(imal);
			String m =""+dec;
			System.out.println(m);
			box.setText(m);
		}
		catch(NumberFormatException e){}
	}

	public void getResult(){
		result2 = temporary1[0];
	
		String str = box.getText();
		BigDecimal num = new BigDecimal(str);
		temporary1[1] = num;

		BigDecimal neg = BigDecimal.valueOf(-1);
		String temp0 = ""+temporary1[0];
		String temp1 = ""+temporary1[1];

		try{
			if(temp0.contains("-")){
				String[] temp00 = temp0.split("-", 2);
				temporary1[0] = new BigDecimal(temp00[1]).multiply(neg);
			}
			if(temp1.contains("-")){
				String[] temp11 = temp1.split("-", 2);
				temporary1[1] = new BigDecimal(temp11[1]).multiply(neg);
			}
		}
		catch(ArrayIndexOutOfBoundsException e){}

		try{
			if(function[2] == true) result2 = temporary1[0].multiply(temporary1[1]);
			if(function[3] == true) result2 = temporary1[0].divide(temporary1[1],10,BigDecimal.ROUND_HALF_UP);
			if(function[0] == true) result2 = temporary1[0].add(temporary1[1]);
			if(function[1] == true) result2 = temporary1[0].subtract(temporary1[1]);
			String m = ""+result2;
			box.setText(m);

			for(int i=0; i<4; i++) function[i] = false;
		}
		catch(NumberFormatException e){}		
	}

	@Override
	public void actionPerformed(ActionEvent e){}

	public static void main(String[] args){
		new Calculator();
	}
}
