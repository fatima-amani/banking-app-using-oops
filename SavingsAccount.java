public class SavingsAccount extends Account {
    private static double interestRate = 5;

    SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Balance before interest " + balance);
        System.out.println("Interest Rate is " + interestRate);
        balance += interest;
        System.out.println("Balance before interest " + balance);

        transactionHistory.add(new TransactionHistory("credit interest", interest, balance));

    }

    public static double setInterestRate(double rate) {
        try {
            if(rate > 100 || rate < 0) {
                throw new IllegalArgumentException("Interest rate is not valid");
            }
            interestRate = rate;
            return interestRate;
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return 0;
        }

    }
}
