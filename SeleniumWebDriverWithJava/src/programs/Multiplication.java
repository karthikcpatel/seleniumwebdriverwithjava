package programs;

import java.util.Scanner;

public class Multiplication {  
       public static void main(String[] args){
       int i=1;
       {
       Scanner s = new Scanner(System.in);
       System.out.print("Enter number: ");        
       int n=s.nextInt();
       s.close();
       for(i=1; i<=10; i++)
       {
           System.out.println(n+" * "+i+" = "+n*i);
       }
       if(n%2==0){
        System.out.println("Even number");  
       }
       else{
        System.out.println("Odd number");
       }  
       											}
       							}
}
