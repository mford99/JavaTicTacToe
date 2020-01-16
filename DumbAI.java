/**
 * Realization of AI interface using simplistic random placement strategy.
 *
 * @author Marcus Ford
 */

import java.util.Random;

public class DumbAI implements AI 
{
    
    private Random random = new Random();
    private char AICharacter;
    /*
     * TBD: Create additional private members if useful.
     */
    
    /**
     * Construct a DumbAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX) 
    {
       if(aiIsX == true)
       {
           AICharacter = 'X';
       }
       else
       {
           AICharacter = 'O';
       }
    }

    public Move chooseMove(Board board) 
    {
        while(true)
        {
            int ColumnCoord = random.nextInt(3);
            int RowCoord = random.nextInt(3);
            if(board.get(ColumnCoord,RowCoord) == ' ')
            {
                Move nextMove = new Move(ColumnCoord, RowCoord, AICharacter);
                return nextMove;
            }
        }   
    }
}
