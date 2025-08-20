import java.util.ArrayList;

public class Account {
    protected final String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected ArrayList<TransactionHistory> transactionHistory;

    Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        System.out.println("Account has been created");
        displayAccountInfo();
    }


    public double deposit(double amount){
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0.");
            }

            balance += amount;
            System.out.println("Deposited " + amount + " to account " + accountNumber + " New balance is " + balance);

            transactionHistory.add(new TransactionHistory("credit", amount, balance));
            return this.balance;
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return 0;
        }
    }

    public double withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0.");
            }
            if (amount > this.balance) {
                throw new RuntimeException("Not enough Account Balance");
            }
            balance -= amount;
            System.out.println("Withdrew " + amount + " to account " + this.accountNumber + " New balance is " + this.balance);
            transactionHistory.add(new TransactionHistory("debit", amount, balance));
            return balance;
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return 0;
        }
    }

    public double getBalance() {
        System.out.println("Balance is " + this.balance);
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: "+ accountNumber);
        System.out.println("Account Holder Name: "+ accountHolderName);
        System.out.println("Account Balance: "+ balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void viewTransactionHistory() {
        System.out.println("-----Trasaction history for: "+ accountNumber+"---- \n");

        for (TransactionHistory transactionHistory : transactionHistory) {
            transactionHistory.displayTransactionHistory();
            System.out.println();
        }
    }
}