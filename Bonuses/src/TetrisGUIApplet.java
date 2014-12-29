//awt
import java.applet.Applet;
import java.awt.BorderLayout;

//applet that invokes the TetrisGame and the html file
public class TetrisGUIApplet extends Applet
{
    /**INSTANCE VARIABLES**/
    //has instance field of type Class TetrisGameGUIController that controls the update of the game
    private  TetrisGameGUIController	controller ;
    public TetrisGUIApplet()
    {
    	//call the super constructor of the Applet
    super();
    }
    //special method that will be invoked when applet is created
public void start()
{
	// so the controller stretches
			setLayout( new BorderLayout() );
	 
			// create a TetrisGameGUIController
			controller = new  TetrisGameGUIController( true );
	 
			// and add it 
			add( controller, BorderLayout.CENTER );
	 
			// allow key events
			setFocusable(true);
			requestFocusInWindow();		
	 
			// add the controller for key events
			addKeyListener( controller );
}
}
