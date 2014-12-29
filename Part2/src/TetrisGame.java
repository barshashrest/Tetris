//The TetrisGame class maintains a Tetris game.

public class TetrisGame
{
    /**FIELDS**/
    //constant values rotation

    public static final int RIGHT=90;
    public static final int LEFT=90;
    public static final int DOWN=90;
    public static final int CW=90;
    public static final int CCW=90;

    //number of lines
    private int numLines;

    //number of tetrises
    private int numTetrises;

    //the board
    private TetrisBoard tetrisBoard;

    //Constructor
    public TetrisGame()
    {
    }

    /**METHODS**/
    //Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
    public void attemptMove(int moveType)
    {
    }

    //Performed when a piece cannot move down anymore. Ends the round by checking for newly formed lines and adding a new piece.
    public void endRound()
    {
    }
    //numLines
    public int getNumLines()
    {
	return 1;
    }
    //numTetrises
    public int numTetrises()
    {
	return 1;
    }
    public TetrisBoard getTetrisBoard()
    {
	//return the board
	return tetrisBoard;
    }

}