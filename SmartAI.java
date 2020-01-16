/**
 * Realization of AI interface using smart strategy [NOT IMPLEMENTED].
 *
 * STUDENTS: Nothing to change here.
 *
 * @author Marcus Ford
 */

import java.util.Random;

public class SmartAI implements AI {
    
    private Random random = new Random();
    private char piece;
    /**
     * Construct a SmartAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public SmartAI(boolean aiIsX) 
    {
       if(aiIsX == true)
       {
           piece = 'X';
       }
       else
       {
           piece = 'O';
       }
    }

    public Move chooseMove(Board board) 
    {
      if(board.get(1,1) == ' ')
      {
        Move nextMove = new Move(1,1,piece);
        return nextMove;
      }
      else
      {
          if(board.get(0,0) == ' ')
          {
            Move nextMove = new Move(0,0,piece);
            return nextMove;
          }
          else if(board.get(2,0) == ' ')
          {
            Move nextMove = new Move(2,0,piece);
            return nextMove;
          }
          else if(board.get(0,2) == ' ')
          {
            Move nextMove = new Move(0,2,piece);
            return nextMove;
          }
          else if(board.get(2,2) == ' ')
          {
            Move nextMove = new Move(2,2,piece);
            return nextMove;
          }
          else
          {
            while(true)
            {
                int ColumnCoord = random.nextInt(3);
                int RowCoord = random.nextInt(3);
                if(board.get(ColumnCoord,RowCoord) == ' ')
                {
                    Move nextMove = new Move(ColumnCoord, RowCoord, piece);
                    return nextMove;
                }
            }
          }
      }
    }
}
