//The TetrisGame class maintains a Tetris game.
// IO



public class TetrisGame
{
    /**FIELDS**/
    //constant values rotation

    public static final int RIGHT=1;
    public static final int LEFT=2;
    public static final int DOWN=3;
    public static final int CW=4;
    public static final int CCW=5;

    

    //the board
    private TetrisBoard tetrisBoard;

    //Constructor
    public TetrisGame()
    {
    	//instantiate the tetrisBoard
    	tetrisBoard=new TetrisBoard();
    	
    	
    	
    	
    }
    
    /**METHODS**/
    //Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
    public void attemptMove(int moveType)
    {
    	//if the value of movetype is the value of RIGHT
    	if(moveType==RIGHT)
    	{
    		//move it right
    		tetrisBoard.moveRight();
    		
    	}
    	//if the value of movetype is the value of LEFT
    	if(moveType==LEFT)
    	{
    		//move to left
    		tetrisBoard.moveLeft();
    			
    		
    		
    	}
    	//if the value of movetype is the value of LEFT
    	if(moveType==DOWN)
    	{
    		//check to see if moving down is possible
    		//if not possible
    		if(!tetrisBoard.moveDown())
    			//end the round by calling endRound() that adds a new piece
    			endRound();
    	}
    	//if the value of movetype is the value of CW
    	if(moveType==CW)
    	{
    		//move clockwise
    		tetrisBoard.moveCW();
    	}
    	//    	//if the value of movetype is the value of CCW
    	if(moveType==CCW)
    	{
    		//move counterclockwise
    		tetrisBoard.moveCCW();
    	}
    }

    //Performed when a piece cannot move down anymore. Ends the round by checking for newly formed lines and adding a new piece.
    public void endRound()
    {
    	//add a new piece as a piece cannot move down anymore
    	tetrisBoard.addNewPiece();
    	
    }
    //numLines
    public int getNumLines()
    {
    	
	return tetrisBoard.numberOfFormedLines();
    }
    //numTetrises
    public int numTetrises()
    {
    	
    	
	return tetrisBoard.numberOfTetrises();
    }
    
    
    public TetrisBoard getTetrisBoard()
    {
    	
	//return the board
	return tetrisBoard;
    }

}