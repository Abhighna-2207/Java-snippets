import java.io.*;
import java.util.Scanner;

public class BankingSystem {
    private static final String ACCOUNT_FILE = "accounts.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }

    private static void createAccount() {
        System.out.println("\n=== Create Account ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        if (username.isEmpty() || accountExists(username)) {
            System.out.println("Invalid or existing username.\n");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.\n");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNT_FILE, true))) {
            writer.write(username + "," + password + ",0.0\n");
            System.out.println("Account created successfully!\n");
        } catch (IOException e) {
            System.out.println("Error creating account.\n");
        }
    }

    private static void login() {
        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        Account account = authenticate(username, password);
        if (account != null) {
            System.out.println("Login successful!\n");
            accountMenu(account);
        } else {
            System.out.println("Invalid username or password.\n");
        }
    }

    private static Account authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals(username) && parts[1].equals(password)) {
                    return new Account(username, password, Double.parseDouble(parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error during authentication.\n");
        }
        return null;
    }

    private static void accountMenu(Account account) {
        while (true) {
            System.out.println("=== Account Menu ===");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.printf("Current balance: $%.2f\n\n", account.getBalance());
                    break;
                case "2":
                    depositFunds(account);
                    break;
                case "3":
                    withdrawFunds(account);
                    break;
                case "4":
                    System.out.println("Logged out successfully.\n");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }

    private static void depositFunds(Account account) {
        System.out.print("Enter amount to deposit: $");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Amount must be positive.\n");
                return;
            }
            account.deposit(amount);
            updateAccount(account);
            System.out.printf("Deposited $%.2f successfully. New balance: $%.2f\n\n", amount, account.getBalance());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered.\n");
        }
    }

    private static void withdrawFunds(Account account) {
        System.out.print("Enter amount to withdraw: $");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Amount must be positive.\n");
                return;
            }
            if (account.withdraw(amount)) {
                updateAccount(account);
                System.out.printf("Withdrew $%.2f successfully. New balance: $%.2f\n\n", amount, account.getBalance());
            } else {
                System.out.println("Insufficient funds.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered.\n");
        }
    }

    private static boolean accountExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.split(",")[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error checking account existence.\n");
        }
        return false;
    }

    private static void updateAccount(Account updatedAccount) {
        File inputFile = new File(ACCOUNT_FILE);
        File tempFile = new File("temp_accounts.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(updatedAccount.getUsername())) {
                    writer.write(updatedAccount.getUsername() +  "," + updatedAccount.getBalance() + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating account.\n");
            return;
        }

        if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
            System.out.println("Error finalizing account update.\n");
        }
    }
}

// Account class
class Account {
    private final String username;
    private final String password;
    private double balance;

    public Account(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() { return username; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
