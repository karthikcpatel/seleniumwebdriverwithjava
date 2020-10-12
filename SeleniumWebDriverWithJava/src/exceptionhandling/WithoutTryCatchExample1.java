package exceptionhandling;

public class WithoutTryCatchExample1 {  
	  static int a=50;
	  static int b=5;
	  static int c=0;
	public static void main(String[] args) {
        	int data = a/b;
        	System.out.println(data);
        	int data1 = a/c;//may throw exception
        	System.out.println(data1);
        	float data2 = b/a;
        	System.out.println(data2);
        	System.out.println("rest of the code");  
    }   
} 