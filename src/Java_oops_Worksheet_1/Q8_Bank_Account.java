package Java_oops_Worksheet_1;

public class Q8_Bank_Account {
    private String name;
    private double balance;
    private String type;

    // Constructor using 'this' keyword to resolve variable shadowing
    public Q8_Bank_Account(String name, double balance, String type) {
        this.name = name; // 'this.name' refers to the instance variable, 'name' refers to the parameter
        this.balance = balance; // 'this.balance' refers to the instance variable, 'balance' refers to the parameter
        this.type = type; // 'this.type' refers to the instance variable, 'type' refers to the parameter
    }

    // Method to update the balance using 'this' keyword
    public void updateBalance(double amount) {
        if (amount <= 0) {
            System.out.println("their cannot be negative value");
        }
        else {

            this.balance += amount; // 'this.balance' refers to the instance variable
        }
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Name: " + this.name);
        System.out.println("Account Balance: " + this.balance);
        System.out.println("Account Type: " + this.type);
    }

    public static void main(String[] args) {
        // Creating a Q8_Bank_Account object
        Q8_Bank_Account account = new Q8_Bank_Account("Aryan Gupta", 1000.0, "Savings");

        // Displaying initial account details
        account.displayAccountDetails();

        // Updating the balance
        account.updateBalance(500.0);

        // Displaying updated account details
        account.displayAccountDetails();
    }
}
