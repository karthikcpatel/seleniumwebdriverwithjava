package javaoops;

class Chetan{  
void gavemoney()
{
	System.out.println("He used to give a good amount as pocket money...");}  
}  

class Kartik extends Chetan{  
void spendmoney(){System.out.println("I used to spend all of them, and used to take money from my mom too...");}  
}  

public class SingleInheritance{  
public static void main(String args[]){  
Kartik k = new Kartik();
k.gavemoney();  
k.spendmoney();
}}  

//using something from our parent