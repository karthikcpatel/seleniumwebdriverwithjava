package exceptionhandling;

class FinallyExample1{  
	static int a = 25;
	static int b = 0;
	public static void main(String args[]){
	  try{  
	   int data=a/b;  
	   System.out.println(data);  
	  }  
	  catch(NullPointerException e){System.out.println(e);}  
	  finally{System.out.println("finally block is always executed");}  
	  System.out.println("rest of the code...");  
	  }  
	}    