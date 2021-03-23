package employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f;
	Login(){
		f=new JFrame("LOGIN");
		f.setLayout(null);
		f.setVisible(true);
		f.setBounds(600, 380, 400, 300);
		JLabel l=new JLabel("Username");
		JLabel l1=new JLabel("Password");
		JLabel l2=new JLabel("Please Login");
		l2.setFont(new Font("Comic Sans MS",Font.BOLD, 20));
		l2.setForeground(Color.BLUE);
		JCheckBox c=new JCheckBox("Show Password");
		JTextField t1=new JTextField();
		JPasswordField p1=new JPasswordField();
		
		l.setBounds(40,50,100,30);
		l1.setBounds(40, 90, 100, 30);
		l2.setBounds(40, 10, 200, 30);
		p1.setBounds(140, 90,110,30);
		t1.setBounds(140,50,110,30);
		c.setBounds(130,125,125, 20);
		
		JButton b=new JButton("Login");
		b.setBounds(120, 180, 100, 40);
		b.setBackground(Color.BLACK);
		b.setForeground(Color.RED);
		
		b.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			String u=t1.getText();
			@SuppressWarnings("deprecation")
			String p=p1.getText().toString();
			try 
			{
			ConnT c=new ConnT();
			String q="select * from login where username='"+u+"' and password='"+p+"'";
			ResultSet rs=c.s.executeQuery(q);
			if(rs.next())
			{    
				JOptionPane.showMessageDialog(f, "Login Success !");
				f.setVisible(false);
				new Portal();
			}
			else {
					JOptionPane.showMessageDialog(f, "Invalid Login Details...Try Again..");
					f.setVisible(true);    
				}
			}catch(Exception e1) { System.out.println(e1.getMessage()); }}});
		

        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (c.isSelected()) {
                    p1.setEchoChar((char) 0);
                } else {
                    p1.setEchoChar('*');
                }
            }});
	
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("employee/icons/log1.jpg"));
		Image i2=i1.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l3=new JLabel(i3);
		l3.setBounds(260,15,120,150);
		f.add(l2);
		f.add(l);f.add(t1);f.add(c);
		f.add(l1);f.add(p1);
		f.add(b);f.add(l3);
		
		f.getContentPane().setBackground(Color.WHITE);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		}
		public static void main(String[] args) {
			new Login();
		}
		
			
		
}
