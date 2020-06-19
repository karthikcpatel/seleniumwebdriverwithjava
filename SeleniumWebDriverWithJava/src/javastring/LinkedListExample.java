package javastring;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample{  
	 public static void main(String args[]){  
	  
	  LinkedList<String> al=new LinkedList<String>();  
	  al.add("Kartik");  
	  al.add("Neetha");  
	  al.add("Asha");  
	  al.add("Vaishnavi");  
	  
	  Iterator<String> itr=al.iterator();  
	  while(itr.hasNext()){  
	  System.out.println(itr.next());  
	  }  
	 }  
	}  