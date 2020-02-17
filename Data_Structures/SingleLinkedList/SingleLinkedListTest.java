import org.junit.Assert;
import org.junit.Test;

public class SingleLinkedListTest {
    @Test
    public void testRemoveByInt01(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.remove(0);
        Assert.assertEquals(list.toString(), "[two, three]");
        list.remove(1);
        Assert.assertEquals(list.toString(), "[two]");
    }

    @Test
    public void testRemoveByInt02(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.remove(0);
        Assert.assertEquals(list.toString(), "[]");
    }

    @Test
    public void testRemoveByInt03(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.remove(2);
        Assert.assertEquals(list.toString(), "[one, two]");
    }

    @Test
    public void testRemoveByString01(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.remove("one");
        Assert.assertEquals(list.toString(), "[two, three]");
    }

    @Test
    public void testRemoveByString02(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.remove("two");
        Assert.assertEquals(list.toString(), "[one, three]");
    }

    @Test
    public void testRemoveByString03(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.remove("one");
        Assert.assertEquals(list.toString(), "[]");
    }

    @Test
    public void testRemoveByString04(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        Assert.assertFalse(list.remove("one"));
    }

    @Test
    public void testAdd01(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add2(1, "value");
        Assert.assertEquals(list.toString(), "[value, one, two, three]");
    }


    @Test
    public void testAdd02(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add2(2, "value");
        Assert.assertEquals(list.toString(), "[one, value, two, three]");
    }

    @Test
    public void testAdd03(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add2(3, "value");
        Assert.assertEquals(list.toString(), "[one, two, value, three]");
    }

    @Test
    public void testAdd04(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add2(4, "value");
        Assert.assertEquals(list.toString(), "[one, two, three, value]");
    }

    @Test
    public void testClear(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.clear();
        Assert.assertEquals(list.toString(), "[]");
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testContains(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        Assert.assertTrue(list.contains("one"));
    }

    @Test
    public void testContains02(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        Assert.assertTrue(list.contains("three"));
    }

    @Test
    public void testIndexOf01(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        Assert.assertEquals(1, list.indexOf("two"));
    }

    @Test
    public void testIndexOf02(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        Assert.assertEquals(2, list.indexOf("three"));
    }

    @Test
    public void testIndexOf03(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        Assert.assertEquals(0, list.indexOf("one"));
    }

    @Test
    public void testIsEmpty01(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmpty02(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testLastIndexOf01(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");
        Assert.assertEquals(3,list.lastIndexOf("one") );
    }

    @Test
    public void testLastIndexOf02(){
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        list.add("one");
        list.add("one");
        list.add("one");
        Assert.assertEquals(2,list.lastIndexOf("one") );
    }

}
