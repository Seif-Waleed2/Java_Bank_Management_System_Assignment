
# Java Bank Management System

## Overview
The Java Bank Management System is a simple console-based application that allows users to create bank accounts, deposit and withdraw money, view transaction history, and perform additional functionalities like calculating interest and saving/loading account details to/from files. This project demonstrates the application of core Java principles such as **Object-Oriented Programming (OOP)**, **Exception Handling**, and **Collections**.

---

## Features

### 1. **Account Management**
- Create a bank account with an account number, account holder name, and an initial deposit.
- Check the current balance of the account.

### 2. **Deposits and Withdrawals**
- Deposit money into the account.
- Withdraw money from the account while ensuring that the account has sufficient balance. 
- Handle errors gracefully with a custom exception `InsufficientFundsException`.

### 3. **Transaction History**
- Track and display all transactions (deposits, withdrawals) performed on the account.

### 4. **Interest Calculation (Savings Account)**
- Calculate interest on savings accounts based on a fixed annual interest rate.
- Add the calculated interest to the account balance for a given period in months.

### 5. **File Handling**
- Save transaction history to a text file for later review.
- Load account details (account number, holder name, balance, and transactions) from a file to restore previous states.

### 6. **Menu-Based Interface**
- The user can interact with the system through a simple menu interface, which offers various options:
    - Create an account
    - Deposit or withdraw money
    - Check balance
    - View transaction history
    - Calculate interest
    - Save and load data from files

---

## Design

### Class Breakdown

- **`BankAccount`**: This is the base class for managing a bank account. It stores the account number, holder name, balance, and transaction history. It includes methods for deposit, withdrawal, transaction history, and saving/loading account data to/from a file.
  
- **`SavingsAccount`**: A subclass of `BankAccount` that adds functionality for calculating interest and enforcing a minimum balance requirement for withdrawals.
  
- **`InsufficientFundsException`**: A custom exception that is thrown when a withdrawal request exceeds the available balance in the account.
  
- **`BankManagementSystem`**: The main class that provides a menu interface for the user to interact with the bank system. It manages user inputs and calls the appropriate methods on the `BankAccount` and `SavingsAccount` instances.

---

## Code Design Decisions

1. **Encapsulation**:
   - Fields in the `BankAccount` class are made private, with public getter methods. This ensures that the account data is protected and can only be modified through the class’s methods (e.g., `deposit` and `withdraw`).

2. **Inheritance**:
   - The `SavingsAccount` class extends `BankAccount`, inheriting its properties and methods while adding functionality for calculating interest and enforcing the minimum balance for withdrawals.

3. **Exception Handling**:
   - A custom exception (`InsufficientFundsException`) is used to handle errors related to insufficient balance during withdrawals, ensuring that the system behaves gracefully in error scenarios.

4. **File Handling**:
   - Transaction history is saved to a file, and account details can be loaded from a file. This makes the system persistent, allowing users to retain account information between sessions.

---

## Challenges and Solutions

### 1. **Handling Insufficient Funds**
   - **Challenge**: Ensuring that a withdrawal doesn't exceed the available balance while keeping the system robust.
   - **Solution**: Implemented custom exception handling (`InsufficientFundsException`) to alert the user when attempting to withdraw more money than the balance.

### 2. **File I/O for Persistence**
   - **Challenge**: Saving transaction history and loading account data from files posed a challenge in terms of formatting and ensuring data integrity.
   - **Solution**: Used `FileWriter` to save transactions to a text file and `BufferedReader` to load account data, making sure that all transactions were recorded correctly and loaded back into the system when required.

### 3. **Interest Calculation Logic**
   - **Challenge**: Ensuring that interest calculations are correct and consistent with the balance over a given time period.
   - **Solution**: Applied a fixed annual interest rate and calculated monthly interest. The interest is then added to the account balance.

### 4. **Menu-Driven User Interface**
   - **Challenge**: Designing a user-friendly, menu-driven interface in the console to make sure the program was easy to navigate.
   - **Solution**: The menu is simple and intuitive, with numbered options for different functionalities like creating accounts, checking balances, etc.

---

## Future Enhancements
- **More Account Types**: Add other account types like `CheckingAccount` with specific features (e.g., overdraft protection).
- **GUI Interface**: Transition from a console-based interface to a graphical user interface (GUI) using JavaFX or Swing for better user interaction.
- **Enhanced File Handling**: Implement better file management to ensure that accounts can be stored and retrieved securely.

---

## Running the Program

### Prerequisites
- Java Development Kit (JDK) 8 or later installed.
- A text editor or IDE (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code).

### Compilation and Execution
1. Compile all Java files:
   ```bash
   javac BankManagementSystem.java BankAccount.java SavingsAccount.java InsufficientFundsException.java
   ```

2. Run the main program:
   ```bash
   java BankManagementSystem
   ```

### Sample Output
```
Menu:
1. Create Account
2. Deposit
3. Withdraw
4. Check Balance
5. View Transaction History
6. Exit
7. Calculate Interest
8. Save Transaction History
9. Load Account from File
Enter your choice: 1
Enter Account Number: 12345
Enter Account Holder Name: Leo Sarkar
Enter Initial Deposit: 1000.0
Account created successfully!
```

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
