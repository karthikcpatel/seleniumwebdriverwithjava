package javastring;

public class SplitExample{  
public static void main(String args[]){  
String s1="java string split method by Java";  
String[] words=s1.split("\\s");//splits the string based on whitespace  
//using java foreach loop to print elements of string array  
for(String nandhini:words){  
System.out.println(nandhini);  
}  
}}  
