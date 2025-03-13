public class TimeDepositAccount extends Account {
    @Override
    public void deposit(double amount) {
        balance += amount;
    }
}