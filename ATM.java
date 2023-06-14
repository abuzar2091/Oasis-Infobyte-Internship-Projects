import java.util.Scanner;

public class ATM {

    private int balance;

    public ATM() {
        this.balance = 1000;
    }

    public void withdraw(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is " + this.balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(int amount) {
        this.balance += amount;
        System.out.println("Deposit successful. Your new balance is " + this.balance);
    }

    public void checkBalance() {
        System.out.println("Your balance is " + this.balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ATM atm = new ATM();

        while (true) {
            System.out.println("Welcome to the ATM. What would you like to do?");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check balance");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount you would like to withdraw: ");
                    int amount = scanner.nextInt();
                    atm.withdraw(amount);
                    break;
                case 2:
                    System.out.println("Enter the amount you would like to deposit: ");
                    amount = scanner.nextInt();
                    atm.deposit(amount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
