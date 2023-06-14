import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int secretNumber = (int) (Math.random() * 100) + 1;
        int numberOfGuesses = 0;

        System.out.println("Welcome to the number guessing game! I'm thinking of a number between 1 and 100.");

        while (true) {
            System.out.println("What is your guess? ");
            int guess = scanner.nextInt();

            numberOfGuesses++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + numberOfGuesses + " guesses!");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }
        }

        System.out.println("Would you like to play again? (Y/N)");
        String playAgain = scanner.next();

        if (playAgain.equals("Y")) {
            main(args);
        } else {
            System.out.println("Thank you for playing!");
        }
    }
}
