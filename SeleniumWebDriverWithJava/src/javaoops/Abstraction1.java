package javaoops;

abstract class Bike
{  
	abstract void gym();// abstract method
	void car() 
	{
		System.out.println("KP is fond of bikes...");
	}
}  
class Abstraction1 extends Bike{  

String name1 = "I am a Software Engineer...";

void gym()
{
	System.out.println("KP hits the gym every morning...");
} 

static void test() {
	System.out.println("Yeah! You understood concept of static keyword...");
}
static String name = "My name is Kartik...";

public static void main(String args[]){  
Abstraction1 obj = new Abstraction1();
obj.gym();   //nandhini
obj.car();   //aasia
System.out.println(""+obj.name1); //pasha
Abstraction1.test(); //ram
System.out.println(""+name); //ram
} 
}  