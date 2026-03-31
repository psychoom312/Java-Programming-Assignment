class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        super("Withdrawal failed! Insufficient balance.");
        this.amount = amount;
    }

    public double getDeficit() {
        return amount;
    }
}

class BankAccount {
    private String accNo;
    private double balance;

    public BankAccount(String accNo, double initialBalance) {
        this.accNo = accNo;
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        System.out.println("Attempting to withdraw: " + amount);
        if (amount > balance) {
            double shortBy = amount - balance;
            throw new InsufficientFundsException(shortBy);
        }
        balance -= amount;
        System.out.println("Withdrawal Successful. New Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("BAC123", 500.00);

        try {
            myAccount.withdraw(200.00);
            myAccount.withdraw(800.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception Caught: " + e.getMessage());
            System.out.println("Current Shortfall: " + e.getDeficit());
        } finally {
            System.out.println("Final Account Balance: " + myAccount.getBalance());
            System.out.println("Transaction Process Finished.");
        }
    }
}
