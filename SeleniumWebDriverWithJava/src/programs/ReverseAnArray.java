package programs;

public class ReverseAnArray {
	   public static void main(String[] args) {
	      int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	      System.out.println("Array before reverse:");
	      for (int i = 0; i < numbers.length; i++) {
	         System.out.print(numbers[i] + " ");
	      } 
	      System.out.println("\nArray after reverse:");
	      for(int i=numbers.length-1;i>=0;i--)
	      System.out.print(numbers[i] + "  "); 
	   }
	}