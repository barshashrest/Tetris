import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//class that controls the command line version of the game
public class TetrisGameTextController
{

    /**INSTANCE FIELDS**/
    //field of type TetrisGame
    private TetrisGame game;

    //field that gets the tetris text view i.e that makes the command line game visible
    private TetrisGameTextView view;

    //Constructor
    public TetrisGameTextController() 
    {
    	//instantiate the tetrisGame and the view
    	game = new TetrisGame();
    	view = new TetrisGameTextView(game); 
    	
    	//add a new piece at the very beginning
    	getGame().getTetrisBoard().addNewPiece();
    	//update the display by getting the view
    	refreshDisplay();
    	
    	
    	
        	//read what the user inputs
        	readInput();
    } 
    
    //getter for the game
    public TetrisGame getGame() {
		return game;
	}

    //setter for the game
	public void setGame(TetrisGame game) {
		this.game = game;
	}

	//method to read what the user inputs as the command
	public void readInput()
    {
    	// wrap input stream read input from user
    			
    			BufferedReader in = 
    			new BufferedReader( new InputStreamReader( System.in ) );
    			// I/O almost always requires a try/catch
    			// block as exceptions may be thrown 
    			try 
    			{
    				String line;
    	 
    				// loop until the user types "Quit"
    				do {
    					//give a command to the use
    					System.out.print("Please enter a move (l,r,d,z,x) or type Quit to end: ");
    					// try to read a line
    					
    					line = in.readLine(); 
    					//if the user inputs 'l'
    					if(line .equals("l"))
    					{
    						//try to move left with its corresponding movetype of 2
    						game.attemptMove(2);
    						
    						
    						
    						//refresh display by getting the new view
    					refreshDisplay();
    					}
    					
    					//if the user inputs 'r'
    					if(line .equals("r"))
    					{
    						//try to move right with its corresponding movetype of 1
    						game.attemptMove(1);
    						
    						//refresh display by getting the new view
    					refreshDisplay();
    					}
    					
    					//if the user inputs 'd'
    					if(line .equals("d"))
    					{
    						//try to move down with its corresponding movetype of 3
    						game.attemptMove(3);
    						//refresh display by getting the new view
        					refreshDisplay();
    					}
    					
    					
    					//for clockwise
    					//if the user inputs 'x'
    					if(line .equals("x"))
    					{
    						//try to move down with its corresponding movetype of 4
    						game.attemptMove(4);
    						//refresh display by getting the new view
        					refreshDisplay();
    					}
    					//for counterclockwise
    					//for clockwise
    					//if the user inputs 'z'
    					if(line .equals("z"))
    					{
    						//try to move down with its corresponding movetype of 5	
    						game.attemptMove(5);
    						//refresh display by getting the new view
        					refreshDisplay();
    					}
    					
    					
    					
    						
    						//if the user doesn't input l,r,d,z or x
    						if((!line .equals("l")) && (!line .equals("r")) && (!line .equals("d")) && (!line .equals("z")) && (!line .equals("x")))
    						{
							// inform user of error
							System.out.println( "Error: Input must be l,r,d,z or x." );
    						}		 
    					
    					
    						
    							
    							
    						
    					} 
    				//do this until the user quits
    				while ( (!line.equals( "Quit" ) ) );
    				}
    				// catch I/O exception
    				catch ( IOException ioe )
    				{
    					// tell exception to print its error log
    					ioe.printStackTrace();
    				}
    			
    		 
    					
    }
    /**METHODS**/
    //main method to start the game
    public static void main(String[] args)
    {
    	//make a new instance of the controller
    	TetrisGameTextController tetrisGameTextController= new TetrisGameTextController();
    	
  
    	
    }
    
    
    //method that prints text view of the game, refreshing after each move
    private void refreshDisplay()
    {
    	//print out the view
    	System.out.println( view.getView());
    }
}