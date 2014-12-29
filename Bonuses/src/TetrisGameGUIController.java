import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
//awt
import java.awt.FlowLayout;
import java.awt.GridLayout;


//class that controls the GUI component of the game with timers, updating display, score etc
public class TetrisGameGUIController extends JPanel implements KeyListener, ActionListener
{
    /** INSTANCE FIELDS**/
    //constant field that times the drop rate of the pieces when not moved by user
    public static final int DEFAULT_DROP_RATE=5;
    //field that stores the game
    public TetrisGame game;
    //field to paint the game and the blocks
    private TetrisBoardGUIView view;
    //label lines
    public JLabel linesLabel;
    //label the tetrises

    private JLabel tetrisesLabel;
    //time the game using gameTimer

    private Timer gameTimer;
    //calculate the drop rate using the user inputted drop

    private int dropRate;
    
    
    //get the tetrises that havebeen erased from the board
    private int numTetrises;
    
    //get the number of lines that have been erased
    private int numLines;

    //Constructor
    public TetrisGameGUIController(boolean keysFromApplet)
    {
    	
    	//call super class
    	super();
    	//create new game
    	game = new TetrisGame();
    	
    	game.getTetrisBoard().addNewPiece();
    	//create view for the game
		view= new TetrisBoardGUIView(game.getTetrisBoard());
    
    	// use a border layout
		setLayout( new BorderLayout() );
		
		//add the panel with the labels to the north
		add( newPanelForLabels(), BorderLayout.NORTH);
		
		//add the panel with the board to the center
		add(  view , BorderLayout.CENTER );
		
		//set the background of the view to black
		setBackground(Color.BLACK);
		
		
		
		//refreshDisplay();
		
		// create a timer for advancing tetris pieces
				setupTimer();
		 
				// listen for keystrokes -- this only works for the JFrame holding it
				// for the applet, the applet must add the key listener
				if ( !keysFromApplet )
				{ 
					setFocusable(true);
					addKeyListener(this);
				}
		 
		
		
		
		
		
		
		
		
		
    }
    

    /**INSTANCE METHODS**/

    
    private JPanel newPanelForLabels()
    {
    	//create a new instance of a panel for the two JLabels
    	JPanel newPanelForLabels= new JPanel(new GridLayout(1,1));
    	//create a JLabel instance for the number of lines
    	linesLabel= new JLabel("Number of lines: ");
    	//add the linesLabel to the Panel
    	newPanelForLabels.add(linesLabel);
    	//create a JLabel instance for the number of tetrises
    	tetrisesLabel= new JLabel("Number of tetrises: ");
    	//add the tetrisLabel to the panel
    	newPanelForLabels.add( tetrisesLabel);
    	//return the entire panel
    	return newPanelForLabels;
    }
    
   
    public void actionPerformed( ActionEvent e )
	{
    	remove(view);
    	
    	view= new TetrisBoardGUIView(game.getTetrisBoard());
    	view.restart();
    	game.getTetrisBoard().addNewPiece();
    	  add(view);
    	
    	  revalidate();

	}
    
    public void restart()
    {
    	
    	
    	
    	
 
    	
    }
    public void setupTimer()
	{
    	dropRate=800;
		// create a timer to advance the moving down of tetris
		gameTimer = new Timer(dropRate, new ActionListener()
		{
			/**
			 * Invoked every time the timer finishes.
			 */
			public void actionPerformed(ActionEvent e)
			{
				//try to move to  tetris piece down if valid move
				game.attemptMove(3);
 
				// update the view
				repaint();
			}
		});
 
		// start the moving down
		gameTimer.start();
	}
   
	
	//method to update the score
    private void createScore()
    {
    	//get the updated number of lines removed
    	numTetrises= game.getNumLines();
    	
    	//get the updated number of blocks removed
    	numLines= game.numTetrises();
    	//update the linesLabel JLabel to hold the new number of lines removed
     linesLabel.setText("Number of lines "+ numLines);
     //update the tetrisLabel JLabel to hold the new number of tetrises removed
     tetrisesLabel.setText("Number of tetrises " + numTetrises);
     
    }

    //method to refresh display after each move
    public void refreshDisplay()
    {
    	//update the score first
    	createScore();
    	//repaint to get the new view every time the view is refreshed
    	repaint();
    	
    }
    // blank method keyTyped to accomodate keyPressed
    public void keyTyped(KeyEvent e)
    {
    }
    //method that checks what key is being pressed by the user
    public void keyPressed(KeyEvent e)
    {
    	// different behavior depending on which key was released
        switch( e.getKeyCode() )
        {
	        // if it's the right arrow
	        case 39:
	        	// try moving the tetris piece right
	        	game.attemptMove(1);
	        	break;
	       
                // if it's the left arrow
	        case 37:
	        	// try moving the tetris piece left
	        	game.attemptMove(2);
	        	break;
	        
                
                
                // if it's the down arrow
	        case 40:
	        	// try moving the tetris down
	        	game.attemptMove(3);
	        	break;
	        	// if it's the  'x' key
	        case 90:
	        	// try moving the tetris piece clockwise
	        	game.attemptMove(4);
	        	break;
	        	// if it's the 'z' key
	        case 88:
	        	// try moving the tetris piece counter clockwise
	        	game.attemptMove(5);
	        	break;
		default:
			break;
        }
	       
           //call the refresh display after each key is pressed
	        refreshDisplay();	
	        	
	        	
	        
            
    	
    }
    /** Handle the key-released event. */
	public void keyReleased(KeyEvent e)
	{
		
	}
   


}