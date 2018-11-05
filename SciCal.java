import java.awt.EventQueue;             //to control swing components

import javax.swing.JFrame;             // for  visibility, frame size, resizable,
import javax.swing.JTextField;         // for textfield(display box)
import javax.swing.BorderFactory;
import javax.swing.JButton;            // for each and every buttons
import java.awt.event.ActionListener;  // Invoked when an action occurs 
import java.awt.event.ActionEvent;     //  A semantic event which indicates that a component-defined action occurred
import javax.swing.SwingConstants;     //holding swing elements
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;            //holding JPanel elements
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;



public class SciCal extends JFrame {

	private JPanel contentPane;
	
	/* some global variable */
	int count=0;
	double firstNum;
	double secondNum;
	double result;
	String operations;
	String answer;
	private JTextField textField;  // to handle display area


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SciCal frame = new SciCal();   //creating an object of the fram
					frame.setVisible(true);    		//to show the frame or layout
				} catch (Exception e) {
					e.printStackTrace();	//very useful tool for diagnosing an Exception. It tells you what happened and where in the code this happened
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public SciCal(){
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MH Tarek\\Pictures\\icon-1961299_960_720.png"));
		setTitle("MH & Saima Calculator");
		setResizable(false);
		initializer();    //call the fuction, where we do our internal code
	}
	
	private void  initializer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // when we close the program
		setBounds(100, 100, 412, 477);						//size of full layout
		contentPane = new JPanel();							 // create a JPanel (JPanel is a simplest container class)
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(BorderFactory.createLineBorder(Color.red));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("This is the display area");    //hints for the button
		textField.setHorizontalAlignment(SwingConstants.RIGHT);  // set the alignment of my text to right
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBackground(Color.CYAN);
		textField.setBounds(10, 11, 386, 105);
		contentPane.add(textField);    // add that field to the contantpane
		
		JButton button_del = new JButton("\uF0E7");  // create the button
		button_del.addActionListener(new ActionListener() {   //working function
			public void actionPerformed(ActionEvent e) {
				String backspace;

				if(textField.getText().length() > 0){
					StringBuilder strB = new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length() - 1);
					backspace = strB.toString();
					textField.setText(backspace);
				}
			}
		});
		button_del.setToolTipText("delete one entry");
		button_del.setForeground(new Color(25, 25, 112));
		button_del.setBackground(new Color(30, 144, 255));
		button_del.setBounds(10, 127, 56, 53);
		contentPane.add(button_del);
		
		JButton button_cancel = new JButton("C");
		button_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		button_cancel.setToolTipText("Erase everything");
		button_cancel.setForeground(new Color(25, 25, 112));
		button_cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_cancel.setBackground(new Color(154, 205, 50));
		button_cancel.setBounds(76, 127, 56, 53);
		contentPane.add(button_cancel);
		
		JButton button_per = new JButton("%");
		button_per.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());  //parseDouble returns a primitive double containing the value of the string:
				textField.setText("");
				operations ="%";
			}
		});
		
		button_per.setForeground(new Color(25, 25, 112));
		button_per.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_per.setBackground(new Color(255, 0, 255));
		button_per.setBounds(142, 127, 56, 53);
		contentPane.add(button_per);
		
		JButton button_plus = new JButton("+");
		button_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations ="+";
			}
		});
		button_plus.setForeground(new Color(25, 25, 112));
		button_plus.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_plus.setBackground(new Color(255, 0, 255));
		button_plus.setBounds(208, 127, 56, 53);
		contentPane.add(button_plus);
		
		JButton button_sqrt = new JButton("\u221A");
		button_sqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				
				result =  Math.sqrt(firstNum);
				answer = String.format("%.2f",result);
				textField.setText(answer);
				count=1;
			}
		});
		button_sqrt.setForeground(new Color(255, 255, 255));
		button_sqrt.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_sqrt.setBackground(new Color(148, 0, 211));
		button_sqrt.setBounds(274, 127, 56, 53);
		contentPane.add(button_sqrt);
		
		JButton button_cos = new JButton("cos");
		button_cos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				
				result =  Math.cos(Math.toRadians(firstNum));
				answer = String.format("%.2f",result);
				textField.setText(answer);
				count=1;
			}
		});
		button_cos.setForeground(new Color(255, 255, 255));
		button_cos.setFont(new Font("Dialog", Font.BOLD, 13));
		button_cos.setBackground(new Color(255, 102, 102));
		button_cos.setBounds(340, 257, 56, 53);
		contentPane.add(button_cos);
		
		JButton button_seven = new JButton("7");
		button_seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_seven.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_seven.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_seven.setForeground(new Color(25, 25, 112));
		button_seven.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_seven.setBackground(Color.CYAN);
		button_seven.setBounds(10, 191, 56, 53);
		contentPane.add(button_seven);
		
		JButton button_eight = new JButton("8");
		button_eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_eight.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_eight.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_eight.setForeground(new Color(25, 25, 112));
		button_eight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_eight.setBackground(Color.CYAN);
		button_eight.setBounds(76, 191, 56, 53);
		contentPane.add(button_eight);
		
		JButton button_nine = new JButton("9");
		button_nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_nine.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_nine.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_nine.setForeground(new Color(25, 25, 112));
		button_nine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_nine.setBackground(Color.CYAN);
		button_nine.setBounds(142, 191, 56, 53);
		contentPane.add(button_nine);
		
		JButton button_minus = new JButton("-");
		button_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations ="-";
			}
		});
		button_minus.setForeground(new Color(25, 25, 112));
		button_minus.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_minus.setBackground(new Color(255, 0, 255));
		button_minus.setBounds(208, 192, 56, 53);
		contentPane.add(button_minus);
		
		JButton button_caret = new JButton("^");
		button_caret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations ="pow";
				count=1;
			}
		});
		button_caret.setForeground(new Color(255, 255, 255));
		button_caret.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_caret.setBackground(new Color(148, 0, 211));
		button_caret.setBounds(274, 191, 56, 53);
		contentPane.add(button_caret);
		
		JButton button_sin = new JButton("sin");
		button_sin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				
				result =  Math.sin(Math.toRadians(firstNum));
				answer = String.format("%.2f",result);
				textField.setText(answer);
				count=1;
			}
		});
		button_sin.setForeground(new Color(255, 255, 255));
		button_sin.setFont(new Font("Dialog", Font.BOLD, 13));
		button_sin.setBackground(new Color(255, 102, 102));
		button_sin.setBounds(340, 191, 56, 53);
		contentPane.add(button_sin);
		
		JButton button_exit = new JButton("Exit");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_exit.setToolTipText("Exit from the program");
		button_exit.setForeground(new Color(0, 0, 0));
		button_exit.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_exit.setBackground(new Color(255, 51, 204));
		button_exit.setBounds(340, 384, 56, 53);
		contentPane.add(button_exit);
		
		JButton button_square = new JButton("Sq");
		button_square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				
				result =  Math.pow(firstNum,2);
				answer = String.format("%.2f",result);
				textField.setText(answer);
				count=1;
			}
		});
		button_square.setForeground(new Color(255, 255, 255));
		button_square.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_square.setBackground(new Color(148, 0, 211));
		button_square.setBounds(274, 256, 56, 53);
		contentPane.add(button_square);
		
		JButton button_multiple = new JButton("*");
		button_multiple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations ="*";
			}
		});
		button_multiple.setForeground(new Color(25, 25, 112));
		button_multiple.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_multiple.setBackground(new Color(255, 0, 255));
		button_multiple.setBounds(208, 256, 56, 53);
		contentPane.add(button_multiple);
		
		JButton button_six = new JButton("6");
		button_six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_six.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_six.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_six.setForeground(new Color(25, 25, 112));
		button_six.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_six.setBackground(Color.CYAN);
		button_six.setBounds(142, 256, 56, 53);
		contentPane.add(button_six);
		
		JButton button_five = new JButton("5");
		button_five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_five.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_five.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_five.setForeground(new Color(25, 25, 112));
		button_five.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_five.setBackground(Color.CYAN);
		button_five.setBounds(76, 256, 56, 53);
		contentPane.add(button_five);
		
		JButton button_four = new JButton("4");
		button_four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_four.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_four.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_four.setForeground(new Color(25, 25, 112));
		button_four.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_four.setBackground(Color.CYAN);
		button_four.setBounds(10, 256, 56, 53);
		contentPane.add(button_four);
		
		JButton button_one = new JButton("1");
		button_one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_one.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_one.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_one.setForeground(new Color(25, 25, 112));
		button_one.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_one.setBackground(Color.CYAN);
		button_one.setBounds(10, 320, 56, 53);
		contentPane.add(button_one);
		
		JButton button_two = new JButton("2");
		button_two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_two.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_two.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_two.setForeground(new Color(25, 25, 112));
		button_two.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_two.setBackground(Color.CYAN);
		button_two.setBounds(76, 320, 56, 53);
		contentPane.add(button_two);
		
		JButton button_three = new JButton("3");
		button_three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_three.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_three.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_three.setForeground(new Color(25, 25, 112));
		button_three.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_three.setBackground(Color.CYAN);
		button_three.setBounds(142, 320, 56, 53);
		contentPane.add(button_three);
		
		JButton button_division = new JButton("/");
		button_division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations ="/";
			}
		});
		button_division.setForeground(new Color(25, 25, 112));
		button_division.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_division.setBackground(new Color(255, 0, 255));
		button_division.setBounds(208, 320, 56, 53);
		contentPane.add(button_division);
		
		JButton button_Cube = new JButton("Cu");
		button_Cube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				
				result =  Math.pow(firstNum,2);
				answer = String.format("%.2f",result);
				textField.setText(answer);
				count=1;
			}
		});
		button_Cube.setForeground(new Color(255, 255, 255));
		button_Cube.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_Cube.setBackground(new Color(148, 0, 211));
		button_Cube.setBounds(274, 320, 56, 53);
		contentPane.add(button_Cube);
		
		JButton button_tan = new JButton("tan");
		button_tan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				
				result =  Math.tan(Math.toRadians(firstNum));
				answer = String.format("%.2f",result);
				textField.setText(answer);
				count=1;
			}
		});
		button_tan.setForeground(new Color(255, 255, 255));
		button_tan.setFont(new Font("Dialog", Font.BOLD, 13));
		button_tan.setBackground(new Color(255, 102, 102));
		button_tan.setBounds(340, 320, 56, 53);
		contentPane.add(button_tan);
		
		JButton button_equal = new JButton("=");
		button_equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				secondNum  = Double.parseDouble(textField.getText());
				if( operations == "+"){
					result = firstNum + secondNum;
					answer = String.format("%.2f",result);
					textField.setText(answer);
				}
				else if( operations == "-"){
					result = firstNum - secondNum;
					answer = String.format("%.2f",result);
					textField.setText(answer);
				}
				else if( operations == "*"){
					result = firstNum * secondNum;
					answer = String.format("%.2f",result);
					textField.setText(answer);
				}
				else if( operations == "/"){
					result = firstNum / secondNum;
					answer = String.format("%.2f",result);
					textField.setText(answer);
				}
				else if( operations == "%"){
					result = firstNum % secondNum;
					answer = String.format("%.2f",result);
					textField.setText(answer);
				}
				else if( operations == "pow"){
					result = Math.pow(firstNum , secondNum);
					answer = String.format("%.2f",result);
					textField.setText(answer);
				}
				count=1;    // got the result. now when we press a number it will clear the textField

			}
		});
		button_equal.setForeground(new Color(25, 25, 112));
		button_equal.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_equal.setBackground(new Color(102, 153, 255));
		button_equal.setBounds(208, 384, 56, 53);
		contentPane.add(button_equal);
		
		JButton button_plusMinus = new JButton("\u00B1");
		button_plusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = ops * (-1);
				textField.setText(String.valueOf(ops));
			}
		});
		button_plusMinus.setForeground(new Color(25, 25, 112));
		button_plusMinus.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_plusMinus.setBackground(Color.CYAN);
		button_plusMinus.setBounds(142, 384, 56, 53);
		contentPane.add(button_plusMinus);
		
		JButton button_point = new JButton(".");
		button_point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+button_point.getText());
			}
		});
		button_point.setForeground(new Color(25, 25, 112));
		button_point.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_point.setBackground(Color.CYAN);
		button_point.setBounds(76, 384, 56, 53);
		contentPane.add(button_point);
		
		JButton button_zero = new JButton("0");
		button_zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==0){
					String EnterNumber = textField.getText() + button_zero.getText();
					textField.setText(EnterNumber); 
				}
				else if(count==1){
					textField.setText(""); 
					count=0;
					String EnterNumber = textField.getText() + button_zero.getText();
					textField.setText(EnterNumber); 
				} 
			}
		});
		button_zero.setForeground(new Color(25, 25, 112));
		button_zero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_zero.setBackground(Color.CYAN);
		button_zero.setBounds(10, 384, 56, 53);
		contentPane.add(button_zero);
		
		JButton btnLog = new JButton("log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				
				result =  Math.log(firstNum)/Math.log(10);
				answer = String.format("%.2f",result);
				textField.setText(answer);
				count=1;
				
			}
		});
		btnLog.setForeground(new Color(255, 255, 255));
		btnLog.setFont(new Font("Dialog", Font.BOLD, 13));
		btnLog.setBackground(new Color(148, 0, 211));
		btnLog.setBounds(274, 383, 56, 53);
		contentPane.add(btnLog);
		
		JButton btn_factorial = new JButton("n!");
		btn_factorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.parseDouble(textField.getText());
				
				result = factorial(firstNum);
				answer = String.format("%.2f",result);
				textField.setText(answer);
				count=1;
			}
		});
		btn_factorial.setForeground(new Color(255, 255, 255));
		btn_factorial.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_factorial.setBackground(new Color(148, 0, 211));
		btn_factorial.setBounds(340, 125, 56, 53);
		contentPane.add(btn_factorial);
		
	}
	  public static double factorial(double n) {
	        if (n <= 1)
	            return 1;
	        else
	            return n * factorial(n - 1);
	    }
}

