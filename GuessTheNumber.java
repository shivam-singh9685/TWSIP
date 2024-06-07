import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit = 7;
        int totalAttempts = 0;
        int roundsWon = 0;
        
        System.out.println("Welcome to the Guess the Number Game!");
        
        boolean playAgain = true;
        
        while (playAgain) {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ".");
            
            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in " + attempts + " attempts!");
                    totalAttempts += attempts;
                    roundsWon++;
                    break;
                }
            }
            
            if (attempts == attemptsLimit) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thanks for playing! Your total score is based on the number of attempts taken or rounds won.");
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Rounds won: " + roundsWon);
        
        scanner.close();
    }
}
