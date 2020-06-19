package exceptionhandling;

public class Throw{  
	   void checkAge(int age){  
		if(age<18)  
		   throw new ArithmeticException("Not Eligible for voting");  
		else  
		   System.out.println("Eligible for voting");  
	   }  
	   public static void main(String args[]){  
		Throw obj = new Throw();
		obj.checkAge(15);  
		System.out.println("End Of Program");  
	   }  
	}
