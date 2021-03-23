package employee;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;


public class Print  {
	String r;

	

		
	Print(String ud) {
		r=ud;
		try {
		 FileOutputStream fo=new FileOutputStream("EmpDetails.txt");        
            byte b[]=r.getBytes();    
            fo.write(b);    
            fo.close();    
            System.out.println("success...");    
            Desktop desktop=Desktop.getDesktop();
            File file=new File("EmpDetails.txt");	   		            
            if(file.exists())
            desktop.open(file);
           // JOptionPane.showMessageDialog(f, "Text file Generated!");
           }catch(Exception e2){System.out.println(e2);
           }  
		} 
		

		
	


	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		new Print("");
		
		
	}}
		