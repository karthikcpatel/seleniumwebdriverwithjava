package programs;

public class DuplicateInArray{
	public static void main(String args[]) {
		String names[]={"kartik","dipika","payal","kartik","tvisha"};
		for(int i=0;i<names.length;i++) {
			for(int j=i+1;j<names.length;j++) {
				if(names[i]==names[j]) {
					System.out.println("The deplicate elements in array are: " +names[i]);
				}
			}
		}
	}
}