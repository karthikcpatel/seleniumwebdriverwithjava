package programs;

public class FibonacciSeries {
public static void main(String args[]){
int prev, next, sum, i;
prev=next=1;
for(i=0;i<10;i++){
System.out.println(prev);
sum=prev+next;
prev=next;
next=sum;
}
}
}
