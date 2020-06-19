package javabasics;

class KP1
{
	int id;
	String name;
	
	void insertRecord(int i, String n) 
	{
		id = i;
		name = n;
	}
	
	void displayRecord() 
	{
		System.out.println(id+ " " +name);
	}
}

class ThroughMethod {
	public static void main(String args[]) 
	{
		KP1 obj = new KP1();
		obj.insertRecord(15, "Kartik");
		obj.displayRecord();
	}
}
