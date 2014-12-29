//class for one of the Lshaped piece that is a piece
//TetrisL2 represents one of the Tetris L shapes.
public class TetrisL2 extends TetrisPiece
{
    //inherited fields from TetrisPiece: filledSquare, pieceRotation

    //Constructor sets up inherited field filledSquares.
    public TetrisL2()
    {
    	 boolean[][][] tempL2Boolean=	
     		{
 			{{false, true, false, false}, {false, true, false, false}, {true, true, false, false},{false, false, false, false}},
 			//new 2D array
 			
 			{{false, false, false, false}, {true, false, false, false}, {true, true, true, false},{false, false, false, false}},
 			{{true, true, false, false}, {true, false, false, false}, {true, false, false, false},{false, false, false, false}},
 			{{true, true, true, false}, {false, false, true, false}, {false, false, false, false},{false, false, false, false}}
 			
 			};
    filledSquares=tempL2Boolean;
    pieceRotation=0;
    }
    //METHODS
    //methods inherited from abstract class: getPieceRotation, isFilled, rotateCCW, rotateCW
    public int getPieceRotation()
    {
	//return an int, placeholder here is 90
	return pieceRotation;
    }
    //method that checks if there is a TetrisBlock at the (row, col) position for the rotation rot, where rot is 0, 90, 180 or 270 degrees.
    public boolean isFilled(int rot, int row, int col)
    {
    	//System.out.println(filledSquares[pieceRotation][row][col]);
    	return filledSquares[pieceRotation][row][col] ;
	
    }
    //method that rotates the piece counter clockwise by 90 degrees
    public void rotateCCW()
    {
    	if(pieceRotation==0)
    	{
    	pieceRotation =3;
    	}
    	else
    		{
    	pieceRotation-=1;
    		}	
    	
    }

    //method that rotates the piece clockwise by 90 degrees
    public void rotateCW()
    {
    	if(pieceRotation<3)
    	{
    	pieceRotation= pieceRotation+1;
    	}
    	else
    		pieceRotation=0;
    }

}
