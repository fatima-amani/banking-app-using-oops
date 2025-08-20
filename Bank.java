import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private final ArrayList<Account> accounts;

    Bank() {
        accounts = new ArrayList<>();
    }

    public SavingsAccount openAccount(String accountType, String accountHolderName, double balance) {
        try {
            if (balance < 0) {
                throw new IllegalArgumentException("Balance cannot be negative");
            }
            if (accountType.equals("savings")) {
                String accountNumber = getAccountNumber();
                SavingsAccount newAccount = new SavingsAccount(accountNumber, accountHolderName, balance);
                accounts.add(newAccount);
                return newAccount;
            } else {
                throw new IllegalArgumentException("Invalid account type " + accountType);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public CheckingAccount openAccount(String accountType, String accountHolderName, double balance,
            double overdraftLimit) {
        try {
            if (accountType.equals("checking")) {
                String accountNumber = getAccountNumber();
                CheckingAccount newAccount = new CheckingAccount(accountNumber, accountHolderName, balance,
                        overdraftLimit);
                accounts.add(newAccount);
                return newAccount;
            } else {
                throw new IllegalArgumentException("Invalid account type " + accountType);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Account closeAccount(String accountNumber) {
        try {
            for (Account account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    System.out.println("Closing Account: ");
                    account.displayAccountInfo();
                    accounts.remove(account);
                    return account;
                }
            }
            throw new RuntimeException("Account does not exist or already closed");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Account findAccount(String accountNumber) {
        try {
            for (Account account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    System.out.println("Account Details: ");
                    account.displayAccountInfo();
                    return account;
                }
            }
            throw new RuntimeException("Account does not exist");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void displayAllAccounts() {
        System.out.println("All Account Details: ");
        for (Account account : accounts) {
            account.displayAccountInfo();
        }
    }

    private String getAccountNumber() {
        Random random = new Random();
        return (random.nextInt(900000000) + 100000000) + "";
    }

    public void setInterestRate(double interest) {
        SavingsAccount.setInterestRate(interest);
    }

}
