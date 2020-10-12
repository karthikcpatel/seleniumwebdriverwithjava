package javaoops;

public class Abstraction {
public static void main(String args[]) {
	BaseClassAbs obj = new BaseClassAbs();
	//getter and setter methods
	obj.setBase(5.0f);
	obj.setheight(3.0f);
	float area = obj.area();
	System.out.println("Base = " +obj.getBase());
	System.out.println("Height = " +obj.getHeight());
	System.out.println("Area = " +area);
}
}
