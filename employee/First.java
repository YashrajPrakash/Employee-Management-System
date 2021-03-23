package employee;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class First implements ActionListener {
	JFrame f; 
    JLabel id;
    JButton b;

    First(){
 
        f=new JFrame("Employee Management System");
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee/icons/e1.png"));
        Image i2 = i1.getImage().getScaledInstance(800,400,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        
        l1.setBounds(0,150,1360,530);
        f.add(l1);
  
        b = new JButton("  PROCEED >>>");
        b.setBackground(Color.lightGray);
        b.setForeground(Color.BLACK);
        b.setBounds(550,600,150,70);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        
   

        JLabel l2=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        l2.setBounds(80,30,1500,100);
        l2.setFont(new Font("Times New Roman",Font.PLAIN,70));
        l2.setForeground(Color.red);
        id.add(l2);

        id.add(b);
        f.add(id);
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(1360,750);
        f.setLocation(150,100);
        
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b){
            f.setVisible(false);
            new Login();
        }
    }

    public static void main(String[] arg){
        new First();
    }
}

