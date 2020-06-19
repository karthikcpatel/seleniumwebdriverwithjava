package programs;

public class CountOccuranceOfWordInString 
{
			public static void main(String args[])
			{
			 String string = "My name is Kartik. My hometown is Dandi";
			 String word = "my";
			 String temp[] = string.split(" ");
			 int count = 0;
			 for (int i = 0; i < temp.length; i++) {
			 if (word.equalsIgnoreCase(temp[i])) 
			 count++;
			 }
			 System.out.println("The word " + word + " occurs " + count + " times in the above string");
			 }
		}

	