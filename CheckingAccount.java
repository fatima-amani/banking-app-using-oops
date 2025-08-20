public class CheckingAccount extends Account {
    double overdraftLimit;

    CheckingAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double withdraw(double amount) {
        try {
            if (amount > balance + overdraftLimit) {
                throw new RuntimeException("Not enough Account Balance or Overdraft Limit");
            } else if (amount <= balance) {
                balance -= amount;
                transactionHistory.add(new TransactionHistory("debit", amount, balance));
            } else {
                amount -= balance;
                balance = 0;
                overdraftLimit -= amount;
                transactionHistory.add(new TransactionHistory("overdraft debit", amount, balance));

            }

            System.out.println("Withdrew " + amount + " from account " + this.accountNumber);
            System.out.println(" New balance is " + this.balance + " Overdraft Limit is " + this.overdraftLimit);

            return balance;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

}
