import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.NumberFormat;
import javax.swing.border.*;

public class swing2 extends JFrame{
	JButton b1;
	JLabel l1,l2,l3;
	JTextField t1,t2;
	JCheckBox dollar,comma;
	JRadioButton addNum,subNum,multNum,divideNum;
	JSlider howMany;
	double num1,num2,totalCalc; 

	public static double addNumbers(double n1,double n2,int n3){
			double total=0;
			int i=0;
			while(i<n3)
			{
				total+=n1+n2;
				i++;
			}
			return total;

		}
	public static double subtractNumbers(double n1,double n2,int n3){
		double total=0;
		int i=0;
		while(i<n3)
		{
			total+=n1-n2;
			i++;
		}
		return total;

	}
	public static double multiplyNumbers(double n1,double n2,int n3){
		double total=0;
		int i=0;
		while(i<n3)
		{
			total+=n1*n2;
			i++;
		}
		return total;

	}
	public static double divideNumbers(double n1,double n2,int n3){
		double total=0;
		int i=0;
		while(i<n3)
		{
			total+=n1/n2;
			i++;
		}
		return total;

	}
	public static void main(String args[]){
		new swing2();
	}
	public swing2(){
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("second frame");
		JPanel panel=new JPanel();
		b1=new JButton("calculate");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==b1){
					try{
						num1=Double.parseDouble(t1.getText());
						num2=Double.parseDouble(t2.getText());
					}//end of try block
					catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(swing2.this,"please enter the right info","error",JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}//end of catch block

				if(addNum.isSelected()){
					totalCalc=addNumbers(num1,num2,howMany.getValue());
				}
				else if(subNum.isSelected()){
					totalCalc=subtractNumbers(num1,num2,howMany.getValue());
				}
				else if(multNum.isSelected()){
					totalCalc=multiplyNumbers(num1,num2,howMany.getValue());
				}
				else {
					totalCalc=divideNumbers(num1,num2,howMany.getValue());
				}

				

				if(dollar.isSelected()){
					NumberFormat numFormat =NumberFormat.getCurrencyInstance();
					JOptionPane.showMessageDialog(swing2.this,numFormat.format(totalCalc),"solution",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(comma.isSelected()){
					NumberFormat numFormat =NumberFormat.getNumberInstance();
					JOptionPane.showMessageDialog(swing2.this,numFormat.format(totalCalc),"solution",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(swing2.this,totalCalc,"solution",JOptionPane.INFORMATION_MESSAGE);
				}
			}// end of if block
			}//action performed ends here
		});//action listener ends here
		panel.add(b1);
		l1=new JLabel("number 1");
		panel.add(l1);
		t1=new JTextField("",5);
		panel.add(t1);
		l2=new JLabel("number 2");
		panel.add(l2);
		t2=new JTextField("",5);
		panel.add(t2);

		dollar =new JCheckBox("dollar sign");
		comma=new JCheckBox("comma");
		panel.add(dollar);
		panel.add(comma,true);

		addNum=new JRadioButton("add nums");
		subNum=new JRadioButton("subtract nums");
		multNum=new JRadioButton("multiply nums");
		divideNum=new JRadioButton("divide nums");
		ButtonGroup bg=new ButtonGroup();
		bg.add(addNum);
		bg.add(subNum);
		bg.add(multNum);
		bg.add(divideNum);

		JPanel panel2=new JPanel();
		Border border=BorderFactory.createTitledBorder("operation");
		panel2.setBorder(border);
		panel2.add(addNum);
		panel2.add(subNum);
		panel2.add(multNum);
		panel2.add(divideNum);
		addNum.setSelected(true);
		panel.add(panel2);

		l3=new JLabel("how many times");
		panel.add(l3);

		howMany=new JSlider(0,99,1);
		howMany.setMinorTickSpacing(1);
		howMany.setMajorTickSpacing(10);
		howMany.setPaintTicks(true);
		howMany.setPaintLabels(true);
	    howMany.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent e){
	    		if(e.getSource()==howMany){
	    			l3.setText("how many time?"+howMany.getValue());
	    		}
	    	}
		});
		
		panel.add(howMany);
		this.add(panel);
		this.setVisible(true);

		t1.requestFocus();
	}
	
}