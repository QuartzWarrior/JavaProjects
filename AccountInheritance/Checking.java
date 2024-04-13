public class Checking extends Bank {
    private double fee;

    public Checking() {
        super();
        fee = 0.0;
    }

    public Checking(double balance, double f) {
        super(balance);
        fee = f;
    }

    public Checking(String name, double balance, double f) {
        super(name, balance);
        fee = f;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double f) {
        fee = f;
    }

    public void withdraw(double amount) {
        super.withdraw(amount);
        if (getBalance() < 0) {
            setBalance(getBalance() - fee);
        }
    }

    public String toString() {
        return super.toString() + "\nFee: $" + fee;
    }
}
