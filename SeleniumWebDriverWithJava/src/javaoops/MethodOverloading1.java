package javaoops;

class Add1{  

void add(int a,int b,int c)
{
	System.out.println(a+b);
	}  

int add(int a,int b)
{
	return a+b;
	}  
}  

public class MethodOverloading1{  
public static void main(String[] args){  
Add1 obj = new Add1();
obj.add(11,11);
obj.add(11, 11, 11);//The output did not got printed for this line.
}} 
