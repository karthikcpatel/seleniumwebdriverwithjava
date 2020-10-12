package javaoops;

public class BaseClassEncap {
	//private data variables
	//1. private data variables, so these variables cannot be accessed outside the class
	private int empId;
	private String empName;
	private int empAge;

public int getempId() {
	return empId;
}

public void setempId(int empId) {
	this.empId = empId;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public int getEmpAge() {
	return empAge;
}

public void setEmpAge(int empAge) {
	this.empAge = empAge;
}
}