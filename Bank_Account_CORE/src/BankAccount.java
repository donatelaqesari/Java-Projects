import java.util.Random;

public class BankAccount {
    private int totalAccounts;
    private Double checkingBalance;
    private Double savingsBalance;

    //class member (static) that has the number of accounts created thus far.
    private static int numberOfAccounts = 0;

    // class member (static) that tracks the total amount of money stored in every account created.
    private static Double totalAmount = 0.0;
    private String accountNumber;

    //In the constructor, be sure to increment the account count.
    public BankAccount() {
        this.checkingBalance = 0.0;
        this.savingsBalance = 0.0;
        String accountNumber = generateNumber();
        System.out.println("New user created with account number: " + accountNumber + ".");
        numberOfAccounts++;
    }

    //GETTERS
    public Double getCheckingBalance() {
        return this.checkingBalance;
    }

    public Double getSavingsBalance() {
        return this.savingsBalance;
    }

    //Create a method that will allow a user
    // to deposit money into either the checking or saving,
    // be sure to add to total amount stored.
    public void depositMoney(Double money, boolean addToCheckings) {
        if (addToCheckings) {
            this.checkingBalance += money;
        } else {
            this.savingsBalance += money;
        }
        totalAmount += money;
        System.out.println("New total amount is:" + totalAmount);
    }

    //Create a method to withdraw money from one balance.
    // Do not allow them to withdraw money if there are insufficient funds.
    public void withdrawMoney(Double money, boolean fromCheckings) {
        if (fromCheckings) {
            if (money > this.checkingBalance) {
                System.out.println("There are insufficient funds!");

            } else {
                this.checkingBalance -= money;
                totalAmount -= money;
                System.out.println("New savings:" + this.checkingBalance);
            }
        } else {
            if (money > this.savingsBalance) {
                System.out.println("There are insufficient funds!");

            } else {
                this.savingsBalance -= money;
                totalAmount -= money;
                System.out.println("New savings:" + this.savingsBalance);
            }

        }

    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    private String generateNumber() {
        String returnStr = "";
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            returnStr += r.nextInt(10);
        }
        return returnStr;
    }
}

