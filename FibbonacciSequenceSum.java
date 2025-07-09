
import java.util.Scanner;


public class FibbonacciSequenceSum {
    public static void main(String[] args) {
        long fib0 = 0;
        long fib1 = 1;
        long sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter limit upto "+Long.MAX_VALUE);
        long limit = sc.nextLong();
        while(fib0<limit){
            System.out.println(" fib num "+fib0);
            long temp = fib0+fib1;
            if(fib0%2==0){
                sum = sum+fib0;
            }
            fib0 = fib1;
            fib1 = temp;

        }

        System.out.println("Sum is "+sum);


    }
}
