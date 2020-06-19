package javabasics;

public class NestedForLoop {
	public static void main(String[] args) {    
		for (int i=1; i<=5; i++) {
			for (int j=i; j<=i; j++) {
				System.out.println(j);
			}
			System.out.println(i);
		}
	}
}
