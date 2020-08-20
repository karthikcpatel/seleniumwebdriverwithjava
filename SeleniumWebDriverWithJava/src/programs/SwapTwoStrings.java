package programs;

public class SwapTwoStrings {
	public static void main(String args[]) {
		String s1 = "Patel";
		String s2 = "Kartik";
		System.out.println(" ***** Before swapping ***** ");
		System.out.println("The value of s1 is : " +s1);
		System.out.println("The value of s1 is : " +s2);
		s1=s1+s2;//PatelKartik
		s2=s1.substring(0, s1.length()-s2.length());//Patel
		s1 = s1.substring(s2.length());//Kartik
		System.out.println(" ****** After swapping ****** ");
		System.out.println("The value of s1 is : " +s1);
		System.out.println("The value of s1 is : " +s2);
	}

}
