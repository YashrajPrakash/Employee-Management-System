package employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Search extends JFrame {
	JFrame f=new JFrame("Update Window");
	JLabel l=new JLabel("Enter Employee ID ");
	 JTextField t=new JTextField(5);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Search(){
	
		
		f.setLayout(null);
		f.setBounds(400, 400, 500, 300);
		l.setVisible(true);
        l.setBounds(30,50,280,30);
        l.setForeground(Color.magenta);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1); 
        JLabel l1=new JLabel();
        l1.setBounds(0,0,900,700);
        l1.setLayout(null);
        f.getContentPane().setBackground(Color.YELLOW);
        l1.add(l);
        f.add(l1);

       
        t.setBounds(300,50,100,30);
        f.add(l);
		f.add(t);
		
		JButton b=new JButton("Proceed");
        b.setBounds(260,160,100,30);
        b.setBackground(Color.black);
        b.setForeground(Color.WHITE);
        f.add(b);
        
        b.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e) {
		try {
			ConnT c=new ConnT();
			String s= "select * from details where ID = '"+t.getText()+"'";
			//System.out.println(t.getText());
			ResultSet rs = c.s.executeQuery(s);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null,"ID Found: SUCCESS! Click 'OK' to proceed!");
				f.setVisible(false);
				new Update(t.getText());
			
			}
			else
				JOptionPane.showMessageDialog(null,"ID : Not Found !!! Try with a correct one!");
				
			}catch(Exception e1) {System.out.println("Error encountered: "+e1.getMessage());}
		
		}
		});
        
        JButton b1=new JButton("<< Back");
        b1.setBounds(120,160,100,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        
        b1.addActionListener(new ActionListener()
        		{
        		public void actionPerformed(ActionEvent e) {
        			new Portal();
        			f.setVisible(false);
        		}
        		});

		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
 public static void main(String[] args) {
	 	new Search();
}

}
