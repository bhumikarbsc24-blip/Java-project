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
                    else {
                        JOptionPane.showMessageDialog(null,
                            " Correct! You got it in " + tries + " tries!\nThe secret number was: " + number,
                            "Winner!", JOptionPane.INFORMATION_MESSAGE);
                    }
                } 
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, " Please enter a valid number!");
                }
            }

            // Update scoreboard
            totalGames++;
            totalTries += tries;
            if (tries < bestScore) {
                bestScore = tries;
            }

            // Show scoreboard
            double average = (double) totalTries / totalGames;
            String scoreboard = " Scoreboard \n"
                + "Games Played: " + totalGames + "\n"
                + "Total Tries: " + totalTries + "\n"
                + "Average Tries: " + String.format("%.2f", average) + "\n"
                + "Best Score (Least Tries): " + bestScore;

            JOptionPane.showMessageDialog(null, scoreboard, "Scoreboard", JOptionPane.INFORMATION_MESSAGE);

            // Ask to play again
            int option = JOptionPane.showConfirmDialog(null,
                "Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);

            if (option != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,
                    "Thanks for playing! \n\nFinal Scoreboard:\n" + scoreboard,
                    "Goodbye!", JOptionPane.INFORMATION_MESSAGE);
                playAgain = false;
            }
        }
    }
}
