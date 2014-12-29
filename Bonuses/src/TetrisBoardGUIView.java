import javax.swing.JComponent;


import java.awt.Color;
import java.awt.Graphics;

//class that paints the board and the blocks in it
public class TetrisBoardGUIView extends JComponent
{

    /**INSTANCE METHODS**/
    //gets the tetris board
    private TetrisBoard board;

    
    //Constructor
    //gets the board as the parameter to initialize the board
    public TetrisBoardGUIView(TetrisBoard b) 
    {
    	//call the super class
    	super();
    	//set the board b to the the board
    	board=b;
    }
    /**METHODS**/
    //method to compute the best block size for the current width and height.
  //returns size (for a square block) in pixels
    private int computerBlockSize()
    {
	
	//get the width of the board and divide it by the number of columns to get best possible size for the block
	int blockW = (getWidth())/board.getNumCols();
	//get the height of the board and divide it by the number of rows to get best possible size for the block
	int blockH= getHeight()/board.getNumRows();
	
	//Math.min to get the minimum of the two values of width and height 
	//this is so the board adjusts accordingly to the user stretched window
	int minimumOfTheBlocks = Math.min(blockW, blockH);
	
	//return size of one square block in pixels
	return minimumOfTheBlocks;
    }

    //method that paints the game
    //Overrides paint in class javax.swing.JComponent
    public void paint (Graphics g)
    {
    	//paint the outline of the board
    	paintBoardOutline(g, computerBlockSize());
    	//for every row
    	for (int i=0; i<board.getNumRows(); i++)
    	{
    		//for every column
    		for(int j=0; j<board.getNumCols(); j++)
    		{
    			//if there is a piece on the board
    			if (board.hasBlock(i,j)==true)
    				
    			{
    				
    				g.setColor(Color.RED);
    				//paint the piece so it is visible
    				paintBlock(g,i*computerBlockSize(),j*computerBlockSize(),computerBlockSize());
    				
    			}
    			
    		}
    	}
    	
    	
    	
    	
    	
    }
    //Paint the block at grid row, grid col.
    public void paintBlock(Graphics g, int row, int col, int blockSize)
    {
    	//x is col
    	//y is row 
    	
    	//first set the color of the rectangle then fill the color
    	//g.setColor(newColor);
    	g.fillRect (col,row, blockSize, blockSize);
    	//set the color of the border of the block then draw the border
    	g.setColor(Color.BLACK);
      
    	g.drawRect (col,row, blockSize, blockSize);    //can use either of the two//
        
    }

    //method that creates the outline for the board
    public void paintBoardOutline(Graphics g, int blockSize) 
    {
    	//set the color of the outline then draw the rectangular outline
    	g.setColor(Color.BLACK);
    	g.drawRect(0, 0, getWidth(), getHeight());
    	
    	
 
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    public void restart()
    {
    	board.restart();
    }
 
}