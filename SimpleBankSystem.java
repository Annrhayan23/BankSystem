import java.io.*;
import java.util.*;

// Class to represent a Bank Account
class BankAccount implements Serializable {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Display account details
    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Main class
public class SimpleBankSystem {
    private static final String FILE_NAME = "accounts.dat";
    private static Map<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        loadAccounts(); // Load saved accounts from file
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Simple Bank System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createAccount(sc);
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    checkBalance(sc);
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 6:
                    saveAccounts();
                    System.out.println("Exiting... Accounts saved.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    // Create a new account
    private static void createAccount(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        if (accounts.containsKey(accNum)) {
            System.out.println("Account already exists.");
            return;
        }
        System.out.print("Enter Account Holder Name: ");
        String holder = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine(); // consume newline

        BankAccount account = new BankAccount(accNum, holder, balance);
        accounts.put(accNum, account);
        System.out.println("Account created successfully!");
    }

    // Deposit money
    private static void deposit(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount account = accounts.get(accNum);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw money
    private static void withdraw(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount account = accounts.get(accNum);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Check balance
    private static void checkBalance(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount account = accounts.get(accNum);
        if (account != null) {
            account.display();
        } else {
            System.out.println("Account not found.");
        }
    }

    // Display all accounts
    private static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        for (BankAccount account : accounts.values()) {
            System.out.println("------------------------");
            account.display();
        }
    }

    // Save accounts to file
    private static void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    // Load accounts from file
    @SuppressWarnings("unchecked")
    private static void loadAccounts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (Map<String, BankAccount>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}
