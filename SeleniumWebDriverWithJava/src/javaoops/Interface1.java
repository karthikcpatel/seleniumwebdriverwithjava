package javaoops;

interface KP15{  
void print();
}  
class Interface1 implements KP15{  
public void print(){System.out.println("Hello Everyone. Let's try to understand Interface in Java");}  
  
public static void main(String args[]){  
Interface1 obj = new Interface1();  
obj.print();  
 } 
}

