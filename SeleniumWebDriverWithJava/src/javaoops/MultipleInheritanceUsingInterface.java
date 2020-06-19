package javaoops;

interface Dhanji2{  
void method();  
}  
interface Chetan2{  
void method1();  
}  
class MultipleInheritanceUsingInterface implements Dhanji2, Chetan2{  
public void method(){System.out.println("That's my grandfather...");}  
public void method1(){System.out.println("That's my father...");}  
  
public static void main(String args[]){  
MultipleInheritanceUsingInterface obj = new MultipleInheritanceUsingInterface();  
obj.method();  
obj.method1();  
 }  
} 
