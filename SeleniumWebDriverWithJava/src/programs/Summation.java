package programs;

public class Summation {
public static void main(String args[]) {
	int n = 50;
	int sum = 0;
		for(int i=1;i<=n;i++) {
			sum = sum +i;
		}
		System.out.println("The summation of " +n+ " is " +sum);
}
}