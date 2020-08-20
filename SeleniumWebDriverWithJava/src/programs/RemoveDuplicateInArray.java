package programs;

public class RemoveDuplicateInArray {
	public static void main(String args[]) {
		int arr[] = {1,2,2,3,4,5,6,7,8,9,10};
		int temp[] = new int[arr.length];
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1]) {
				temp[j++]=arr[i];
			}
		}
		temp[j++]=arr.length-1;
		for(int k=0;k<j;k++) {
			System.out.println(temp[k]);
		}
	}

}
