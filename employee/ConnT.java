package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnT {
	Connection con=null;
	Statement s=null;
	ConnT(){
	try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empd", "root", "password");
			s=con.createStatement();
			
		}catch(Exception e) {e.printStackTrace();}
	}
	public static void main(String[] args) {
		new ConnT();
	}

	}
