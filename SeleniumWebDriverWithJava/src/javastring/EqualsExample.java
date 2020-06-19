package javastring;

public class EqualsExample{  
public static void main(String args[]){  
String s1="kartik is a software engineer";  
String s2="Kartik is a software engineer";  
String s3="kartik";  
String s4="python";  
System.out.println(s1.equalsIgnoreCase(s2));//true because content and case is same  
System.out.println(s1.equals(s3));//false because case is not same  
System.out.println(s1.equals(s4));//false because content is not same  
}}  
