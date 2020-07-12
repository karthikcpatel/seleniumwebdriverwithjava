package programs;

public class ThirdLargestInArray {
public static int getThirdLargest(int[] a) {
	int temp;
		for(int i=0;i<a.length;i++) {
			for (int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					temp = a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		return a[a.length-2];
}
public static void main(String[] args)  {  
	int a[]= {5,3,1,4};
	System.out.println("Third largest: " +getThirdLargest(a));
  } 
}
//3,5,1,4(i=0,j=1)
//1,5,3,4(i=0,j=2)
//1,5,3,4(i=0,j=3)
//1,3,5,4(i=1,j=2)
//1,3,5,4 (i=1,j=3)
//1,3,4,5(i=2,j=3)
//(i=3,j=4)
