package programs;

public class RemoveCharactersInString {
	public static void main(String args[]) {
		String str = "Hello! I am Kartik Patel,remove me";
		System.out.println("Before :" +str);
		str = str.replace("remove me", "").replaceAll(",",".");
		System.out.println("After: " +str);
	}

}
