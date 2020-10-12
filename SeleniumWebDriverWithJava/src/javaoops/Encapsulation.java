package javaoops;

public class Encapsulation {
public static void main(String args[]) {
	BaseClassEncap obj = new BaseClassEncap();
	//getter and setter methods
	obj.setempId(5154678);
	obj.setEmpName("Kartik");
	obj.setEmpAge(30);
	System.out.println(obj.getempId());
	System.out.println(obj.getEmpAge());
	System.out.println(obj.getEmpName());
}
}
