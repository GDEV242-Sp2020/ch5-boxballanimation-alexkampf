import java.awt.Color;
import java.util.HashSet;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 * modified by Alexander Kampf
 */

public class BallDemo   
{
    private Canvas myCanvas;
    
    int boxHeight = 350;
    int boxWidth = 350;
    int canvasHeight = 600;
    int canvasWidth = 500;
    int xPos = 10;
    int yPos= 10;
    HashSet<BoxBall> balls = new HashSet<BoxBall>();
    private Random r;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        r = new Random();
    }

    /**
     * Simulate numberofBalls to bounce
     */
    public void bounce(int numberofBalls)
    {
        myCanvas.setVisible(true);
        boxBounce(numberofBalls);
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
           for(BoxBall boxBall : balls)
           {
               boxBall.move();
               if(boxBall.getXPosition() >= boxHeight +
                                     30 * numberofBalls)
               {
                   finished = true;
               }
           }
            
            }
        }
        /**
         * adds balls to the set, and draws them
         */
        private void boxBounce(int numberofBalls)
        {
        Random rand = new Random();
         
            myCanvas.drawRectangle(xPos, yPos, boxWidth,
                                             boxHeight);
            //add balls to the set
            for(int i = 0; i < numberofBalls; i++)
            {
                Color ballColor = new Color(rand.nextInt(240), 
         rand.nextInt(240), rand.nextInt(240));
                int x = randomPosition();
                int y = randomPosition();
                BoxBall boxBall = new BoxBall(x,y,16,ballColor, boxWidth,
                                                    boxHeight, myCanvas);
                balls.add(boxBall);
                boxBall.draw();
            }
        }
        
        /**
         * returns an int which represents the random position
         * between the bottom and top half of the box
         */
        private int randomPosition()
        {//had to parse as int for some reason
            int pos = boxHeight;
            return r.nextInt(pos);
        }
    }

