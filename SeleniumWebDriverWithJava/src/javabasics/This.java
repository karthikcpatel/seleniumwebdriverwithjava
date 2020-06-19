package javabasics;

class KP5{  

int rollno;  
String name;    

KP5(int rollno,String name)
{  
	this.rollno=rollno;  
	this.name=name;  
}  
void display(){System.out.println(rollno+" "+name);}  
}  
  
public class This{  
public static void main(String args[]){  
KP6 s1 = new KP6(15,"Kartik");  
KP6 s2 = new KP6(9,"Dipika");  
s1.display();  
s2.display();  
}
}
