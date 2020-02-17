/*
Name: Abigail Natucci
Assignment: Lab02
Creative feature(s): Ellipse and Rectangle classes override the equals method in Object
*/

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Shape {
    private int a;
    private int b;

    /**
     * Constructs a Rectangle object with the given values.
     *
     * @param xVal the x position of the Ellipse
     * @param yVal the y position of the Ellipse
     * @param fill  whether or not this Ellipse should be drawn filled
     * @param c  the color of this ellipse
     * @param a the half-width of the ellipse
     * @param b the half-height of the ellipse
     */
    public Ellipse(int xVal, int yVal, int a, int b, boolean fill, Color c) {
        super(xVal, yVal, fill, c);
        this.a = a;
        this.b = b;

    }
    /**
     * Tests to determine whether or not the given point lies within this Ellipse.
     *
     * @param x the x-coordinate of the point to test
     * @param y the y-coordinate of the point to test
     * @return true if (x, y) is within (or on the border) of this Ellipse, false otherwise.
     */
    @Override
    public boolean contains(int x, int y) {
        double px = x -this.x;
        double py = y - this.y;
        return (px * px) / (a * a) + (py * py) / (b*b) <= 1.0;
    }

    /**
     * Draws this Ellipse to the given Graphics object.
     *
     * @param g the Graphics object to which this Ellipse will be drawn.
     */
    @Override
    public void draw(Graphics g) {
        int newX = x - a;
        int newY = y - b;
        g.setColor(this.color);
        g.drawOval(newX, newY, this.a*2, this.b*2);
        if(this.filled)
            g.fillOval(newX, newY, this.a*2, this.b*2);

    }
    /**
     * Returns a String suitable for writing to a file when saving this Shape object.
     * Subclasses will need to add additional information.
     *
     * @return a String representing this Ellipse
     */
    public String toString(){
        return "E " + this.x + " " + this.y + " " + this.filled + " " + this.color.getRed() + " " + this.color.getGreen() + " "
                + this.color.getBlue() + " " + this.a + " " + this.b;
    }

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