import java.util.Scanner;
import java.util.InputMismatchException;
public class guess_game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("************** WELCOME **************");
        System.out.println(" *********** Let's begin ***********");

        int upper = 0;
        while (true) {
            try {
                System.out.print("Enter the upper limit for the number you want to guess: ");
                upper = in.nextInt();
                if (upper > 0) break;
                else System.out.println("Please enter a positive number.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.next(); // Clear the invalid input
            }
        }
        double guess;
        int guess1=0;
        double answer = (int) (Math.random() * upper) + 1;
        System.out.println("Now guess a number in the range 1 to " + upper);
        int count = 0, k = 0;
        boolean guessedRight = false;


        while (count < 10) {
            try {
                System.out.print("Enter your guess: ");
                guess = in.nextInt();  // Accept user input
                count++;

                if (guess == answer) {
                    System.out.println("\nCongratulations! You guessed it right!");
                    System.out.println("You got it in " + count + " guesses!");
                    guessedRight = true;
                    break;
                } else if (guess < answer) {
                    System.out.println("Try a greater number.");
                } else {
                    System.out.println("Try a smaller number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                in.next();  // Clear invalid input
            }
        }

        if (!guessedRight) {
            System.out.println("Sorry you used all the 10 guesses ):");
            System.out.println("The number was: " + answer);
        }
    }
    }

