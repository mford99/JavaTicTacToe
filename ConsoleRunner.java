/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 *
 * @author Marcus Ford
 */

import java.util.Scanner;

public class ConsoleRunner {

    /**
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX;

    private Game game;
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor
     */
    public ConsoleRunner() 
    {    
        System.out.println("Do you want to play as X (Y/N): ");
        String PlayerCharacter = scanner.next();

        do
        {
            if(!PlayerCharacter.matches("y|Y|n|N"))
            {
                System.out.println("Please provide a valid input: ");
                PlayerCharacter = scanner.next();
            }

        } while(!PlayerCharacter.matches("y|Y|n|N"));

        playerIsX = PlayerCharacter.matches("y|Y") ? true : false;
           
        System.out.println("Do you want a challenge? (Y/N): ");
        String AISmart= scanner.next();

        do
        {   
            if(!AISmart.matches("y|Y|n|N"))
            {
                System.out.println("Please provide a valid input: ");
                AISmart = scanner.next();
            }

        } while(!AISmart.matches("y|Y|n|N"));
           
        game = AISmart.matches("y|Y") ? new Game(playerIsX, true) : new Game(playerIsX, false);

        if(playerIsX == true)
        {
            System.out.println(game.getBoard().toString());
        }
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() 
    {
        while(game.getStatus() == GameStatus.IN_PROGRESS)
        {
            if(playerIsX == true)
            {
                game.checkGameStatus();
                if(game.getStatus() != GameStatus.IN_PROGRESS)
                {
                    break;
                }

                System.out.println("Enter desired x-coordinate: ");
                int xcoord = scanner.nextInt();
                do
                {
                    if(xcoord > 2 || xcoord < 0)
                    {
                        System.out.println("Enter a valid x-coordinate: ");
                        xcoord = scanner.nextInt();
                    }

                } while(xcoord > 2 || xcoord < 0);

                System.out.println("Enter desired y-coordinate: ");
                int ycoord = scanner.nextInt();
                do
                {
                    if(ycoord > 2 || ycoord < 0)
                    {
                        System.out.println("Enter a valid y-coordinate: ");
                        ycoord = scanner.nextInt();
                    }

                } while(ycoord > 2 || ycoord < 0);

                game.placePlayerPiece(xcoord, ycoord);
                System.out.println("After your move: ");
                System.out.println(game.getBoard().toString());
                
                if(game.getStatus() != GameStatus.IN_PROGRESS)
                {
                    break;
                }
                       
                game.aiPlacePiece();
                System.out.println("After ai move: ");
                System.out.println(game.getBoard().toString());

            }
            else
            {
                game.checkGameStatus();

                if(game.getStatus() != GameStatus.IN_PROGRESS)
                {
                    break;
                }

                game.aiPlacePiece();
                System.out.println("After ai move: ");
                System.out.println(game.getBoard().toString());
               
                if(game.getStatus() != GameStatus.IN_PROGRESS)
                {
                    break;
                }
                
                System.out.println("Enter desired x-coordinate: ");
                int xcoord = scanner.nextInt();
                do
                {
                    if(xcoord > 2 || xcoord < 0)
                    {
                        System.out.println("Enter valid x-coordinate: ");
                        xcoord = scanner.nextInt();
                    }
                }
                while(xcoord > 2 || xcoord < 0);
                
                System.out.println("Enter desired y-coordinate: ");
                int ycoord = scanner.nextInt();

                do
                {
                    if(ycoord > 2 || ycoord < 0)
                    {
                        System.out.println("Enter a valid y-coordinate: ");
                        ycoord = scanner.nextInt();
                    }

                } while(ycoord > 2 || ycoord < 0);
                
                game.placePlayerPiece(xcoord, ycoord);
                System.out.println("After your move: ");
                System.out.println(game.getBoard().toString());
            }
        }

        if(game.getStatus() == GameStatus.DRAW)
        {
            System.out.println("DRAW!");
        }
        else if(game.getStatus() == GameStatus.O_WON)
        {
            System.out.println("O Won!");
        }
        else
        {
            System.out.println("X Won!");
        }
    }
}
