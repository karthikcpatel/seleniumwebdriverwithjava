package programs;

public class VowelConsonantInString {
	
	public static void main(String args[]) {
		int v=0, cn=0;
		String str = "kartik".toLowerCase();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u') {
				v++;
			}
			else 
			{
				cn++;
			}
		}
		System.out.println("Vowels Count: " +v);
		System.out.println("Consonant Count: " +cn);
	}

}
