package programs;

import java.util.Arrays;

public class CompareArray {
	   public static void main (String[] args) {
	      int arr1[] = {1, 2, 3};
	      int arr2[] = {1, 2, 3};
	      if (Arrays.equals(arr1, arr2)) {
	    	  System.out.println("Both the arrays are same");
	    	  }
	      else System.out.println("Both the arrays are different");
	   }
	}
