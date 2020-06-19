package programs;

public class SwapTwoNumbers {
    public static void main(String[] args) {
    int number1=30;
    int number2=70;
    System.out.println("Before Swapping");
    System.out.println("Value of number1 is :" + number1);
    System.out.println("Value of number2 is :" +number2);
    number1=number1+number2;//num1=100
    number2=number1-number2;//number2=30
    number1=number1-number2;//100-30=70
    System.out.println("After Swapping");
    System.out.println("Value of number1 is :" + number1);
    System.out.println("Value of number2 is :" +number2);
    }
}
