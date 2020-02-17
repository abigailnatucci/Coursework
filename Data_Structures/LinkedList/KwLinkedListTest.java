import org.junit.Assert;
import org.junit.Test;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class KwLinkedListTest {
    @Test
    public void testConstructor01(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        ListIterator<String> iter = list.listIterator(0);
        Assert.assertEquals(iter.next(), "one");
    }

    @Test
    public void testConstructor02(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        ListIterator<String> iter = list.listIterator(list.size());
        Assert.assertEquals(iter.previous(), "two");
    }

    @Test (expected = NoSuchElementException.class)
    public void testRemoveFwdIterOutOfBounds(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.next();
        iter.remove();
    }

    @Test
    public void testRemoveFirstTwoItemsFwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.remove();
        Assert.assertEquals(list.toString(), "[two]");
        Assert.assertEquals(0, iter.nextIndex());
        Assert.assertEquals(-1, iter.previousIndex());
    }

    @Test
    public void testRemoveFirstThreeItemsFwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.remove();
        Assert.assertEquals(list.toString(), "[two, three]");
        Assert.assertEquals(0, iter.nextIndex());
        Assert.assertEquals(-1, iter.previousIndex());
    }


    @Test
    public void testRemoveTailFwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.next();
        iter.remove();
        Assert.assertEquals(list.toString(), "[one]");
        Assert.assertEquals(1, iter.nextIndex());
        Assert.assertEquals(0, iter.previousIndex());
    }

    @Test
    public void testRemoveTailFwdThreeItemsFwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.next();
        iter.next();
        iter.remove();
        Assert.assertEquals(list.toString(), "[one, two]");
        Assert.assertEquals(2, iter.nextIndex());
        Assert.assertEquals(1, iter.previousIndex());
    }

    @Test
    public void testRemoveOnlyFwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.remove();
        Assert.assertEquals(list.toString(), "[]");
        Assert.assertEquals(0, iter.nextIndex());
        Assert.assertEquals(-1, iter.previousIndex());
    }


    @Test
    public void testRemoveMiddleOddNumFwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.next();
        iter.remove();
        Assert.assertEquals(list.toString(), "[one, three]");
        Assert.assertEquals(1, iter.nextIndex());
        Assert.assertEquals(0, iter.previousIndex());
    }

    @Test
    public void testRemoveMiddleEvenNumFwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.next();
        iter.remove();
        Assert.assertEquals(list.toString(), "[one, three, four]");
        Assert.assertEquals(1, iter.nextIndex());
        Assert.assertEquals(0, iter.previousIndex());
    }

    @Test
    public void testRemoveTail2Bkwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        ListIterator<String> iter = list.listIterator(list.size());
        iter.previous();
        iter.remove();
        Assert.assertEquals(list.toString(), "[one]");
        Assert.assertEquals(1, iter.nextIndex());
    }

    @Test
    public void testRemoveFirstBkwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        ListIterator<String> iter = list.listIterator(list.size());
        iter.previous();
        iter.previous();
        iter.remove();
        Assert.assertEquals(list.toString(), "[two]");
        Assert.assertEquals(0, iter.nextIndex());
        Assert.assertEquals(-1, iter.previousIndex());
    }

    @Test
    public void testRemoveOnlyBkwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        ListIterator<String> iter = list.listIterator(list.size());
        iter.previous();
        iter.remove();
        Assert.assertEquals(list.toString(), "[]");
        Assert.assertEquals(0, iter.nextIndex());
        Assert.assertEquals(-1, iter.previousIndex());
    }

    @Test
    public void testRemoveMiddleOddNumBkwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        ListIterator<String> iter = list.listIterator(list.size());
        iter.previous();
        iter.previous();
        iter.remove();
        Assert.assertEquals(list.toString(), "[one, three]");
        Assert.assertEquals(1, iter.nextIndex());
        Assert.assertEquals(0, iter.previousIndex());
    }

    @Test
    public void testRemoveTailFwdThreeItemsBkwd(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        ListIterator<String> iter = list.listIterator(list.size());
        iter.previous();
        iter.remove();
        Assert.assertEquals(list.toString(), "[one, two]");
        Assert.assertEquals(2, iter.nextIndex());
        Assert.assertEquals(1, iter.previousIndex());
    }

    @Test (expected = NoSuchElementException.class)
    public void testRemoveBkwdIterOutOfBounds(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        ListIterator<String> iter = list.listIterator(list.size());
        iter.previous();
        iter.previous();
        iter.remove();
    }


    @Test (expected = IllegalStateException.class)
    public void testRemoveLastItemReturnedNull(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        ListIterator<String> iter = list.listIterator(list.size());
        iter.remove();
    }

    @Test
    public void testSet01(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.set("SetValue");
        Assert.assertEquals(list.toString(), "[SetValue, two]");
    }

    @Test
    public void testSet02(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.set("SetValue");
        Assert.assertEquals(list.toString(), "[SetValue]");
    }

    @Test (expected = IllegalStateException.class )
    public void testSet03(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        ListIterator<String> iter = list.listIterator();
        iter.set("setValue");
    }

    @Test
    public void testIndexOf01(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        Assert.assertEquals(0, list.indexOf("one"));
    }

    @Test
    public void testIndexOf02(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("three");
        list.add("two");
        list.add("one");
        Assert.assertEquals(2, list.indexOf("one"));
    }

    @Test
    public void testIndexOf03(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("one");
        Assert.assertEquals(0, list.indexOf("one"));
    }

    @Test
    public void testIndexOf04(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("three");
        list.add("one");
        list.add("two");
        Assert.assertEquals(1, list.indexOf("one"));
    }

    @Test
    public void testLastIndexOf01(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("one");
        Assert.assertEquals(1, list.lastIndexOf("one"));
    }

    @Test
    public void testLastIndexOf02(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("one");
        Assert.assertEquals(2, list.lastIndexOf("one"));
    }

    @Test
    public void testLastIndexOf03(){
        KWLinkedList<String> list = new KWLinkedList<String>();
        list.add("one");
        Assert.assertEquals(0, list.lastIndexOf("one"));
    }



}
