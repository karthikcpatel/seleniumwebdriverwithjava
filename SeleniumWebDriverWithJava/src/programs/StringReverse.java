package programs;

public class StringReverse {
public static void main(String args[]){
String str = "Hello World";
String revString = "";
for(int i=str.length()-1;i>=0;i--){
revString = revString + str.charAt(i);
}
System.out.println(revString);
}
}

//dlroW olleH
//11-1

