import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class swing1 extends JFrame{
	JButton b1;
	JTextField tf;
	JTextArea ta;
	int buttonClicked;
	public static void main(String args[])
	{
		new swing1();
	}

	public swing1(){
		this.setSize(400,400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim =tk.getScreenSize();
		int xPos=(dim.width/2)-(this.getWidth()/2);
		int yPos=(dim.height/2)-(this.getHeight()/2);
		this.setLocation(xPos,yPos);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("first swing");
		JPanel panel=new JPanel();
		b1=new JButton("click me");

		ListenForButton lforButton =new ListenForButton();
		b1.addActionListener(lforButton);
		panel.add(b1);

		tf=new JTextField("type here",15);
		ListenForKey lforkey=new ListenForKey();
		tf.addKeyListener(lforkey);
		panel.add(tf);
		ta=new JTextArea(15,20);
		ta.setText("checking events");
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		panel.add(ta); 
		this.add(panel);
		this.setVisible(true);
	}
	//implement listener
	private class ListenForButton implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==b1)
			{
				buttonClicked++;
				ta.append("button clicked" +buttonClicked+"times");
			}
		}
	}
	private class ListenForKey implements KeyListener{
		public void keyPressed(KeyEvent e){
			ta.append("key hit :" +e.getKeyChar());
		}
		public void keyReleased(KeyEvent e){
			
		}
		public void keyTyped(KeyEvent e){
			
		}
	
	}
}