package programs;

public class StringSplit {
	   public static void main(String args[]) {
	      String str = "k a r t i k"; 
	      String[] words = str.split("\\s"); 
	      for(String w:words) {
	         System.out.println(w);  
	      }  
	   }
	}