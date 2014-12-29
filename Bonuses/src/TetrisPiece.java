


// piece class piece 
//all the different types of pieces (Lshape, Tshape, square, S shaped, stick ) is a piece
//all the pieces are of type TetrisPiece. So this is an abstract class
public abstract class TetrisPiece
{

    /**INSTANT VARIABLES **/
    // 3 dimensional array maintaining which grid squares are filled. first dimension is rotation (index 0 -> 0 degrees, index 1 -> 90 degrees, index 2 -> 180 degrees, index 3 -> 270 degrees) second and third dimensions create 4x4 grid with true entries indicating a filled square
    protected boolean[][][] filledSquares;

    //a field that would maintain the current rotation
    protected int pieceRotation;
//constructor
public TetrisPiece()
{
	//the new boolean holds pieceRotation (max of total 4 types of rotation), grid row (4) and grid column(4)
	filledSquares = new boolean[4][4][4];
	//for every piece rotation
	for (int i =0; i<filledSquares.length; i++)
	{
		//for every grid row
		for (int j=0; j<filledSquares[i].length; j++)
		{
			//for every grid column
			for (int k=0; k<filledSquares[i][j].length; k++)
			{
				//fill every boolean in the array to false to initailize it
				filledSquares[i][j][k]=false;
			}
		}
	}
}

    /**INSTANT METHODS**/
    //all the methods below are abstract as all pieces will have these methods
    //method to get rotation of the piece
    public abstract int getPieceRotation();
    
    //method that checks if there is a TetrisBlock at the (row, col) position for the rotation rot, where rot is 0, 90, 180 or 270 degrees.
    public abstract boolean isFilled(int rot, int row,  int col);
    
    //method that rotates the piece counter clockwise by 90 degrees
    public abstract void rotateCCW();
    

    //method that rotates the piece clockwise by 90 degrees
    public abstract void rotateCW();
    
}