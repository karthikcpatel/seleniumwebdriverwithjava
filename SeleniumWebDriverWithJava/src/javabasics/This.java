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
KP5 s1 = new KP5(15,"Kartik");  
KP5 s2 = new KP5(9,"Dipika");  
s1.display();  
s2.display();  
}
}
