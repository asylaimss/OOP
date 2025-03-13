public class SingletonBankingMain {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        bank1.addCustomer();
        bank1.addCustomer();

        System.out.println("Number of customers: " + bank2.getNumberOfCustomers());

        if (bank1 == bank2) {
            System.out.println("Both references point to the same instance");
        }
    }
}