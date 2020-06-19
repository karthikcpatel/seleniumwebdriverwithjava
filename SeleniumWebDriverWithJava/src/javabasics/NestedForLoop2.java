package javabasics;

public class NestedForLoop2 {
	public static void main(String[] args) {    
		//int month=6;
		//int date=15;
		//int rows = 5;
		for (int month=1; month<=12; month++) {
			for (int day=1; day<=31; day++) {
				System.out.println(day);
			}
			System.out.println(month);
		}
	}
}
