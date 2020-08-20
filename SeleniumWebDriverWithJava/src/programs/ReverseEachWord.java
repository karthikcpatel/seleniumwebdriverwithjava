package programs;

public class ReverseEachWord {
public static void main(String args[]) {
	String str = "Java Programming";
	String[] words = str.split("\\s");
	String revString = "";
	
	for(int i=0;i<words.length;i++) {
		String word = words[i];
		String revWord = "";
		
			for(int j=word.length()-1;j>=0;j--) {
				revWord = revWord + word.charAt(j);
			}
			revString = revString + revWord + " ";
	}
	System.out.println(revString);
}
}
