//class for square piece that is a piece
//TetrisSquare represents square shape.
public class TetrisSquare extends TetrisPiece
{
    //inherited fields from TetrisPiece: filledSquare, pieceRotation

    //Constructor sets up inherited field filledSquares.
    public TetrisSquare()
    {
    	//a 3D array that holds the pieceRotation,gridRow, gridColumn
    	boolean[][][] tempSquareBoolean=	
     		{
 			{{true, true, false, false}, {true, true, false, false}, {false, false, false, false},{false, false, false, false}},
 			//new 2D array
 			
 			{{true, true, false, false}, {true, true, false, false}, {false, false, false, false},{false, false, false, false}},
 			//new 2D array
 			{{true, true, false, false}, {true, true, false, false}, {false, false, false, false},{false, false, false, false}},
 			{{true, true, false, false}, {true, true, false, false}, {false, false, false, false},{false, false, false, false}}
 			
 			};
    	
    	//give the value of the boolean to the protected triple array boolean filledSquares
    filledSquares=tempSquareBoolean;
     //pieceRotation= 0 is the default piece shape
    //as pieceRotation increases by 1 , it is rotation clockwise
     pieceRotation=0;
    }
    //METHODS
    //methods inherited from abstract class: getPieceRotation, isFilled, rotateCCW, rotateCW
    public int getPieceRotation()
    {
    	//return pieceRotation value
    	return pieceRotation;
        }
        //method that checks if there is a TetrisBlock at the (row, col) position for the rotation rot, where rot is 0, 90, 180 or 270 degrees.
        public boolean isFilled(int rot, int row, int col)
        {
        	//return the boolean values for the particular square
        	return filledSquares[pieceRotation][row][col] ;
    	
        }
        //method that rotates the piece counter clockwise by 90 degrees
        public void rotateCCW()
        {
        	
        if(pieceRotation==0)
        	{
        	//when rotation is counterclockwise for the default piece, start from the last piece because
        	//as pieceRotation increases by 1 , it is rotation clockwise
        	pieceRotation =3;
        	}
        	else
        		{
        		//otherwise rotate the piece counterclockwise by decreasing by 1
        	pieceRotation-=1;
        		}	
        	
        	
        }

        //method that rotates the piece clockwise by 90 degrees
        public void rotateCW()
        {
        	//when the rotation value is less than 3, to rotate clockwise, it needs to be increased by 1
        	if(pieceRotation<3)
        	{
        	pieceRotation= pieceRotation+1;
        	}
        	else
        		//after rotation value reaches the last pieceRotation value i.e, go back to the deafult rotation
        		pieceRotation=0;
        }


}
