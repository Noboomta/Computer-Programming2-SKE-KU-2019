/**
 * The class to shown out the number that guessed and the result of that number
 * by the (message) for example: too large, too small.
 * @author Puvana Swatvanith; 6210545734; Github - NoBoomTa
 */
public class EchoGame extends GuessingGame{

    /**
     * The constructor of the EchoGame
     * @param upperBound
     */
    public EchoGame(int upperBound){
        super(upperBound);
    }

    /**
     * The method guess which have to override, to guess the number and return the result.
     * @param number the number that guess by the computer.
     * @return result the boolean of checked ans
     */
    @Override
    public boolean guess(int number) {
        
        Boolean result = super.guess(number);
        System.out.printf("Guess = %d\n",number);
        System.out.printf("Message = %s\n",getMessage());
        // System.out.println("EEEEE");
        return result;
	}
}
