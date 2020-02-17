import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KWArrayListTest {
    //tested constructor
    KWArrayList<String> kwListTest = new KWArrayList<String>(3);

    @Before
    public void setUp(){
        kwListTest.add(0, "first");
        kwListTest.add(1,"second");
        kwListTest.add(2, "third");
    }

    @Test
    public void testConstructor(){
        KWArrayList<String> kwListTest02 = new KWArrayList<String>(1);
        kwListTest02.add("one");
        Assert.assertEquals(1, kwListTest02.size());
    }

    @Test
    public void testAdd(){
        Assert.assertEquals("first", kwListTest.get(0));
        Assert.assertEquals("second", kwListTest.get(1));
        Assert.assertEquals("third", kwListTest.get(2));
        Assert.assertTrue(kwListTest.add(3, "fourth"));
    }
    @Test
    public void testClear(){
        kwListTest.clear();
        kwListTest.toString();
        Assert.assertEquals(0, kwListTest.size());
        Assert.assertEquals("[]", kwListTest.toString());
    }

    @Test
    public void testSet(){
        String s = kwListTest.set(0, "firstNew");
        Assert.assertEquals("first", s);
        Assert.assertEquals("firstNew", kwListTest.get(0));
    }

    @Test
    public void testContains(){
        Assert.assertTrue(kwListTest.contains("first"));
        Assert.assertFalse(kwListTest.contains("seventh"));
    }

    @Test
    public void testIsEmpty(){
        Assert.assertFalse(kwListTest.isEmpty());
        kwListTest.clear();
        Assert.assertTrue(kwListTest.isEmpty());
    }

    @Test
    public void testIndexOf(){
        Assert.assertEquals(0, kwListTest.indexOf("first"));
        Assert.assertEquals(1, kwListTest.indexOf("second"));
        Assert.assertEquals(2, kwListTest.indexOf("third"));
    }

    @Test
    public void testIndexOf02(){
        Assert.assertEquals(1, kwListTest.indexOf("second"));
    }

    @Test
    public void testIndexOf03(){
        Assert.assertEquals(-1, kwListTest.indexOf("fourth"));
    }

    @Test
    public void testLastIndexOf(){
        kwListTest.add(3, "first");
        Assert.assertEquals(3, kwListTest.lastIndexOf("first"));
    }

    @Test
    public void testLastIndexOf02(){
        Assert.assertEquals(-1, kwListTest.lastIndexOf("fourth"));
    }

    @Test
    public void testRemove(){
        kwListTest.remove("first");
        Assert.assertEquals("second", kwListTest.get(0));
        Assert.assertEquals("third", kwListTest.get(1));
        Assert.assertEquals(2, kwListTest.size());
        Assert.assertEquals("[second, third]", kwListTest.toString());
    }

    @Test
    public void testRemove02(){
        Assert.assertTrue(kwListTest.remove("first"));
        Assert.assertTrue(kwListTest.remove("second"));
        Assert.assertTrue(kwListTest.remove("third"));
        Assert.assertEquals(0, kwListTest.size());
        Assert.assertEquals("[]", kwListTest.toString());
    }

    @Test
    public void testRemove03(){
        Assert.assertFalse(kwListTest.remove("fourth"));
        kwListTest.remove("second");
        Assert.assertEquals("[first, third]", kwListTest.toString());
    }

}
