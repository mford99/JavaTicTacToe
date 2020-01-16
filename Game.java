/**
 * Represents the logic of the game in terms of detecting wins or draws.  Also
 * places new pieces for the human player or AI.
 *
 * @author Marcus Ford
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;
    private char PlayerCharacter;
    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) 
    {
        if(playerIsX == true)
        {
            PlayerCharacter = 'X';
        }
        else
        {
            PlayerCharacter = 'O';
        }

        if(challenging == true)
        {
            ai = new SmartAI(!playerIsX);
        }
        else
        {
            ai = new DumbAI(!playerIsX);
        }

        status = GameStatus.IN_PROGRESS;
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() 
    {
        return board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() 
    {
        return status;
    }
    
    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */
    public boolean placePlayerPiece(int i, int j) 
    {
        checkGameStatus();
        if( (((i > 2) || (i < 0)) || ((j > 2) || (j < 0))) || (board.get(i,j) != ' ') && (status != GameStatus.IN_PROGRESS))
        {
            return false;
        }
        else
        {
            Move newMove = new Move(i,j,PlayerCharacter);
            board = new Board(board, newMove);
             checkGameStatus();
            return true;
        }
       
    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() 
    {
        checkGameStatus();
        if(status != GameStatus.IN_PROGRESS)
        {
            return;
        }
        Move newAIMove = ai.chooseMove(board);
        board = new Board(board, newAIMove);
        checkGameStatus();
    }

    public void checkGameStatus()
    {
        for(int i = 0; i < 3; i++)
        {
            if((board.get(i, 0) == 'X') && (board.get(i, 1) == 'X') && (board.get(i,2) == 'X'))
            {
                status = GameStatus.X_WON;
                return;
            } 
            else if((board.get(i, 0) == 'O') && (board.get(i, 1) == 'O') && (board.get(i,2) == 'O'))
            {
                status = GameStatus.O_WON;
                return;
            } 
        }

        for(int j = 0; j < 3; j++)
        {
            if((board.get(0, j) == 'X') && (board.get(1, j) == 'X') && (board.get(2, j) == 'X'))
            {
                status = GameStatus.X_WON;
                return;
            } 
            else if((board.get(0, j) == 'O') && (board.get(1, j) == 'O') && (board.get(2,j) == 'O'))
            {
                status = GameStatus.O_WON;
                return;
            } 
        }

        if(board.get(0, 0) == 'X' && board.get(1,1) == 'X' && board.get(2,2) == 'X')
        {
            status = GameStatus.X_WON;
            return;
        }
        else  if(board.get(0, 0) == 'O' && board.get(1,1) == 'O' && board.get(2,2) == 'O')
        {
            status = GameStatus.O_WON;
            return;
        }
        else  if(board.get(2, 0) == 'O' && board.get(1,1) == 'O' && board.get(0,2) == 'O')
        {
            status = GameStatus.O_WON;
            return;
        }
        else  if(board.get(2, 0) == 'X' && board.get(1,1) == 'X' && board.get(0,2) == 'X')
        {
            status = GameStatus.X_WON;
            return;
        }
        else if( board.isFull() == true)
        {
            status = GameStatus.DRAW;
            return;
        }
        
    }
}
