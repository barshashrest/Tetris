import javax.swing.JComponent;
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
    }
    /**METHODS**/
    //method to compute the best block size for the current width and height.
    private int computerBlockSize()
    {
	//placeholder
	//returns size (for a square block) in pixels
	
	return 1;
    }

    //method that paints the game
    //Overrides paint in class javax.swing.JComponent
    public void paint (Graphics g)
    {
    }
    //Paint the block at grid row, grid col.
    public void paint(Graphics g, int row, int col, int blockSize)
    {

    }

    //method that creates the outline for the board
    private void paintBoardOutline(java.awt.Graphics g, int blockSize) 
    {
    }
 
}