import org.junit.Assert;
import org.junit.Test;

public class ArrayQueueTest {
    ArrayQueue<String> q = new ArrayQueue<String>();
    @Test
    public void testIsEmpty() {
        Assert.assertTrue(q.isEmpty());
    }

    @Test
    public void testOffer (){
        q.offer("One");
        Assert.assertEquals("[One]", q.toString());
    }

    @Test
    public void testOffer02(){
        q.offer("one");
        q.offer("two");
        q.offer("three");
        Assert.assertEquals(("[one, two, three]"), q.toString());
    }

    @Test
    public void testSize(){
        q.offer("one");
        Assert.assertEquals(1, q.size());
    }

    @Test
    public void testSize02(){
        q.offer("one");
        q.offer("two");
        Assert.assertEquals(2, q.size());
    }

    @Test
    public void testSize03(){
        q.offer("one");
        q.offer("two");
        q.offer("three");
        Assert.assertEquals(3, q.size());
    }

    @Test
    public void testPoll(){
        q.offer("one");
        q.offer("two");
        q.offer("three");
        q.poll();
        Assert.assertEquals("[two, three]", q.toString());
    }

    @Test
    public void testPoll02(){
        q.offer("one");
        q.poll();
        Assert.assertEquals("[]", q.toString());
    }

    @Test
    public void testPoll03(){
        q.offer("one");
        q.offer("two");
        q.poll();
        Assert.assertEquals("[two]", q.toString());
    }

    @Test
    public void testRemove(){
        q.offer("one");
        q.offer("two");
        q.offer("three");
        q.remove();
        Assert.assertEquals("[two, three]", q.toString());
    }

    @Test
    public void testRemove02(){
        q.offer("one");
        q.remove();
        Assert.assertEquals("[]", q.toString());
    }

    @Test
    public void testRemove03(){
        q.offer("one");
        q.offer("two");
        q.remove();
        Assert.assertEquals("[two]", q.toString());
    }

    @Test
    public void testPeek(){
        q.offer("one");
        Assert.assertEquals("one", q.peek());
    }

    @Test
    public void testPeek02(){
        q.offer("one");
        Assert.assertEquals("one", q.element());
    }

    @Test
    public void testClear(){
        q.offer("one");
        q.offer("two");
        q.offer("three");
        q.clear();
        Assert.assertEquals(0, q.size());
    }

    @Test
    public void testClear02(){
        q.offer("one");
        q.offer("two");
        q.offer("three");
        q.clear();
        Assert.assertEquals(null, q.peek());
    }

    @Test
    public void testReallocate(){
        q.offer("one");
        q.offer("two");
        q.offer("three");
        q.offer("four");
        q.offer("five");
        q.offer("six");
        q.offer("seven");
        q.offer("eight");
        q.offer("nine");
        q.offer("ten");
        q.offer("capacity");
        q.offer("test");
        Assert.assertEquals("[one, two, three, four, five, six, seven, eight, nine, ten, capacity, test]", q.toString());
    }

    @Test
    public void testToString(){
        Assert.assertEquals("[]", q.toString());
    }

    @Test
    public void testToString02(){
        q.offer("String");
        Assert.assertEquals("[String]", q.toString());
    }

}
