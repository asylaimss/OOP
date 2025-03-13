public class AbstractBankingMain {
    public static void main(String[] args) {
        Account account = new TimeDepositAccount();
        account.deposit(1000);
        System.out.println("Deposit successful");
    }
}