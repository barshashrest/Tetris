//class that controls the view of the game in command line
//TetrisBoardTextView creates a String view of a TetrisBoard.

public class TetrisGameTextView
{
    /**INSTANCE FIELDS**/
    //get the game
    private TetrisGame game;
    
    
    
    //Constructor
    //requires board to display
    public TetrisGameTextView (TetrisGame g)
    {
    	//the passed tetrisGame is the game
    	game=g;
    	
    	
    	
    }

    /**METHODS**/
    //method to get the board
    private String getBoardView()
    {
    	//get the tetrisBoard from the tetrisBoard class
    	TetrisBoard forThisBoardView = game.getTetrisBoard();
    	//initialize a string variable
    	String boardWithStrings=""; 
    	
    	//for the board with its rows
    	for (int i=0; i<forThisBoardView.getNumRows(); i++)
    	{
    		//for the board with its columns
    		for(int j=0; j<forThisBoardView.getNumCols(); j++)
    		{
    			//if the boar has a block
    		if (forThisBoardView.hasBlock(i,j)==true)
    			{
    			//add a 'x' to denoted there is a block
    		boardWithStrings =boardWithStrings + "x";
    	
    		
    			}
    		else
    			//otherwise add a blank space
    			{
    			boardWithStrings+=" ";
    			}
    		}
    		//after each row, move down
    		boardWithStrings+= "\n";
    		
    	
    	}
    	
    	
	//return the view of the board
	return (boardWithStrings);
    }
    //method to get the current view of the board and the updates score as a String
    public String getView()
    {
    	//initialize a variable of strings for the entire view
    	String toGetEntireView = "";
    	//get the entire view 
    	toGetEntireView =( "Number of tetrises: " + game.numTetrises() + "\n" + "Number of lines: " + game.getNumLines() + "\n" + "----------" + "\n" + getBoardView() + "----------");
	
	//return the view
	return toGetEntireView;
    }


}
