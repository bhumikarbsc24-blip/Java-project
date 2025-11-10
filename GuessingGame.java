import javax.swing.JOptionPane;
public class GuessingGame {
      public static void main(String[] args) {
      int totalGames = 0;
        int totalTries = 0;
        int bestScore = Integer.MAX_VALUE;

        JOptionPane.showMessageDialog(null,
            " Welcome to the Guessing Game!\nTry to guess the number between 1 and 100.",
            "Guessing Game", JOptionPane.INFORMATION_MESSAGE);

        boolean playAgain = true;

        while (playAgain) {
            int number = (int)(Math.random() * 100 + 1); // secret number
            int guess = 0;
            int tries = 0;

while (guess != number) {
                String input = JOptionPane.showInputDialog("Enter your guess between 1 and 100:");

                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game cancelled. ");
                    return;
                }

try {
                    guess = Integer.parseInt(input);
                    tries++;

                    if (guess < 1 || guess > 100) {
                        JOptionPane.showMessageDialog(null, " Please enter a number between 1 and 100.");
                    } 
                    else if (guess < number) {
                        JOptionPane.showMessageDialog(null, " Too low! Try again. (Try " + tries + ")");
                    } 
                    else if (guess > number) {
                        JOptionPane.showMessageDialog(null, " Too high! Try again. (Try " + tries + ")");
                    } 

