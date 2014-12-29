//The TetrisBoard class represents the model: a board on which Tetris is played; it maintains the grid and pieces on it.
public class TetrisBoard
{

    /**INSTANCE FIELDS**/
    // fixed number of columns for the board

    public static final int NUM_COLS=10;

    //fixed number of rows for the board
    public static final int NUM_ROWS=18;

    
    

    //boolean to check to see if a piece is present there
    private boolean[][] board;

    //get the current piece in the board
    private TetrisPiece currentPiece;

    //find the current position in the grid
    private int[] currentGridPosition;
    
    //get the total number of full lines formed i.e. a row of full of 'x' since the game has started
    private int numberOfFormedLines=0;
    
    //get the total tetris pieces ('x') that have been removed from the game by completing a line
    private int numberOfTetrises=0;
    
    
    //Constructor
    //it sets up the board
    public TetrisBoard()
    {
    	//initialize the board
	initBoard();
	
	//initialize the current grid position
	initCurrentGP();
    }

    /**METHODS**/
    //Initialize an int array of length two to keep track of the grid position of the current piece (row, col)
    private void initCurrentGP()
    {
    	currentGridPosition = new int[2];
    	
    }
    //initialize the board
    private void initBoard()
    {
    	//the board is made up of a double arrays of 18 rows and 10 columns
    	board = new boolean[18][10];
    	
    	//for every row
    	for (int i=0; i<NUM_ROWS;i++)
    	{
    		//for every column
    	for(int j=0; j<NUM_COLS;j++)
    	{
    		
    		//initialize every array space on the board to be false in the beginnng
    	board[i][j]=false;
    		
    	}
    	
    	}
    	
	
	
    }

    //Update the board array to reflect the newly landed piece's filled squares using the
    //currentGridPosition values and the currentPiece's rotation value.
    public void landPiece()
    {
    	
    	
    	//for rows of current piece
    	for (int i=0; i<4;i++)
    	{
    		//for columns of current piece
    		for(int j=0;j<4;j++)
    		{
    			
    			//if there is a true value in a grid of the piece's total 4x4 grid
    			if( currentPiece.isFilled(currentPiece.getPieceRotation(),i,j) )
    			{
    				//place the piece with its true grids on the board using 
    				//currentGridPosition[0]+i and currentGridPosition[1]+j as these give the position in the board as i and j are
    				//rows and columns for the piece only, not the board
    				
    				//set those grids with true values to be true in the board
    				board[currentGridPosition[0]+i][currentGridPosition[1]+j]=true;
    			
    			}
    		}
    		
    		
    	}
    	
    	
    	
    }

    //Check if moving left is valid. If so, move the current piece left.
    public boolean moveLeft()
    {
    	//initialize the boolean value to false
    	boolean left=false;
    	//every row
    	//for left, we also need to check that the column is always greater than 0 such that j-1 is not a negative number along with checking to see if there is a valid move
   //at currentGridPosition[1]-1 (that corresponds to j-1)
    	 if((currentGridPosition[1]>0 && validMove(currentPiece,  currentPiece.getPieceRotation(), currentGridPosition[0], currentGridPosition[1]-1)) )
    	 
    		 //if it is a valid move, move it left
    	 {
    		 
    		 //change the boolean value to true as it is a valid move
    		 left=true;
    		 
    		 //first clear the current piece grid ie make all values false
    		 clearCurrentPieceGrid();
    		 
    		 //then change the current grid position for the piece to j-1 so it can start from the left side
    		currentGridPosition[1]-=1;
    		
    		//call land piece that overwrites the previous grid to give a new grid starting from j-1 when going left
    		landPiece();
    		
    		
    	 }
    	
    		
    	
   

    
    	 
    	 
	//return the value of the boolean
	return left;
    }

    //Check if moving right is valid. If so, move the current piece right.

    public boolean moveRight()
    {
    	//initialize the boolean value to false
    	boolean right=false;
    	//every row
    	
    	
    	//for right, check to see if there is a valid move at the right side i.e currentGridPosition[1]+1, that corresponds to j+1
    	   
   	 if(validMove(currentPiece,  currentPiece.getPieceRotation(), currentGridPosition[0], currentGridPosition[1]+1) )
   	 
   	 {
   		 //change the boolean value to true as it is a valid move
    		 right=true;
   		 //clear the grid of the previous piece
   		 clearCurrentPieceGrid();
   		 //change the grid rows and column for the piece so it goes to j+1
   		currentGridPosition[1]+=1;
   		
   	//call land piece that overwrites the previous grid to give a new grid starting from j+1 when going right
   		landPiece();
   	 }
   	 
    
    
    
    	
    	
    
	//return the value of the boolean
	return right;
	


    }
    //Check if moving down is valid. If so, move the current piece down.

