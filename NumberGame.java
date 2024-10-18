import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int roundNum = 1;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Let's see how well you can guess the number. Ready?");

        while (true) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 6;

            System.out.println("\nRound " + roundNum + ":");
            System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;
                if (!scanner.hasNextInt()) {
                    System.out.println("Oops! That doesn't look like a number. Please try again.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                userGuess = scanner.nextInt();
                attempts++;
                System.out.println("You guessed: " + userGuess);

                if (userGuess == numberToGuess) {
                    System.out.println("Amazing! You got it in " + attempts + " attempts. Well done!");
                    score++;
                    break;
                } else if (userGuess < numberToGuess) {
                    if (Math.abs(userGuess - numberToGuess) <= 10) {
                        System.out.println("You're getting warmer, but it's still a little higher.");
                    } else {
                        System.out.println("Too low! Aim a bit higher.");
                    }
                } else {
                    if (Math.abs(userGuess - numberToGuess) <= 10) {
                        System.out.println("You're close! Just a bit lower.");
                    } else {
                        System.out.println("Too high! Try a lower number.");
                    }
                }
                if (attempts == maxAttempts - 1) {
                    System.out.println("This is your last chance! Make it count!");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Oh no, you didn't guess it this time. The correct number was " + numberToGuess + ".");
            }
            System.out.println("\nYou've won " + score + " round(s) so far.");
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing! Your final score is " + score + " round(s) won.");
                System.out.println("Come back soon and try to beat your score!");
                break;
            }

            roundNum++;
        }

        scanner.close();
    }
}
