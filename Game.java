import java.util.Scanner;

public class Game {
    private Player player;
    private Secret secret;
    private int attempts;

    public Game() {
        player = new Player();
        secret = new Secret();
        attempts = 6;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");

        while (attempts > 0 && !secret.isSolved()) {
            System.out.println("\nWord: " + secret.getRevealedWord());
            System.out.println("Attempts left: " + attempts);
            System.out.print("Enter a letter: ");
            String guess = scanner.nextLine();

            if (guess.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guessedChar = guess.charAt(0);

            if (player.hasGuessed(guessedChar)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            player.addGuess(guessedChar);

            if (secret.checkGuess(guessedChar)) {
                System.out.println("Correct guess!");
            } else {
                System.out.println("Wrong guess!");
                attempts--;
            }
        }

        if (secret.isSolved()) {
            System.out.println("You won! Congragulations! ");
        } else {
            System.out.println("You lost! The correct word was: " + secret.getWord());
        }

        scanner.close();
    }
}