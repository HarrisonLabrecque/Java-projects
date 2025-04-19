import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        String playAgain;

        do {
            int randomNumber = random.nextInt(51); // 0 to 50 inclusive
            int guess;
            int count = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the number guessing game!!");
            System.out.println("Guess a number between 0 and 50");

            while (count < 5) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();

                if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else if (guess < randomNumber) {
                    System.out.println("Too low!!");
                } else {
                    System.out.println("That is the number!");
                    guessedCorrectly = true;
                    break;
                }

                count++;
            }

            if (!guessedCorrectly) {
                System.out.println("You have run out of chances.");
                System.out.println("The number I was thinking of was " + randomNumber);
            }

            System.out.print("Would you like to play again? (Y/N): ");
            sc.nextLine(); // Consume leftover newline
            playAgain = sc.nextLine();

        } while (playAgain.equalsIgnoreCase("Y"));

        sc.close();
        System.out.println("Thanks for playing!");
    }
}
