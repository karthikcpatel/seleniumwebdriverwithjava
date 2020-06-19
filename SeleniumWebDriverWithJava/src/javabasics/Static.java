package javabasics;

class KP4{
	static String name = "Kartik";
	int bday = 1506;
	static void test() 
	{
		System.out.println("Static method got called");
	}
	void ram() 
	{
		System.out.println("Non static method got called");
	}
}

public class Static {
	public static void main(String args[]) 
	{
		KP4 obj = new KP4();
		System.out.println("My birthday: " +obj.bday);
		KP4.test();
		System.out.println("Static variable got called: " +KP4.name);
		obj.ram();
	}
}
