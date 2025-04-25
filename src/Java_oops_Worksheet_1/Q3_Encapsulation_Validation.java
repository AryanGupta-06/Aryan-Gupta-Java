package Java_oops_Worksheet_1;

import java.util.Scanner;

public class Q3_Encapsulation_Validation {
    private String accountHolder;
    private double balance;
    private String accountNumber;

    // Constructor
    public Q3_Encapsulation_Validation(String accountHolder, double balance, String accountNumber) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    // Getter for accountHolder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Setter for accountHolder
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance with validation to prevent setting a negative balance
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Error: Balance cannot be negative.");
        }
    }

    // Getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter for accountNumber
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Q3_Encapsulation_Validation account = new Q3_Encapsulation_Validation(accountHolder, balance, accountNumber);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Account Number: " + account.getAccountNumber());

        System.out.print("Enter new balance: ");
        double newBalance = scanner.nextDouble();
        account.setBalance(newBalance);

        System.out.println("Updated Balance: " + account.getBalance());

        scanner.close();
    }
}
