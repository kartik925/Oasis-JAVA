import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int MAX_ATTEMPTS = 10; // Maximum attempts allowed
    private static int totalScore = 0; // Total score across rounds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thanks for playing! Your final score: " + totalScore);
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("\nWelcome to Guess the Number!");
        System.out.println("I have generated a number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts to guess it.");

        while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
            System.out.print("Enter your guess (1-100): ");
            int userGuess = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            attempts++;
            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please guess a number within the range of 1 to 100.");
                attempts--; // Do not count invalid guesses
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number: " + numberToGuess);
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry! You've used all your attempts. The number was: " + numberToGuess);
        }

        // Calculate score based on attempts
        int score = (MAX_ATTEMPTS - attempts) * 10;
        totalScore += score; // Update total score
        System.out.println("Your score for this round: " + score);
    }
}
