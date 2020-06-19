package javaoops;

class Add{  

static float add(int a,float b)
{
	return a+b;
	}  

static int add(int a,int b)
{
	return a+b;
	}  
}  

public class MethodOverloading{  
public static void main(String[] args){  
System.out.println(Add.add(11,11));  
System.out.println(Add.add(11,11));  
}} 