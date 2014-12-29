//class for stick piece that is a piece
//TetrisStick represents stick shape.
public class TetrisStick extends TetrisPiece
{
    //inherited fields from TetrisPiece: filledSquare, pieceRotation

    //Constructor sets up inherited field filledSquares.
    public TetrisStick()
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
    public boolean isFilled(int row,  int col)
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
