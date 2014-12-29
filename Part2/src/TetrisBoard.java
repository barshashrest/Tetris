//The TetrisBoard class represents the model: a board on which Tetris is played; it maintains the grid and pieces on it.
public class TetrisBoard
{

    /**INSTANCE FIELDS**/
    // fixed number of columns for the board

    public static final int NUM_COLS=5;

    //fixed number of rows for the board
    public static final int NUM_ROWS=5;

    //the columns where the piece is at one moment
    private int numCols;

    //the rows where the piece is at one moment
    private int numRows;

    //boolean to check to see if a piece is present there
    private boolean[][] board;

    //get the current piece in the board
    private TetrisPiece currentPiece;

    //find the current position in the grid
    private int[] currentGridPosition;

    //Constructor
    //it sets up the board
    public TetrisBoard()
    {
    }

    /**METHODS**/
    //Initialize an int array of length two to keep track of the grid position of the current piece (row, col)
    private void initCurrentGP()
    {
    }
    //initialize the board
    private void initBoard()
    {
    }

    //Update the board array to reflect the newly landed piece's filled squares using the currentGridPosition values and the currentPiece's rotation value.
    public void landPiece()
    {
    }

    //Check if moving left is valid. If so, move the current piece left.
    public boolean moveLeft()
    {
	//return true if valid move was performed
	return true;
    }

    //Check if moving right is valid. If so, move the current piece right.

    public boolean moveRight()
    {
	//return true if valid move was performed
	return true;

    }
    //Check if moving down is valid. If so, move the current piece down.

    public boolean moveDown()
    {
	//return true if valid move was performed
	return true;

    }

    //Check if rotating clockwise is valid. If so,rotate current piece clockwise.

    public boolean moveCW()
    {
	//return true if valid move was performed
	return true;

    }
    //Check if rotating anticlockwise is valid. If so,rotate current piece anticlockwise.

    public boolean moveCCW()
    {
	//return true if valid move was performed
	return true;

    }
    //Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) would cause a collision (i.e., if there would be a block on an already-filled grid square)

    private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol)
    {
	//return true if there would be a collision
	return true;
    }
    //Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) would cause an out of bounds condition (i.e., if there would be a block falling off the board).

    public boolean detectOutOfBound(TetrisPiece piece, int row, int gridRow, int gridCol)
    {
	//return true if there would be a bounding error
	return true;
    }
    //Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) is a valid move.
    private boolean validMove(TetrisPiece piece,
			      int rot,
			      int gridRow,
			      int gridCol)
    {
	//return true if no collision or bounding error
	return true;
    }
    //method to check to see if there is a block
    public boolean hasBlock(int row, int col)
    {
	//return true if there is a block
	return true;
    }

    //Add a new random Tetris piece to the board at grid position (0, 3).
    public void addNewPiece()
    {
    }
    //detect and remove any lines formed in a row
    public int numberOfFormedLines()
    {
	//return total number formed
	return 1;
    }
    //check if there is a full line at the row
    private boolean fullLine(int row)	
    {
	//return true if full
	return true;
    }
    //Remove the line at row in the model. Shift all values for rows at a lower index to be at one row higher. Make row 0 full of false values.
    private void removeLine(int row)
    {
    }
    //get the board
    public boolean[][] getBoard()
    {
	boolean[][] myBoolean = new boolean[0][0];
	myBoolean[0][0]= true;
	return  myBoolean;
    }
    //get the current piece
    public TetrisPiece getCurrentPiece()
    {
	return currentPiece;
    }
    //get the current GridPosition()
    public int[] getCurrentGridPosition()
    {
	return new int[]{1};
    }
    //get the number of columns
    public int getNumCols()
    {
	return 1;
    }

    //get the number of rows
    public int getNumRows()
    {
	return 1;
    }


}