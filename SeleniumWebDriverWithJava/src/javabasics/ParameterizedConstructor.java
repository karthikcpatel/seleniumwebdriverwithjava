package javabasics;

class KP3
{
	int num;
	String name;
	
	KP3(int n,String nm){
		num=n;
		name=nm;
	}
	
	void display() {
		System.out.println(num+ " " +name);
	}
}

class ParameterizedConstructor {
public static void main(String args[]) {
	KP3 obj = new KP3(15, "My name is Kartik");
	obj.display();
}
}