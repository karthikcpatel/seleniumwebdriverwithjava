package javaoops;

class Dhanji1{  
void dhanji(){System.out.println("Unfortunately, I never saw my grandfather");}  
}  
class Chetan1 extends Dhanji1{  
void chetan(){System.out.println("My dad is a true gentleman");}  
}  
class Kartik1 extends Chetan1{  
void kartik(){System.out.println("I was a spoilt lad during my adolescent age");}  
}  
public class MultilevelInheritance{  
public static void main(String args[]){  
Kartik1 d = new Kartik1();  
d.dhanji();  
d.chetan();  
d.kartik();  
}}  
