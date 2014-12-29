
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//import the frame
import javax.swing.JFrame;
// GUI version of the Tetris game.
public class TetrisGUIApplication implements ActionListener
{
	private static TetrisGameGUIController newTetrisGameGUIController;
    //start the game
    public static void main(String[] args)
    {
    	//newTetrisGameGUIController
    	
    	// create a new JFrame to hold TicTacToePanel
    	JFrame tetrisFrame = new JFrame( );

    	// set size
    	tetrisFrame.setSize( 360, 720 );
    	// use a border layout
    			tetrisFrame.setLayout( new BorderLayout() );
    			newTetrisGameGUIController= new TetrisGameGUIController(false);
    	
    		// create a TetrisGameTextController and add it
    		tetrisFrame.add( newTetrisGameGUIController, BorderLayout.CENTER  );
    		
    		

    	// exit normally on closing the window
    	tetrisFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    	// show frame
    	tetrisFrame.setVisible( true );
    }
    public static JButton newButtonForRestart(String restart)
    {
    	JButton restartButton = new JButton(restart);
    	//restartButton.addActionListener(this);
    	
    	return restartButton;
    }
    public void actionPerformed( ActionEvent e )
   	{
    	newTetrisGameGUIController.restart();

   	}
       
    
}

