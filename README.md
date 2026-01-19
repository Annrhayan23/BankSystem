

# Simple Bank System

## Overview

The **Simple Bank System** is a console-based Java application that simulates basic banking operations. It allows users to create bank accounts, deposit and withdraw money, check balances, and display all accounts. All account data is saved to a file for persistence across program runs.

---

## Features

* Create multiple bank accounts with account number, holder name, and initial balance.
* Deposit money into an account.
* Withdraw money from an account with balance validation.
* Check account balance and details.
* Display all accounts in the system.
* Save account data to a file (`accounts.dat`) and load it on program start.

---

## Skills Used

* **Java Basics:** Variables, loops, conditionals, input/output
* **Object-Oriented Programming:** Classes, objects, encapsulation
* **Collections:** `HashMap` for storing multiple accounts
* **File I/O:** Saving and loading account data using `ObjectOutputStream` and `ObjectInputStream`
* **Serialization:** Persisting objects to a file

---

## Project Structure

```
SimpleBankSystem/
│
├── src/
│   └── SimpleBankSystem.java     <-- Main program and BankAccount class
│
├── data/
│   └── accounts.dat              <-- Stores account data (auto-generated)
│
└── README.md                     <-- Project description
```

---

## How to Run

1. **Compile the program**

```bash
javac SimpleBankSystem.java
```

2. **Run the program**

```bash
java SimpleBankSystem
```

3. **Use the menu options** to create accounts, deposit, withdraw, check balances, and display all accounts.

4. **Exit the program** to automatically save all account data to `accounts.dat`.

---

## Sample Menu

```
=== Simple Bank System ===
1. Create Account
2. Deposit
3. Withdraw
4. Check Balance
5. Display All Accounts
6. Exit
Enter your choice:
```

---

## Future Enhancements

* Add authentication with PIN for each account.
* Implement a graphical user interface (GUI).
* Add transaction history for each account.
* Support interest calculation for savings accounts.
* Integrate with a database instead of file-based storage.

---

