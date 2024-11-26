import java.util.Scanner;

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.println("7. Calculate Interest");
            System.out.println("8. Save Transaction History");
            System.out.println("9. Load Account from File");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        String accNumber = scanner.next();
                        System.out.print("Enter Account Holder Name: ");
                        String accName = scanner.next();
                        System.out.print("Enter Initial Deposit: ");
                        double initialDeposit = scanner.nextDouble();
                        account = new SavingsAccount(accNumber, accName, initialDeposit);
                        System.out.println("Account created successfully!");
                        break;
                    case 2:
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful!");
                        break;
                    case 3:
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        System.out.println("Withdrawal successful!");
                        break;
                    case 4:
                        System.out.println("Current Balance: $" + account.getBalance());
                        break;
                    case 5:
                        account.displayTransactions();
                        break;
                    case 6:
                        System.out.println("Exiting the system. Goodbye!");
                        scanner.close();
                        return;
                    case 7:
                        System.out.print("Enter the number of months to calculate interest: ");
                        int months = scanner.nextInt();
                        if (account instanceof SavingsAccount) {
                            ((SavingsAccount) account).calculateInterest(months);
                        } else {
                            System.out.println("Interest calculation is only available for Savings Accounts.");
                        }
                        break;
                    case 8:
                        System.out.print("Enter filename to save transactions: ");
                        String saveFile = scanner.next();
                        account.saveTransactionHistory(saveFile);
                        break;
                    case 9:
                        System.out.print("Enter filename to load account details: ");
                        String loadFile = scanner.next();
                        account = BankAccount.loadAccountFromFile(loadFile);
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
