import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

/**
 * Tests for the Ellipse class.  Use this a starting point, you may want to create more.
 */
public class EllipseTest {

    private Ellipse el;
    private Ellipse e2;
    private Ellipse e3;

    @Before
    public void setUpEllipse() {
        el = new Ellipse(600, 200, 300, 100, false, new Color(1,2,3));
        e2 = new Ellipse(600, 200, 300, 100, false, new Color(1,2,3));
        e3 = new Ellipse(600, 100, 200, 100, false, new Color(1, 2, 3));
    }

    @Test
    public void testContains01() {
        // Contains center point
        Assert.assertTrue( el.contains(600,200));
    }

    @Test
    public void testContains02() {
        // right edge
        Assert.assertTrue( el.contains(899,200));
    }

    @Test
    public void testContains03() {
        // left edge
        Assert.assertTrue( el.contains(301,200));
    }

    @Test
    public void testContains04() {
        // top
        Assert.assertTrue( el.contains(600,101));
    }

    @Test
    public void testContains05() {
        // bottom
        Assert.assertTrue( el.contains(600,299));
    }

    @Test
    public void testContains06() {
        // Way off
        Assert.assertFalse( el.contains(1000,1000));
    }

    @Test
    public void testContains07() {
        // right edge
        Assert.assertFalse( el.contains(901,200));
    }

    @Test
    public void testContains08() {
        // left edge
        Assert.assertFalse( el.contains(299,200));
    }

    @Test
    public void testContains09() {
        // top
        Assert.assertFalse( el.contains(600,99));
    }

    @Test
    public void testContains10() {
        // bottom
        Assert.assertFalse( el.contains(600,301));
    }

    @Test
    public void testToString() {
        Assert.assertEquals( "E 600 200 false 1 2 3 300 100", el.toString());
    }

    @Test
    public void testEquals(){
        Assert.assertFalse(e2.equals(e3));
        Assert.assertTrue(el.equals(e2));
    }
}

