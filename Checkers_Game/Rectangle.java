import java.awt.*;
public class Rectangle extends Shape {
    private int height;
    private int width;

    /**
     * Constructs a Rectangle object with the given values.
     *
     * @param xVal the x position of the Rectangle
     * @param yVal the y position of the Rectangle
     * @param fill  whether or not this Rectangle should be drawn filled
     * @param c  the color of this rectangle
     * @param w the width of the rectangle
     * @param h the height of the rectangle
     */
    public Rectangle(int xVal, int yVal, int w, int h, boolean fill, Color c) {
        super(xVal, yVal, fill, c);
        this.height = h;
        this.width = w;

    }

    public int getWidth(){
        return this.width;
    }

    /**
     * Tests to determine whether or not the given point lies within this Rectangle.
     *
     * @param x the x-coordinate of the point to test
     * @param y the y-coordinate of the point to test
     * @return true if (x, y) is within (or on the border) of this Rectangle, false otherwise.
     */
    @Override
    public boolean contains(int x, int y){
        double px = this.x;
        double py = this.y;
        return (x >= px) && (y >= py) && (x <= (px + width)) && (y <= (py + this.height));
    }

    /**
     * Draws this Rectangle to the given Graphics object.
     *
     * @param g the Graphics object to which this Rectangle will be drawn.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect (x, y, width, height);
        if(this.filled == true)
            g.fillRect (x, y, width, height);
    }
    /**
     * Returns a String suitable for writing to a file when saving this Shape object.
     * Subclasses will need to add additional information.
     *
     * @return a String representing this Rectangle
     */
    public String toString(){
        return "R " + this.x + " " + this.y + " " + this.filled + " " + this.color.getRed() + " " + this.color.getGreen() + " "
                + this.color.getBlue() + " " + this.width + " " + this.height;
    }

    /**
     2 * Returns true if other is the same type, and has the same values for all of
     3 * the instance variables (including superclass variables) as this object.
     4 *
     5 * @param other Any Object.
     6 * @return true if this is equal to other as specified above.
     7 */
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Rectangle))return false;
        if(this.toString().equals(other.toString()))
            return true;
        else{
            return false;
        }
    }
}