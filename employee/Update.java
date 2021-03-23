package employee;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class Update extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f;
	JLabel l,l1,l2,l3,l4,l5,l6,l7;
	JTextField t,t1,t2,t3,t4,t5,t6;
	JButton b,b1,b2,b3;
	String ud;
	
	
	Update(String id){
		String ud=id;
		f=new JFrame("MANAGE EMPLOYEE DETAILS!");
		f.setLayout(null);
		f.setBounds(450, 250, 900, 450);
		f.getContentPane().setBackground(Color.blue);
		
		l=new JLabel(" Selected employee details:");
		l.setBounds(50,10,500,50);
	    l.setFont(new Font("open sans",Font.ITALIC,30));
	    l.setForeground(Color.black);
	    f.add(l);
	        
	    l1=new JLabel("Name:");
        l1.setBounds(50,100,100,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        f.add(l1);

        t=new JTextField();
        t.setBounds(200,100,150,30);
        f.add(t);

        l2 = new JLabel("ID:");
        l2.setBounds(500,100,200,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        f.add(l2);

        t1=new JTextField();
        t1.setBounds(600,100,150,30);
        f.add(t1);

        l3= new JLabel("Position:");
        l3.setBounds(50,150,100,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        f.add(l3);

        t2=new JTextField();
        t2.setBounds(200,150,150,30);
        f.add(t2);

        l4= new JLabel("Salary:");
        l4.setBounds(500,150,100,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        f.add(l4);

        t3=new JTextField();
        t3.setBounds(600,150,150,30);   
        f.add(t3);

        l5= new JLabel("Department:");
        l5.setBounds(50,200,130,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        f.add(l5);

        t4=new JTextField();
        t4.setBounds(200,200,150,30);
        f.add(t4);

        l6= new JLabel("Age:");
        l6.setBounds(500,200,100,30);
        l6.setFont(new Font("serif",Font.BOLD,20));    
        f.add(l6);

        t5=new JTextField();
        t5.setBounds(600,200,150,30);
        f.add(t5);

        l7= new JLabel("Email:");
        l7.setBounds(50,250,100,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        f.add(l7);

        t6=new JTextField();
        t6.setBounds(200,250,150,30);
        f.add(t6);

        
        b=new JButton("Update");
        b.setBounds(360,350,100,30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        f.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(580,350,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
 
        f.add(b1);
        
        b2=new JButton("Remove");
        b2.setBounds(260,350,100,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        f.add(b2);
        
        b3=new JButton("Print");
        b3.setBounds(460,350,100,30);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        f.add(b3);
        
        
        
        b.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e) {
        				try {
        					PreparedStatement stmt;
        					ConnT c=new ConnT();
        					stmt=c.con.prepareStatement("UPDATE details  SET name = ?,ID = ?,Position = ?,Salary = ?,Department = ?,Age = ?,Email =? where ID ='"+ud+"'");
        					stmt.setString(1, t.getText());
        					stmt.setString(2, t1.getText());
        					stmt.setString(3, t2.getText());
        					stmt.setString(4, t3.getText());
        					stmt.setString(5, t4.getText());
        					stmt.setString(6, t5.getText());
        					stmt.setString(7, t6.getText());
        					stmt.executeUpdate();
        					JOptionPane.showMessageDialog(f,"Details Successfully Updated");
        					f.setVisible(false);
        					new Search();
        				}catch(Exception e1) {System.out.println(e1.getMessage());}
        			}
        		});
        
        b1.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e) {
        				f.setVisible(false);
        				new Search();
        			}
        		});
        
        b2.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e) {
        				try 
        				{
        					ConnT c=new ConnT();
        					String o="DELETE from details where ID ='"+t1.getText()+"'";
        					c.s.executeUpdate(o);
        					JOptionPane.showMessageDialog(f, "Employee Details Deleted!");
        					b.setVisible(false);
        					b1.setVisible(false);
        					b2.setVisible(false);
        					f.setVisible(false);
        					new Search();
        					
        				}catch(Exception e1) {System.out.println("Error: "+e1.getMessage());}
        			}
        		});
        
       b3.addActionListener(new ActionListener()
    		   {
    	   			public void actionPerformed(ActionEvent e) {
    	   					
    	   				String r=setprint(ud);
    	   				new Print(r);
    	   				JOptionPane.showMessageDialog(f, "Text file with employee details generated! Don't forget to save!!");
    	   			}});

        initialData(ud);
        //System.out.println(ud);
       
    

		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    
    public void initialData(String id) {
			ConnT c=new ConnT();
			String q="SELECT * from details where ID= '"+id+"'";
			try {
			ResultSet rs;
			rs = c.s.executeQuery(q);
			if(rs.next()) 
			{
					 f.setVisible(true);
					 t.setText(rs.getString(1));
				     t1.setText(rs.getString(2));
				     t2.setText(rs.getString(3));
				     t3.setText(rs.getString(4));
				     t4.setText(rs.getString(5));
				     t5.setText(rs.getString(6));
				     t6.setText(rs.getString(7)); 			
		    }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}}
    
    public String setprint(String ud) {
    	String s=" Employee Name : "+t.getText() +"\n"+" ID : "+ud+"\n"+
					" Position : "+t2.getText()+"\n"+" Salary : "+t3.getText()+"\n"+
					" Department : "+t4.getText()+"\n"+" Age : "+t5.getText()+"\n"+" Email : "+t6.getText();
    	return s;
    	
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new Update("");
	}
}
