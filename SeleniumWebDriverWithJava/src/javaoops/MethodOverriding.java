package javaoops;

class Vehicle1
	{   
	  void office()
	  {
		  System.out.println("I like to go to the office, and I am passionate about my work");
	  }  //already present
	}    
	class MethodOverriding extends Vehicle1
	{  
	  //defining the same method as in the parent class  
	  void office()
	  {
		  System.out.println("I like to spend my earned money on travelling");
	}  //changing something
	  
	  public static void main(String args[]){
		  Vehicle1 obj1 = new Vehicle1();
		  Vehicle1 obj = new MethodOverriding();//creating object  
		  obj.office();//calling method
		  obj1.office();
	  }  
	}  
