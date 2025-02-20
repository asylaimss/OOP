package models;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompil
public class DukeTransaction {
    private String productID;
    private String transactionType;
    private int count;

    public DukeTransaction(String productID, String transactionType, int count) {
        this.productID = productID;
        this.transactionType = transactionType;
        this.count = count;
    }

    public String getProductID() {
        return this.productID;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public int getCount() {
        return this.count;
    }
}
