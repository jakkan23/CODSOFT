import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1; // Change this for a different minimum range
        int maxRange = 100; // Change this for a different maximum range
        int maxAttempts = 5; // Change this for a different number of attempts allowed
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nRound " + (rounds + 1) + ". Guess the number between "
                    + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts.");

            int attempts = 0;
            boolean guessed = false;
            while (attempts < maxAttempts && !guessed) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in "
                            + attempts + " attempt(s)!");
                    guessed = true;
                    score++;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("Oops! You've used all your attempts. The number was: " + randomNumber);
            }

            rounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }
}
