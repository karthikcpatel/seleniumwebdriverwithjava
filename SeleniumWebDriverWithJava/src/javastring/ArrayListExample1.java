package javastring;

import java.util.ArrayList;

public class ArrayListExample1 {

	public static void main(String args[]){  
		  ArrayList<String> al=new ArrayList<String>();  
		  al.add("Kartik");  
		  al.add("Neetha");  
		  al.add("Asha");  
		  al.add("Savi");
		  al.add("Vaishnavi");
		   //Traversing list through for-each loop  
		  for(String obj:al)  
		  System.out.println(obj); 
		 }  
	
}
