package javastring;

import java.util.HashMap;
import java.util.Map;

public class MapExample{  
	 public static void main(String args[]){  
	  Map<Integer,String> map=new HashMap<Integer,String>();  
	  map.put(100,"Kartik");  
	  map.put(101,"Chetan");  
	  map.put(102,"Kusum");  
	  map.put(103,"Neetha"); // neetha = 103
	  map.put(104,"Kartik");
	  map.put(103,"Asha");  // asha = 103
	  map.put(105,"Aasia");  //aasia = 105
	  map.put(105,"Pasa"); //pasa = 105
	  map.put(105,"Nandhini");
	  //Elements can traverse in any order  
	  for(Map.Entry m:map.entrySet()){  
	  System.out.println(m.getKey()+" "+m.getValue());  
	  }  
	 }  
	}  