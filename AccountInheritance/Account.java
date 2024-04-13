public class Account {
    private int accountID;
    private double balance;

    public Account() {
        accountID = (int) (Math.random() * 99999) + 1;
        balance = 0;
    }

    public Account(double bal) {
        accountID = (int) (Math.random() * 99999) + 1;
        balance = bal;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double bal) {
        balance = bal;
    }

    public void addMoney(double amount) {
        balance += amount;
    }

    public void removeMoney(double amount) {
        balance -= amount;
    }

    public String toString() {
        return "Account ID: " + accountID + "\nBalance: " + balance;
    }
}