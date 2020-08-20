package programs;

public class PalindromeString {

	public static void main(String args[]) {
		String str = "rotator";
		int start = 0;
		int end = str.length()-1;
		boolean isPalindrome = true;
		while(start < end) {
			if(str.charAt(start)!=str.charAt(end)) {
				isPalindrome = false;
				break;
			}
			start++;
			end--;
		}
		if(isPalindrome) {
			System.out.println("The number is palindrome");
		}
		else {
			System.out.println("The number is not a palindrome");
		}
	}
	
}
