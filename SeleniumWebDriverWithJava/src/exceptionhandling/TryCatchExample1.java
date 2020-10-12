package exceptionhandling;

public class TryCatchExample1 {  
	  static int a=10;
	  static int b=5;
	  static int c=0;
	public static void main(String[] args) {
        try  
        {  
        	int data = a/b;//may throw exception
        	System.out.println(data);//2
        	int data1 = a/c;//may throw exception
        	System.out.println(data1);//exception
        	int data2 = a/b;
        	System.out.println(data2);//2
        }  
            //handling the exception  
        catch(ArithmeticException e)  
        {  
            System.out.println(e);  
        }  
        System.out.println("rest of the code");  
    }   
} 
