package exceptionhandling;

public class TryCatchExample1 {  
	  static int a=50;
	  static int b=5;
	  static int c=0;
	public static void main(String[] args) {
		TryCatchExample1 obj = new TryCatchExample1();
        try  
        {  
        int data = a/b;//may throw exception
        System.out.println(data);
        int data1 = a/c;//may throw exception
        System.out.println(data1);
        int data2 = a/b;//may throw exception
        System.out.println(data2);
        }  
            //handling the exception  
        catch(ArithmeticException e)  
        {  
            System.out.println(e);  
        }  
        System.out.println("rest of the code");  
    }   
} 