    public boolean moveDown()
    {
    	//initialize the boolean value to false
    	boolean down=false;
    	//first check to see if there is valid move at row+1 ie i+1
    	if( validMove(currentPiece,  currentPiece.getPieceRotation(), currentGridPosition[0]+1, currentGridPosition[1]) )
    	
    	{
    		//change the boolean value to true as it is a valid move
    		down=true;
    		
    		//clear the grid of the previous piece
      		clearCurrentPieceGrid();
      		
      	//change the grid rows and column for the piece so it goes to i+1 or row+1
      		currentGridPosition[0]+=1;
      		
      		
      	//call land piece that overwrites the previous grid to give a new grid starting from i+1 when going down
      		landPiece();
      		
      	 }
      	 
      	 
	//return true if valid move was performed
	return down;

    }

    //Check if rotating clockwise is valid. If so,rotate current piece clockwise.

    public boolean moveCW()
    {
    	//initialize the boolean value to false
    	boolean clockwise=false;
    	
    
    	
    	// check to see if going clockwise is possible
    	//check if the move is valid by using the next piece rotation value (pieceRotation inscreases by 1 for clockwise rotation) i.e currentPiece.getPieceRotation()+1
     if(validMove(currentPiece,  currentPiece.getPieceRotation()+1, currentGridPosition[0], currentGridPosition[1]) )
     {
    		
    	//change the value of the boolean to true
    		clockwise=true;
    		
         	//first clear the board of all the pieces from before
         		 clearCurrentPieceGrid();
         		 //update the rotation so it is clockwise
         		currentPiece.rotateCW();
         		//add the new piece that starts from new piece rotation to rotate clockwise
         		landPiece();
         	 
    }
    
	//return the boolean value
	return clockwise;

    }
    //Check if rotating anticlockwise is valid. If so,rotate current piece anticlockwise.

