import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

/**
 * Tests for the Ellipse class.  Use this a starting point, you may want to create more.
 */
public class RectangleTest {

    private Rectangle r1;
    private Rectangle r2;
    private Rectangle r3;

    @Before
    public void setUp() {
        r1 = new Rectangle(600, 200, 300, 100, false, new Color(1,2,3));
        r2 = new Rectangle(600, 200, 300, 100, false, new Color(1,2,3));
        r3 = new Rectangle(600, 100, 200, 100, false, new Color(1, 2, 3));
    }

    @Test
    public void testContains01() {
        // Contains center point
        Assert.assertTrue( r1.contains(600,200));
    }

    @Test
    public void testContains02() {
        // right edge
        Assert.assertTrue( r1.contains(899,200));
    }

    @Test
    public void testContains03() {
        // left edge
        Assert.assertTrue( r1.contains(300,200));
    }

    @Test
    public void testContains04() {
        // top
        Assert.assertTrue( r1.contains(600,100));
    }

    @Test
    public void testContains05() {
        // bottom
        Assert.assertTrue( r1.contains(600,299));
    }

    @Test
    public void testContains06() {
        // Way off
        Assert.assertFalse( r1.contains(1000,1000));
    }

    @Test
    public void testContains07() {
        // right edge
        Assert.assertFalse( r1.contains(901,200));
    }

    @Test
    public void testContains08() {
        // left edge
        Assert.assertFalse( r1.contains(299,200));
    }

    @Test
    public void testContains09() {
        // top
        Assert.assertFalse( r1.contains(600,99));
    }

    @Test
    public void testContains10() {
        // bottom
        Assert.assertFalse( r1.contains(600,301));
    }

    @Test
    public void testToString() {
        Assert.assertEquals( "R 600 200 false 1 2 3 300 100", r1.toString());
    }

    @Test
    public void testEquals(){
        Assert.assertFalse(r2.equals(r3));
        Assert.assertTrue(r1.equals(r2));
    }
}