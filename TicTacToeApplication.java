/**
 * Contains the main method. Creates a ConsoleRunner and then calls its
 * mainLoop method.
 *
 * @author Marcus Ford
 */

public class TicTacToeApplication {

    public static void main(String[] args) 
    {
        ConsoleRunner newGame = new ConsoleRunner();
        newGame.mainLoop();
    }
}
