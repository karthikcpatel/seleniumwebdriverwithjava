package programs;

public class ReverseNumber {
    public static void main(String[] args) {
            int number = 1234;
            int reversedNumber = 0;
            int temp = number;
            while(number > 0){            
                    temp = number%10;            
                    number = number/10;
                    reversedNumber = reversedNumber * 10 + temp;                  
            }
            System.out.println("Reversed Number is: " + reversedNumber);
    }
}
