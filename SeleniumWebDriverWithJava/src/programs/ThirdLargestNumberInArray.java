package programs;

public class ThirdLargestNumberInArray {
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
		return a[a.length-3];
}
public static void main(String[] args)  {  
	int a[]= {77,66,55,99,88,44,100};
	System.out.println("Third largest:" +getThirdLargest(a));
  } 
}
