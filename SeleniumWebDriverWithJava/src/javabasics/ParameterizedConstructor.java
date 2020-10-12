package javabasics;

class KP3
{
	int num;
	String name;
	
	KP3(int n,String nm){
		num=n; //n=15;nm="My"
		name=nm;
	}
	
	void display() {
		System.out.println(num+ " " +name);
	}
}

class ParameterizedConstructor {
public static void main(String args[]) {
	KP3 obj = new KP3(15, "My name is Kartik");
	KP3 obj1 = new KP3(10, "Hello Tanuj");
	obj.display();
	obj1.display();
}
}