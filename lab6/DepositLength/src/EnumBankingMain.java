public class EnumBankingMain {
    public static void main(String[] args) {
        TimeDepositAccount account = new TimeDepositAccount(1000, DepositLength.SIX_MONTHS);
        System.out.println("Maturity date: " + account.getMaturityDate());
    }
}