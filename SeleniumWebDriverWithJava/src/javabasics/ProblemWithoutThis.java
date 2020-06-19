package javabasics;

class KP6{  

int rollno;  
String name;    

KP6(int rollno,String name)
{  
	rollno=rollno;  
	name=name;  
}  
void display(){System.out.println(rollno+" "+name);}  
}  
  
public class ProblemWithoutThis{  
public static void main(String args[]){  
KP6 s1 = new KP6(15,"Kartik");  
KP6 s2 = new KP6(9,"Dipika");  
s1.display();  
s2.display();  
}
}


