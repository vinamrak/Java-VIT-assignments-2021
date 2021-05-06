package java_vit;
public class loan {
    
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /** Default constructor */
    public loan() {
    this(2.5, 1, 1000);
    }

    /** Construct a loan with specified annual interest rate,
     number of years, and loan amount
    */
    public loan(double annualInterestRate, int numberOfYears, double loanAmount) {
    setAnnualInterestRate(annualInterestRate);
    setNumberOfYears(numberOfYears);
    setLoanAmount(loanAmount);
    loanDate = new java.util.Date();
    }

    /** Return annualInterestRate */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /** Set an new annualInterestRate */
    public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException {
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Annual interest rate must be greater than 0");
        }
        this.annualInterestRate = annualInterestRate;
    }

    /** Return numberOfYears */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /** Set a new numberOfYears */
    public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException {
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Number of years must be greater than 0");
        }
        this.numberOfYears = numberOfYears;
    }

    /** Return loanAmount */
    public double getLoanAmount() {
        return loanAmount;
    }

    /** Set a new loanAmount */
    public void setLoanAmount(double loanAmount) throws IllegalArgumentException {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than 0");
        }
        this.loanAmount = loanAmount;
    }

    /** Find monthly payment */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /** Find total payment */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /** Return loan date */
    public java.util.Date getLoanDate() {
        return loanDate;
    }
}