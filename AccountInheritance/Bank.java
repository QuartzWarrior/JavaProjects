public class Bank extends Account {
    private String accountName;

    public Bank() {
        super();
        accountName = "Unknown";
    }

    public Bank(String name) {
        super();
        accountName = name;
    }

    public Bank(double bal) {
        super(bal);
        accountName = "Unknown";
    }

    public Bank(String name, double bal) {
        super(bal);
        accountName = name;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String name) {
        accountName = name;
    }

    public String toString() {
        return super.toString() + "\nAccount Name: " + accountName;
    }

    public void deposit(double amount) {
        addMoney(amount);
    }

    public void withdraw(double amount) {
        if (amount > getBalance() && (this instanceof Savings)) {
            System.out.println("Insufficient funds.");
            return;
        }
        removeMoney(amount);
    }
}
