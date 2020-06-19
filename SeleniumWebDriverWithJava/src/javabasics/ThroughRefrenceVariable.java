package javabasics;

class KP {
	String name = null;
}

class ThroughRefrenceVariable {
	public static void main(String args[]) 
	{
		KP obj = new KP();
		obj.name = "Kartik Patel";
		System.out.println(obj.name);
	}
	
}
