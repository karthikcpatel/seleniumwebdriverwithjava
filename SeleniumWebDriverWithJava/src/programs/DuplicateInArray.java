package programs;

public class DuplicateInArray{
	public static void main(String args[]) {
		//String names[]={"10","dipika","payal","kartik","tvisha","kartik"};
		int names[]={10,10,11,12,15,17,10};
		for(int i=0;i<names.length;i++) {
			for(int j=i+1;j<names.length;j++) {
				if(names[i]==names[j]) {
					System.out.println("The duplicate elements in array are: " +names[i]);
				}
			}
		}
	}
}