    public boolean moveCCW()
    {
    	//initialize the boolean value to false
    	boolean anticlockwise=false;
    	
    	// check to see if going anticlockwise is possible
    	//check if the move is valid by using the next piece rotation value (pieceRotation increases by 3 for clockwise rotation) i.e currentPiece.getPieceRotation+3
     if(validMove(currentPiece,  currentPiece.getPieceRotation()+3, currentGridPosition[0], currentGridPosition[1]) )
     {
    		
    	//change the value of the boolean to true
    		anticlockwise=true;
    		
         	//first clear the board of all the pieces from before
         		 clearCurrentPieceGrid();
         		 //update the rotation so it is anticlockwise
         		currentPiece.rotateCCW();
         		//add the new piece that starts from new piece rotation to rotate anticlockwise
         		landPiece();
         	 
    }
    
	//return the boolean value
	return anticlockwise;

    }
    //Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) would cause a collision
    //(i.e., if there would be a block on an already-filled grid square)
//board grid row = gridRow, board grid col = grid Col
    private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol)
    {
    	//first clear the grid of the previous piece so it doesn't interfere
    	clearCurrentPieceGrid();
    	
    	//for every row
    	for (int i=0; i<4; i++)
    	{
    		//for every column
    		for (int j=0; j<4; j++)
    		{
    			//if there is a true value on the tetris piece
    			if(piece.isFilled(rot, i, j)==true)
    			{
    				//if there is a collision, return true
    				if(board[i+gridRow][j+gridCol])
    				{
    					//add the same piece that was cleared again
    					landPiece();
    					
    					//return true
    					return true;
    				}
    			
    			}
    		}
    	}
	//return false if there would not be a collision
	return false;
    }
    //Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) would cause an out of bounds condition (i.e., if there would be a block falling off the board).

    public boolean detectOutOfBound(TetrisPiece piece, int rot, int gridRow, int gridCol)
    {
    	
    	//initialize the boolean
    	boolean isOutOfBounds=false;
    	
    	//for every row of the current piece
    	for (int i=0; i<4; i++)
    	{
    		//for every column of the current piece
    		for (int j=0; j<4; j++)
    		{
    			//if there is a true value on the tetris piece
    			if(piece.isFilled(rot, i, j)==true)
    			{
    				//check to see if the piece doesn't fall off either by having filled rows that go beyond the board row 
    				//or b having a filled column that goes beyong the board column
    				if((i+gridRow)>=NUM_ROWS || (j+gridCol)>=NUM_COLS )
    					//if it does go beyond, it is out of bounds. So return true
    					isOutOfBounds= true;
    			}
    		}
    	}
    	
	//return true if there would be a bounding error
	return isOutOfBounds;
    }
    //Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) is a valid move.
    private boolean validMove(TetrisPiece piece,  int rot, int gridRow, int gridCol)
    {
    	//check to see if the move is valid. it is only valid if the piece is not out of bounds and there is no collision
    	if((detectOutOfBound( piece, rot,  gridRow, gridCol))==false && (detectCollision(piece, rot, gridRow, gridCol))==false)
    	{
    		
	//return true if no collision or bounding error
	return true;
    	}
    	//otherwise, return false
    	return false;
    }
    //method to check to see if there is a "x" i.e there is a true value
    public boolean hasBlock(int row, int col)
    {
    	//if any point on the board array is true
    	if(board[row][col]==true)
	//return true if there is a block
	{return true;}
    	//otherwise return false
    	return false;
    }

    //Add a new random Tetris piece to the board at grid position (0, 3).
    public void addNewPiece()
    {
    	//for all of the rows in the board
    	for(int i=0; i<NUM_ROWS;i++)
    	{
    		//check to see if the line is full ie all columns in the row is filled
    		if(fullLine(i))
    		{
    			//if it is filled, remove that line
    	removeLine(i);
    	//update the number of formed lines
    	numberOfFormedLines();
    		}
    	}
    	//create an instance of each piece
    	TetrisL1 newTetrisL1 = new TetrisL1();
    	TetrisL2 newTetrisL2= new TetrisL2();
    	TetrisS1 newTetrisS1= new TetrisS1();
    	TetrisS2 newTetrisS2= new TetrisS2();
    	TetrisT newTetrisT = new TetrisT();
    	TetrisStick newTetrisStick = new TetrisStick();
    	TetrisSquare newTetrisSquare = new TetrisSquare();
    	
    	//make an array of all the pieces
    	TetrisPiece[] arrayPiece = {newTetrisL1, newTetrisL2, newTetrisS1, newTetrisS2, newTetrisStick, newTetrisSquare, newTetrisT};
    			//random number to get a random piece
    	int a= (int)(Math.floor(Math.random()*7));
    	
    	//pass that piece to be the current piece
    	currentPiece=arrayPiece[a];
    	
    	
    	//initialize the current grid position(0,3)
    	currentGridPosition[0]=0;
    	currentGridPosition[1]=3;
    	
    	//update the piece position in the board
    	landPiece();
    	
    	
    }
    	
    	
    	
    	
    
    //detect and remove any lines formed in a row
    public int numberOfFormedLines()
    {
    	
    	
    	
    	
    	
	//return total number formed
	return numberOfFormedLines;
    }
    
    //method to get number of tetrises
    public int numberOfTetrises()
    {
    	//return the number of tetrises removed
    	return numberOfTetrises;
    }
    
    
    //check if there is a full line at the row
    private boolean fullLine(int row)	
    {
    	//initialize a variable that holds the total number of blocks in a row
    	int totalBlocksInEachRow= 0;
    	//for the columns in the row
    	for (int j=0; j<NUM_COLS;j++)
    	{
    		//if there is a block in each column of a particular row
    		if(board[row][j]==true)
    		{
    			//increase the total blocks in that row by 1
    			totalBlocksInEachRow+=1;
    			
    		}
    		//if there are as many bloacks as there are columsn
    		if (totalBlocksInEachRow==NUM_COLS)
    		{
    			//the line has been filled
    			return true;
    		}
    	}
	//return true if full
	return false;
    }
    //Remove the line at row in the model. Shift all values for rows at a lower index to be at one row higher. Make row 0 full of false values.
    private void removeLine(int row)
    {
    	
    	//for the columns in the row
    	for (int j=0; j<NUM_COLS;j++)
    	{
    		//make all the values to false in order to remove the line
    	board[row][j]=false;
    	}
    	//shift the values for the rows at a lower index to be at one row higher
    	for(int i=row; i>0; i--)
    	{
    		for (int j=0; j<NUM_COLS;j++)
    		{
    			board[i][j]=board[i-1][j];
    		}
    	}
    	//row 0 is full of false values
    	//for the columns
    	for(int j=0; j<NUM_COLS;j++)
    	{
    		board[0][j]=false;
    	}
    	//increase the number of formed lines by 1
    	numberOfFormedLines+=1;
    	
    	//increase the number of tetrises destroyed by the number of columns
    	numberOfTetrises+=NUM_COLS;
    	
    }
    //get the board
    public boolean[][] getBoard()
    {
    	return board;
	
    }
    //get the current piece
    public TetrisPiece getCurrentPiece()
    {
	return currentPiece;
    }
    
    //get the current GridPosition()
    public int[] getCurrentGridPosition()
    {
	
	return currentGridPosition;

    }
    //get the number of columns
    public int getNumCols()
    {
	return NUM_COLS;
    }

    //get the number of rows
    public int getNumRows()
    {
	return NUM_ROWS;
    }
    
    //method to clear the grid for the currentPiece
    public void clearCurrentPieceGrid()
    {
    	//for rows of current piece
    	for (int i=0; i<4;i++)
    	{
    		//for columns of current piece
    		for(int j=0;j<4;j++)
    		{
    			//when there is a block at the position in the grid
    			if( currentPiece.isFilled(currentPiece.getPieceRotation(),i,j) )
    			{
    				//remove the false by changing the value to false
    				board[currentGridPosition[0]+i][currentGridPosition[1]+j]=false;
    			}
    		}
    		
    	}
    	
    }


}