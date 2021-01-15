/**
 * Automatically find the secret to any GuessingGame.
 *
 * @author Puvana Swatvanith; 6210545734; Github - NoBoomTa
 */
public class GameSolver {
    /**
     * Find the middle number
     */
    public int getMiddleNumber(int min, int max) {
        return (max + min) / 2;
    }

    /**
     * Play a GuessingGame and return the solution.
     * The game must provide message (getMessage) containing thire
     * phase "too small" if a guess is too small or "too large" if
     * a guess is too large, for efficient solution.
     *
     * @param game is the GuessingGame to solve
     * @return the secret number
     */
    public int play(GuessingGame game) {
        /** init run to be modify loop*/
        boolean run = true;
        /** init next ans*/
        int nextAns = game.getUpperBound() / 2;
        /** init round to count*/
        int lowerBound = 1;
        /** init the number to be last number for range of secret*/
        int upperBound = game.getUpperBound();
        /** init the game solver and will be used in the following loop. */
        String gameMessage = "";
        /** init the res to check the result*/
        boolean res = false;
        while (run) {
            // System.out.println(game.getMessage());
            nextAns = getMiddleNumber(lowerBound, upperBound);
            res = game.guess(nextAns);
            gameMessage = game.getMessage().toLowerCase();
            if (gameMessage.contains("small")) {
                lowerBound = nextAns + 1;
            }
            if (gameMessage.contains("large")) {
                upperBound = nextAns - 1;
            }
            if (res) {
                run = false;
            }
        }
        return nextAns;
    }
}