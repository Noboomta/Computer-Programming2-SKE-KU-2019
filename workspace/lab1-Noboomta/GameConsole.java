import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Console of the game.
 * @author Puvana Swatvanith; 6210545734; Github - NoBoomTa
 */
public class GameConsole{
    /**
     * The play method play game using input for user
     * @param ans the ans of guess
     * @return ans the ans of guess
     */
    public int play(GuessingGame game){
        System.out.println("Guess a secret number");
        /** Initialize the ans to be 0 for beginning. */
        int ans = 0;
        String str = "";
        String err = "Please input an integer";
        /** Initialize the run to modify loop. */
        boolean run = false;
        Scanner input = new Scanner(System.in);
        while(!run){
            System.out.println("Your Guess? ");
            try{
                str = input.nextLine();
                ans = Integer.parseInt(str);
                run = game.guess(ans);
            }
            catch(NoSuchElementException e){
                System.exit(0);
            }
            catch(NumberFormatException ex){
                System.out.println(err);
            }
        }
        return ans;
    }
}