import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public final class TransactionHistory {
    private final String transactionId;
    private final String transactionDate;
    private final String transactionTime;
    private final String transactionType;
    private final double transactionAmount;
    private final double remainingBalance;

    TransactionHistory(String transactionType, double transactionAmount, double remainingBalance) {
        this.transactionId = UUID.randomUUID().toString();
        this.transactionDate = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
        this.transactionTime = Timestamp.valueOf(LocalDateTime.now()).toString();
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.remainingBalance = remainingBalance;
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction Details: ");
        System.out.print(" Transaction Id: " + transactionId);
        System.out.print(" Transaction Date: " + transactionDate);
        System.out.println(" Transaction Time: " + transactionTime);
        System.out.print(" Transaction Type: " + transactionType);
        System.out.print(" Transaction Amount: " + transactionAmount);
        System.out.print(" Remaining Balance: " + remainingBalance);
    }

}
