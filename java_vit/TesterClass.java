package java_vit;
import java.util.*;

public class TesterClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter annual interest rate, for example, 8.25: ");
        double annualInterestRate = sc.nextDouble();

        System.out.println("Enter number of years as an integer: ");
        int numberOfYeras = sc.nextInt();

        System.out.println("Enter loan amount, for example, 120000: ");
        double loanAmount = sc.nextDouble();

        loan loan1 = new loan(annualInterestRate, numberOfYeras, loanAmount);

        System.out.println("The loan was created on " + loan1.getLoanDate().toString() + " The monthly payment is "
                + loan1.getMonthlyPayment() + "\nTne total payment is \n" + loan1.getTotalPayment());

        sc.close();
    }
}