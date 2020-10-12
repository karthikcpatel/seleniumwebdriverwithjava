package javaoops;

public class BaseClassAbs {
	//private data variables
	//1. private data variables, so these variables cannot be accessed outside the class
	private float base, height;
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base =  base;
	}
	
	public float getHeight() {
		return height;
	}
	public void setheight(float height) {
		this.height =  height;
	}
	public float area() {
		float result = (0.5f)*base*height;
		return result;
	}
}