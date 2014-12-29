import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
//class that controls the GUI component of the game with timers, updating display, score etc
public class TetrisGameGUIController extends JPanel implements KeyListener
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

    //Constructor
    public TetrisGameGUIController(boolean keysFromApplet)
    {
    }
    /**INSTANCE METHODS**/

    //method to set up timer
    private void setupTimer()
    {
    }
    //method to view the board
    private void createView()
    {
    }

    //method to update the score
    private void createScore()
    {
    }

    //method to refresh display after each move
    public void refreshDisplay()
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }
    public void keyPressed(KeyEvent e)
    {
    }
    public void keyReleased(KeyEvent e)
    {
    }


}