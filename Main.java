public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to Banking Service\n\n");

        Bank sbi = new Bank();

        SavingsAccount fatima = sbi.openAccount("savings", "Fatima",5000);
        System.out.println();
        CheckingAccount amna = sbi.openAccount("checking", "Amna", 500,10000);
        System.out.println();

//        savings
        fatima.deposit(5000);
        System.out.println();
        fatima.withdraw(1000);
        System.out.println();
        fatima.displayAccountInfo();
        System.out.println();
        fatima.applyInterest();
        System.out.println();
        fatima.getBalance();
        System.out.println();
        fatima.viewTransactionHistory();
        System.out.println();



//        checking
        amna.withdraw(5000);
        System.out.println();
        amna.deposit(7000);
        System.out.println();
        amna.displayAccountInfo();
        System.out.println();
        amna.getBalance();
        System.out.println();
        amna.viewTransactionHistory();
        System.out.println();

//        bank
        sbi.findAccount(amna.getAccountNumber());
        System.out.println();
        sbi.closeAccount(fatima.getAccountNumber());
        System.out.println();
        sbi.displayAllAccounts();
        System.out.println();
        sbi.setInterestRate(5);


        Bank hdfc = new Bank();

        SavingsAccount fatima2 = hdfc.openAccount("savings", "Fatima",123);
        System.out.println();
        CheckingAccount amna2 = hdfc.openAccount("checking", "Amna", 500,1000);
        System.out.println();

//        savings
        fatima2.deposit(-1);
        System.out.println();
        fatima2.withdraw(150);
        System.out.println();
        fatima2.displayAccountInfo();
        System.out.println();
        fatima2.applyInterest();
        System.out.println();
        fatima2.getBalance();
        System.out.println();
        fatima2.viewTransactionHistory();
        System.out.println();



//        checking
        amna2.withdraw(5000);
        System.out.println();
        amna2.withdraw(150);
        System.out.println();
        amna2.deposit(0);
        System.out.println();
        amna2.displayAccountInfo();
        System.out.println();
        amna2.getBalance();
        System.out.println();
        amna2.viewTransactionHistory();
        System.out.println();


//        banks
        hdfc.findAccount("abcd");
        System.out.println();
        hdfc.closeAccount("efgh");
        System.out.println();
        hdfc.displayAllAccounts();
        System.out.println();
        hdfc.setInterestRate(106);


    }
}

