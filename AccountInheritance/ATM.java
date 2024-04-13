import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter starting credit card account balance: ");
        double creditCardBalance = scanner.nextDouble();

        System.out.print("Enter starting savings account balance: ");
        double savingsBalance = scanner.nextDouble();

        System.out.print("Enter starting checking account balance: ");
        double checkingBalance = scanner.nextDouble();

        System.out.print("Enter credit card APR: ");
        double creditCardAPR = scanner.nextDouble();

        System.out.print("Enter checking overdraft fee: ");
        double checkingOverdraftFee = scanner.nextDouble();

        System.out.print("Enter savings interest rate: ");
        double savingsInterestRate = scanner.nextDouble();

        Credit creditCardAccount = new Credit(creditCardBalance, creditCardAPR);
        Checking checkingAccount = new Checking(name, checkingBalance, checkingOverdraftFee);
        Savings savingsAccount = new Savings(name, savingsBalance, savingsInterestRate);

        System.out.println("Credit Card Account:");
        System.out.println(creditCardAccount.toString());

        System.out.println("Checking Account:");
        System.out.println(checkingAccount.toString());

        System.out.println("Savings Account:");
        System.out.println(savingsAccount.toString());

        int option = 0;
        while (option != 4) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Credit Card");
            System.out.println("2. Checking");
            System.out.println("3. Savings");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    int creditCardOption = 0;
                    while (creditCardOption != 5) {
                        System.out.println("\nCredit Card Menu:");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Make Purchase");
                        System.out.println("3. Display Monthly Statement");
                        System.out.println("4. Create Monthly Payments");
                        System.out.println("5. Back to Main Menu");

                        System.out.print("Enter your choice: ");
                        creditCardOption = scanner.nextInt();

                        switch (creditCardOption) {
                            case 1:
                                System.out.println("Credit Card Balance: $" + creditCardAccount.getBalance());
                                break;
                            case 2:
                                System.out.print("Enter purchase amount: ");
                                double purchaseAmount = scanner.nextDouble();
                                creditCardAccount.makePurchase(purchaseAmount);
                                break;
                            case 3:
                                System.out.println(creditCardAccount.getMonthlyStatement());
                                break;
                            case 4:
                                creditCardAccount.createMonthlyPayments();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                    break;
                case 2:
                    int checkingOption = 0;
                    while (checkingOption != 4) {
                        System.out.println("\nChecking Menu:");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Deposit");
                        System.out.println("4. Back to Main Menu");

                        System.out.print("Enter your choice: ");
                        checkingOption = scanner.nextInt();

                        switch (checkingOption) {
                            case 1:
                                System.out.println("Checking Account Balance: $" + checkingAccount.getBalance());
                                break;
                            case 2:
                                System.out.print("Enter withdrawal amount: ");
                                double withdrawalAmount = scanner.nextDouble();
                                checkingAccount.withdraw(withdrawalAmount);
                                break;
                            case 3:
                                System.out.print("Enter deposit amount: ");
                                double depositAmount = scanner.nextDouble();
                                checkingAccount.deposit(depositAmount);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                    break;
                case 3:
                    int savingsOption = 0;
                    while (savingsOption != 5) {
                        System.out.println("\nSavings Menu:");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Deposit");
                        System.out.println("4. Display Months until Goal");
                        System.out.println("5. Back to Main Menu");

                        System.out.print("Enter your choice: ");
                        savingsOption = scanner.nextInt();

                        switch (savingsOption) {
                            case 1:
                                System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());
                                break;
                            case 2:
                                System.out.print("Enter withdrawal amount: ");
                                double withdrawalAmount = scanner.nextDouble();
                                savingsAccount.withdraw(withdrawalAmount);
                                break;
                            case 3:
                                System.out.print("Enter deposit amount: ");
                                double depositAmount = scanner.nextDouble();
                                savingsAccount.deposit(depositAmount);
                                break;
                            case 4:
                                System.out.print("Enter savings goal: ");
                                double savingsGoal = scanner.nextDouble();
                                System.out.println(
                                        "Months until Goal: " + savingsAccount.getMonthsUntilGoal(savingsGoal));
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
