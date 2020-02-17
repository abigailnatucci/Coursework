import java.awt.*;

/**
 * An abstract superclass for all Shapes in Jane's 2D game engine.
 */
public abstract class Shape {

    /**
     * The x and y coordinates of the Shape.  The meaning of these varies for each
     * shape.  For example, it may mean the center for some, or the upper left for
     * others.
     */
    protected int x, y;

    /**
     * true when the Shape is to be drawn filled with a color,
     * otherwise, just the outline is drawn.
     */
    protected boolean filled;

    /**
     * The color of this Shape (or it's outline).
     */
    protected Color color;

    /**
     * Constructs a Shape object with the given values.
     *
     * @param px the x position of the Shape
     * @param py the y position of the Shape
     * @param f  whether or not this Shape should be drawn filled
     * @param c  the color of this shape
     */
    public Shape(int px, int py, boolean f, Color c) {
        x = px;
        y = py;
        filled = f;
        color = c;
    }

    /**
     * Tests to determine whether or not the given point lies within this Shape.
     *
     * @param x the x-coordinate of the point to test
     * @param y the y-coordinate of the point to test
     * @return true if (x, y) is within (or on the border) of this Shape, false otherwise.
     */
    public abstract boolean contains(int x, int y);

    /**
     * Draws this Shape to the given Graphics object.
     *
     * @param g the Graphics object to which this Shape will be drawn.
     */
    public abstract void draw(Graphics g);

    /**
     * Returns a String suitable for writing to a file when saving this Shape object.
     * Subclasses will need to add additional information.
     *
     * @return a String representing this Shape
     */
    public String toString() {
        return String.format("%d %d %s %d %d %d", x, y, filled, color.getRed(), color.getGreen(), color.getBlue());
    }

}
