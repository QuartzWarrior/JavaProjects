public class Credit extends Account {
    private double apr;

    public Credit() {
        super();
        apr = 0;
    }

    public Credit(double bal, double rate) {
        super(bal);
        apr = rate;
    }

    public double getAPR() {
        return apr;
    }

    public void setAPR(double rate) {
        apr = rate;
    }

    public void makePurchase(double amount) {
        setBalance(getBalance() - amount);
    }

    public String getMonthlyStatement() {
        return "Credit Card Balance: $" + getBalance() + "\nAPR: " + apr;
    }

    public void createMonthlyPayments() {
        double interest = getBalance() * apr / 12;
        setBalance(getBalance() + interest);
    }

    public String toString() {
        return super.toString() + "\nAPR: " + apr;
    }
}
