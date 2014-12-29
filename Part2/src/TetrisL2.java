//class for one of the Lshaped piece that is a piece
//TetrisL2 represents one of the Tetris L shapes.
public class TetrisL2 extends TetrisPiece
{
    //inherited fields from TetrisPiece: filledSquare, pieceRotation

    //Constructor sets up inherited field filledSquares.
    public TetrisL2()
    {
    }
    //METHODS
    //methods inherited from abstract class: getPieceRotation, isFilled, rotateCCW, rotateCW
    public int getPieceRotation()
    {
	//return an int, placeholder here is 90
	return 90;
    }
    //method that checks if there is a TetrisBlock at the (row, col) position for the rotation rot, where rot is 0, 90, 180 or 270 degrees.
    public boolean isFilled(int row, int col)
    {
	//placeholder is true
	return true;
    }
    //method that rotates the piece counter clockwise by 90 degrees
    public void rotateCCW()
    {
    }

    //method that rotates the piece clockwise by 90 degrees
    public void rorateCW()
    {
    }

}
