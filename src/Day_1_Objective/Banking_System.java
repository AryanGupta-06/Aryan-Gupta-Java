package Day_1_Objective;

import java.util.Scanner;

// Interface
interface IBankAccount {
    void deposit(double amount);
    void withdraw(double amount);
}

// Abstract Class
abstract class BankAccount implements IBankAccount {
    protected double balance;
    protected final String accountNumber;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance is " + balance + ".");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance is " + balance + ".");
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Concrete Classes
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
}

// Main Class
public class Banking_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Savings Account
        System.out.print("Enter Savings Account Number: ");
        String savingsAccountNumber = scanner.nextLine();
        System.out.print("Enter Initial Balance for Savings Account: ");
        double savingsInitialBalance = scanner.nextDouble();
        SavingsAccount savings = new SavingsAccount(savingsAccountNumber, savingsInitialBalance);

        // Create Current Account
        System.out.print("Enter Current Account Number: ");
        scanner.nextLine(); // Consume newline left-over
        String currentAccountNumber = scanner.nextLine();
        System.out.print("Enter Initial Balance for Current Account: ");
        double currentInitialBalance = scanner.nextDouble();
        CurrentAccount current = new CurrentAccount(currentAccountNumber, currentInitialBalance);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Deposit to Savings Account");
            System.out.println("2. Withdraw from Savings Account");
            System.out.println("3. Deposit to Current Account");
            System.out.println("4. Withdraw from Current Account");
            System.out.println("5. Display Balances");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount for Savings Account: ");
                    double savingsDepositAmount = scanner.nextDouble();
                    savings.deposit(savingsDepositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount for Savings Account: ");
                    double savingsWithdrawAmount = scanner.nextDouble();
                    savings.withdraw(savingsWithdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter deposit amount for Current Account: ");
                    double currentDepositAmount = scanner.nextDouble();
                    current.deposit(currentDepositAmount);
                    break;
                case 4:
                    System.out.print("Enter withdrawal amount for Current Account: ");
                    double currentWithdrawAmount = scanner.nextDouble();
                    current.withdraw(currentWithdrawAmount);
                    break;
                case 5:
                    System.out.println("Final Balance for Savings Account (" + savings.getAccountNumber() + "): " + savings.getBalance());
                    System.out.println("Final Balance for Current Account (" + current.getAccountNumber() + "): " + current.getBalance());
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
