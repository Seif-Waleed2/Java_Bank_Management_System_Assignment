import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactions;

    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with initial deposit: $" + initialDeposit);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds!");
        }
        balance -= amount;
        transactions.add("Withdrew: $" + amount);
    }

    public void displayTransactions() {
        System.out.println("Transaction History for " + accountHolderName + ":");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void saveTransactionHistory(String filename) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {
            for (String transaction : transactions) {
                writer.write(transaction + "\n");
            }
            System.out.println("Transaction history saved to " + filename);
        } catch (java.io.IOException e) {
            System.out.println("Error saving transaction history: " + e.getMessage());
        }
    }

    public static BankAccount loadAccountFromFile(String filename) {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filename))) {
            String accountNumber = reader.readLine();
            String accountHolderName = reader.readLine();
            double balance = Double.parseDouble(reader.readLine());

            BankAccount account = new SavingsAccount(accountNumber, accountHolderName, balance);
            String transaction;
            while ((transaction = reader.readLine()) != null) {
                account.transactions.add(transaction);
            }

            System.out.println("Account successfully loaded from " + filename);
            return account;
        } catch (java.io.IOException e) {
            System.out.println("Error loading account: " + e.getMessage());
        }
        return null;
    }
}
