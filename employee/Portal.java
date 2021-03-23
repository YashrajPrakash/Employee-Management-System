package employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Portal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f;
	Portal()
	{
		f=new JFrame("Portal");
		f.setLayout(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton b1=new JButton("ENROLL");
		JButton b2=new JButton("MANAGE EMPLOYEES");
				b2.setFont(new Font("Times New Roman,",Font.BOLD, 10));
		
		f.setBounds(200, 150, 900, 600);
		
		b1.setBounds(30,60,100,50);
		b1.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e1) {
						new Enroll();
						f.setVisible(false);
					}});
		
		b2.setBounds(150, 60, 150, 50);
		b2.setBackground(Color.DARK_GRAY);
		b2.setForeground(Color.WHITE);
		b2.setVisible(true);
		b2.addActionListener(new ActionListener()
		
				{
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(f, "Enter employee's ID in the next window to EDIT data!");
						new Search();
						f.setVisible(false);
					}
				});
		
		

		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("employee/icons/emp.jpg"));
		JLabel l1=new JLabel(i1);
		l1.setBounds(0, 0, 900, 600);
		
		f.add(l1);
		f.add(b1);
		f.add(b2);
		f.setVisible(true);
		}
	
	public static void main(String[] args) {
		new Portal();
	
}
}