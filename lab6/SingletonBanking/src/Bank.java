public class Bank {
    private static final Bank instance = new Bank();
    private int numberOfCustomers;

    private Bank() {
        numberOfCustomers = 0;
    }

    public static Bank getInstance() {
        return instance;
    }

    public void addCustomer() {
        numberOfCustomers++;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }
}