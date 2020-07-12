package programs;

public class BubbleSort {
	   static void bubbleSort(int[] arr) {
	      int temp = 0;
	      for(int i=0;i<arr.length-1;i++) {
	    	  for(int j=0;j<arr.length-1-i;j++) {
	    		  if (arr[j]>arr[j+1]) {
	    			  temp=arr[j];
	    			  arr[j]=arr[j+1];
	    			  arr[j+1]=temp;
	            } 
	         } 
	      } 
	   }  
	   // 3,5,1,4(i=0;j=0)
	   //3,1,5,4 (i=0;j=1)
	   //3,1,4,5 (i=0;j=2)
	   //1,3,4,5 (i=1;j=0)
	   //1,3,4,5 (i=1;j=1)
	   //1,3,4,5 (i=2;j=0)
	   //1,3,4,5 (i=2;j=1)//inner loop will end
	   //1,3,4,5 (i=3;j=1)
	   public static void main(String[] args) {
	      int arr[] = { 5, 3, 1, 4 }; 
	      System.out.println("Array Before Bubble Sort");
	      for(int i = 0; i < arr.length; i++) {
	         System.out.print(arr[i] + " ");
	      } 
	      System.out.println();
	      bubbleSort(arr);
	      System.out.println("Array After Bubble Sort");
	      for(int i = 0; i < arr.length; i++) {
	         System.out.print(arr[i] + " ");
	      } 
	   }  
	}  
