/**
 * Main of the all system
 * @author Puvana Swatvanith; 6210545734; Github - NoBoomTa
 */
public class Main{
    /**
     * initialize the game, by EchoGame, and ui to be GameSolver.
     * @param args the arg which written behind the Main while compile and run.
     */
    public static void main(String[] args){

        int bound = 100; //default value

        if(args.length > 0 ){
            bound = Integer.parseInt(args[0]);
        }

        EchoGame game = new EchoGame(bound);
        GameConsole ui = new GameConsole();
        int solution = ui.play(game);
        
        if (solution != 0){
            System.out.println("You've guessed for " + game.getCount() + "Times");
            System.out.println("Right! The secret number is " + solution);
        }
    }
}
