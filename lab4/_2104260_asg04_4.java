class BankAccount {
    String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: Rs" + balance);
    }

    protected double getBalance() {
        return balance; // Provide a getter for balance
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public void earnInterest() {
        double interest = getBalance() * interestRate / 100.0; 
        deposit(interest);
        System.out.println("Interest earned: Rs" + interest);
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }
}

public class _2104260_asg04_4 {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("S1111", "Rohit Garg", 1000.0, 3.5);
        CheckingAccount checkingAccount = new CheckingAccount("C2222", "Sachin Agarwal", 500.0);

        savingsAccount.displayAccountDetails();
        savingsAccount.deposit(500.0);
        savingsAccount.withdraw(200.0);
        savingsAccount.earnInterest();
        savingsAccount.displayAccountDetails();

        System.out.println("\n");

        checkingAccount.displayAccountDetails();
        checkingAccount.deposit(300.0);
        checkingAccount.withdraw(100.0);
        checkingAccount.displayAccountDetails();
    }
}
