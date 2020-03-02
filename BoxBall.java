import java.awt.*;
import java.awt.geom.*;
/**
 * program generates a given value of balls that bounce at random
 * speeds, starting at random positions.
 * @author Alexander Kampf
 * @date 2/29/20
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int height;
    private int width;
    private Canvas canvas;
    private int ySpeed;
    private int xSpeed;
    private int distance = 7;


    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int xPos,int yPos, int ballDiam,
                Color ballColor, int boxWidth,
                int boxHeight, Canvas drawingCanvas)
    {//the ball cannot be placed outside the box
        if(xPos >= boxWidth)
            xPosition = xPos - distance;
        else
            xPosition = xPos;
        
        if(yPos >= boxHeight)
            yPosition = yPos - distance;
        else
            yPosition = yPos;
        color = ballColor;
        diameter = ballDiam;
        width = boxWidth;
        height = boxHeight;
        canvas = drawingCanvas;
        //was getting double conversion errors before I set the
        //speed up like this. No idea why this works honestly
        xSpeed = (int) (Math.random() * 20) + 1;
        ySpeed = (int)(Math.random() * 20) + 1;
           
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
     /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    } 
    
    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {   //remove the ball s it can be repositioned
        erase();
        
        int radius = diameter / 2;
        
        //the x/y positions need to lie in respect
        //to the speed
        xPosition += xSpeed;
        yPosition += ySpeed;
        
        /*
         * if the x position is < 0, speed and 
         * position must change
         */
        if(xPosition - radius - distance <= 0)
        {
            //bounce the ball off of the walls
            xSpeed = -xSpeed;
            xPosition = radius + distance;
        } 
        
        /*
         * if the x position is >= the width,
         * speed and position must change
         */
        else if (xPosition + radius >= width)
        {
            xSpeed= -xSpeed;
            xPosition = width - radius;
        }
        
        /*
         * if the y position is <= 0,
         * speed and position must change
         */
        if (yPosition - radius - distance <= 0)
        {
            ySpeed = -ySpeed;
            yPosition = radius + distance;
        }
        
        /*
         * if the y position is >= the height,
         * position and speed must change
         */
        else if(yPosition + radius >= height)
        {
            ySpeed = -ySpeed;
            yPosition = height - radius;
        }
        
        //redraw at the new position'
        draw();
       
    }
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    

}
