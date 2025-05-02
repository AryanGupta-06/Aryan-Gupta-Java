package Java_collections_worksheet_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Transaction {
    private String transactionId;
    private Date transactionTime;
    private double amount;

    public Transaction(String transactionId, Date transactionTime, double amount) {
        this.transactionId = transactionId;
        this.transactionTime = transactionTime;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionTime=" + transactionTime +
                ", amount=" + amount +
                '}';
    }
}

public class Q10_Bank_Transaction_Log {
    private Map<String, List<Transaction>> transactionLog;

    public Q10_Bank_Transaction_Log() {
        transactionLog = new HashMap<>();
    }

    public void addTransaction(String accountNumber, Transaction transaction) {
        transactionLog.computeIfAbsent(accountNumber, k -> new ArrayList<>()).add(transaction);
    }

    public List<Transaction> getTransactions(String accountNumber, Date startDate, Date endDate) {
        List<Transaction> transactions = transactionLog.getOrDefault(accountNumber, new ArrayList<>());
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (!transaction.getTransactionTime().before(startDate) && !transaction.getTransactionTime().after(endDate)) {
                filteredTransactions.add(transaction);
            }
        }
        filteredTransactions.sort(Comparator.comparing(Transaction::getTransactionTime));
        return filteredTransactions;
    }

    public void printStatement(String accountNumber, Date startDate, Date endDate) {
        List<Transaction> transactions = getTransactions(accountNumber, startDate, endDate);
        System.out.println("Statement for Account: " + accountNumber);
        System.out.println("From: " + startDate + " To: " + endDate);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        Q10_Bank_Transaction_Log bankTransactionLog = new Q10_Bank_Transaction_Log();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Transaction");
            System.out.println("2. Generate Statement");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter transaction ID: ");
                    String transactionId = scanner.nextLine();
                    System.out.print("Enter transaction date (dd-MM-yyyy): ");
                    String dateStr = scanner.nextLine();
                    System.out.print("Enter transaction amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    try {
                        Date transactionDate = dateFormat.parse(dateStr);
                        Transaction transaction = new Transaction(transactionId, transactionDate, amount);
                        bankTransactionLog.addTransaction(accountNumber, transaction);
                        System.out.println("Transaction added successfully.");
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter start date (dd-MM-yyyy): ");
                    String startDateStr = scanner.nextLine();
                    System.out.print("Enter end date (dd-MM-yyyy): ");
                    String endDateStr = scanner.nextLine();

                    try {
                        Date startDate = dateFormat.parse(startDateStr);
                        Date endDate = dateFormat.parse(endDateStr);
                        bankTransactionLog.printStatement(accountNumber, startDate, endDate);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
