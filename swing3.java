import javax.swing.*;
import java.awt.event.*;

public class swing3 extends JFrame{
	JComboBox favouriteShows;
	JButton b1;
	String infoOnComp="";

	public static void main(String args[])
	{
		new swing3();
	}
	swing3()
	{
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("third frame");
		JPanel panel =new JPanel();
		String[] shows={"Friends","GOT","HIMYM","Suits"};
		favouriteShows=new JComboBox(shows);
		favouriteShows.insertItemAt("braeking bad",2);
		favouriteShows.removeItem("Friends");
		favouriteShows.removeItemAt(1);
		panel.add(favouriteShows);
		b1=new JButton("Get Info");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==b1)
				{
					favouriteShows.setEditable(true);
					infoOnComp+="item at index 0: "+favouriteShows.getItemAt(0)+"\n";
					infoOnComp+="number of items: "+favouriteShows.getItemCount()+"\n";
					infoOnComp+="Is editable: "+favouriteShows.isEditable()+"\n";
					infoOnComp+="index: "+favouriteShows.getSelectedIndex()+"\n";
					infoOnComp+="item: "+favouriteShows.getSelectedItem()+"\n";
					JOptionPane.showMessageDialog(swing3.this,infoOnComp,"informtion",JOptionPane.INFORMATION_MESSAGE);
					infoOnComp="";
				}
			}
		});
		panel.add(b1);
		this.add(panel);
		this.setVisible(true);
	}
}