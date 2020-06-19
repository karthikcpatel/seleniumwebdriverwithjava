package javabasics;

class Student{  
int rollno;//instance variable  
String name;  
static String college1 ="BVM";//static variable
static String college2 ="DDIT";//static variable
Student(int r, String n){  
rollno = r;  
name = n;  
}  
//method to display the values  
void display1 (){System.out.println(rollno+" "+name+" "+college1);}
void display2 (){System.out.println(rollno+" "+name+" "+college2);
}  
}  
//Test class to show the values of objects  
public class StaticExampleInDetail{  
public static void main(String args[]){  
Student s1 = new Student(15,"Kartik");  
Student s2 = new Student(9,"Dipika");  
Student s3 = new Student(15,"Ram");  
Student s4 = new Student(9,"Chetan");
s1.display1();  
s2.display1();
s3.display2();  
s4.display2();
}  
} 