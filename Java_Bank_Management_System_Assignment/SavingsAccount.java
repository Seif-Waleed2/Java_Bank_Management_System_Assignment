public class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 500.0;
    private static final double INTEREST_RATE = 0.03; // 3% annual interest

    public SavingsAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        super(accountNumber, accountHolderName, initialDeposit);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (getBalance() - amount < MINIMUM_BALANCE) {
            throw new InsufficientFundsException("Cannot withdraw! Minimum balance of $" + MINIMUM_BALANCE + " must be maintained.");
        }
        super.withdraw(amount);
    }

    public void calculateInterest(int months) {
        if (months <= 0) {
            System.out.println("Number of months must be greater than zero!");
            return;
        }
        double interest = getBalance() * (INTEREST_RATE / 12) * months;
        deposit(interest);
        System.out.println("Interest of $" + interest + " has been added for " + months + " months.");
    }
}
