package javaoops;

class A{  
void defaultmethod(){System.out.println("This is from class A");}  
}  

class B{  
void defaultmethod(){System.out.println("This is from class B");}  
}  
public class MultipleInheritance extends A{
   
 public static void main(String args[]){  
	 MultipleInheritance obj = new MultipleInheritance();  
	 obj.defaultmethod();
}  
}  