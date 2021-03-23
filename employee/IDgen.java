package employee;
/** THIS IS FOR UNIQUE ID GENERATION**/

public class IDgen {
	String Domain= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public String IDgeN(int count) {
	StringBuilder sb=new StringBuilder();
	while(count -->0) {
		int c=(int)(Math.random()*Domain.length());
		sb.append(Domain.charAt(c));
	}
	return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new IDgen();
}}
