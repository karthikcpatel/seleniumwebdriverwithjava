package javastring;

public class ConcatExample{  
public static void main(String args[]){  
String s1="java string";
String s2 = "";
s2=s1.concat(" so it is assigned explicitly");  
System.out.println(s2);
s1.concat(" created by kartik");
s1 = s1.concat(" is immutable");  
System.out.println(s1);  
}}  