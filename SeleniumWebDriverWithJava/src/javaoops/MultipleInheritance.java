package javaoops;

class A{  
void msg1(){System.out.println("Multiple Inheritance");}  
}  

class B{  
void msg2(){System.out.println("Is Not Supported In Java");}  
}  
public class MultipleInheritance extends A {
   
 public static void main(String args[]){  
	 MultipleInheritance obj=new MultipleInheritance();  
	 obj.msg1();  
	 //obj.msg2();
}  
}  