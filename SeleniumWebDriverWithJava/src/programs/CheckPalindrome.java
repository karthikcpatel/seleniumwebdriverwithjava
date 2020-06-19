package programs;

public class CheckPalindrome {
public static void main(String args[]){  
 int a,sum=0,temp;    
 int n=455;//It is the number variable to be checked for palindrome  
 
 temp=n;    
 while(n>0){    
 a=n%10;  //getting remainder    454%10=4
 n=n/10;                       //454/10=45 
 sum=(sum*10)+a;
 }    
 if(temp==sum)    
 System.out.println("palindrome number ");    
 else    
 System.out.println("not palindrome");    
}  
}
