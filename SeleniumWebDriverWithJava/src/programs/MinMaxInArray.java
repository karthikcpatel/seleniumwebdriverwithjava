package programs;

public class MinMaxInArray {
	public static void main(String[] args) 
	{
	      int numbers[] = new int[]{8, 2, 7, 1, 4, 9, 5};
	      int numbers1[] = {1,2,2,3,4,};
	      int s = numbers[0];
	      int l = numbers[0];
	      
	      for(int i = 1; i < numbers.length; i++) {
	         if(numbers[i] > l) {
	        	 l = numbers[i]; 
	         }
	         else if (numbers[i] < s)
	        	 {
	        	 s = numbers[i];
	        			 }
	      } 
	      System.out.println("Largest Number is : " + l);
	      System.out.println("Smallest Number is : " + s);
	  }
}
