public class Savings extends Bank {
    private double interestRate;

    public Savings() {
        super();
        interestRate = 0.0;
    }

    public Savings(double rate) {
        super();
        interestRate = rate;
    }

    public Savings(String name) {
        super(name);
        interestRate = 0.0;
    }

    public Savings(String name, double bal) {
        super(name, bal);
        interestRate = 0.0;
    }

    public Savings(String name, double bal, double rate) {
        super(name, bal);
        interestRate = rate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double rate) {
        interestRate = rate;
    }

    public int getMonthsUntilGoal(double goal) {
        int months = 0;
        double balance = getBalance();
        while (balance < goal) {
            double interest = balance * interestRate / 12;
            balance += interest;
            months++;
        }
        return months;
    }
}
