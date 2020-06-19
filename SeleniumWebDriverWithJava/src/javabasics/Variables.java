package javabasics;

public class Variables
{  
		int data=50;//instance variable  
		static int m=100;//static variable  
		void method()
		{  
		int n=90;//local variable  
		System.out.println("Local variable is being called: " +n);
		}		 
public static void main(String args[]) 
{
	//class-name objectname = new class-name();
	Variables vb = new Variables(); //to create an object in java
	vb.method();
	System.out.println("Static variable is being called: " +m);
	System.out.println("Instance variable is being called: " +vb.data);
	//System.out.println("Instance variable is being called: " +data);
}		
}//end of class

 
