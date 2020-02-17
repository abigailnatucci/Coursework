import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class BinarySearchTreeTest {
    private BinarySearchTree<String> tree = new BinarySearchTree<>();

    @Test
    public void testSize01() {
        Assert.assertEquals(0, tree.size());
    }

    @Test
    public void testSize02() {
        tree.add("one");
        tree.add("two");
        tree.add("three");
        tree.add("four");
        tree.add("five");
        Assert.assertEquals(5, tree.size());
    }

    @Test
    public void testInteriorNodes01() {
        Assert.assertEquals(0, tree.interiorNodes());
    }

    @Test
    public void testInteriorNodes02() {
        tree.add("one");
        tree.add("two");
        tree.add("three");
        tree.add("four");
        Assert.assertEquals(2, tree.interiorNodes());
    }

    @Test
    public void testInteriorNodes03() {
        tree.add("one");
        tree.add("two");
        Assert.assertEquals(1, tree.interiorNodes());
    }

    @Test
    public void testFindMin01() {
        Assert.assertEquals(null, tree.findMin());
    }

    @Test
    public void testFindMin02() {
        tree.add("one");
        Assert.assertEquals("one", tree.findMin());
    }

    @Test
    public void testFindMin03() {
        tree.add("one");
        tree.add("two");
        Assert.assertEquals("one", tree.findMin());
    }

    @Test
    public void testFindMax01() {
        Assert.assertEquals(null, tree.findMax());
    }

    @Test
    public void testFindMax02() {
        tree.add("one");
        tree.add("two");
        Assert.assertEquals("two", tree.findMax());
    }

    @Test
    public void testFindMax03() {
        tree.add("one");
        Assert.assertEquals("one", tree.findMax());
    }

    @Test
    public void testInorder01(){
        tree.add("a");
        tree.add("b");
        tree.add("c");
        tree.add("d");
        tree.add("e");
        Assert.assertEquals("a b c d e", tree.inorder());
    }

    @Test
    public void testInorder02(){
        tree.add("one");
        Assert.assertEquals("one", tree.inorder());
    }

    @Test
    public void testPreorder01(){
       tree.add("a");
       tree.add("b");
       tree.add("c");
        Assert.assertEquals("b a c", tree.preorder());
    }

    @Test
    public void testPreOrder02(){
        Assert.assertEquals("", tree.preorder());
    }

    @Test
    public void testPostOrder01(){
        tree.add("a");
        tree.add("b");
        tree.add("c");
        tree.add("d");
        Assert.assertEquals("d c b a", tree.postorder());
    }

    @Test
    public void testPostOrder02(){
        Assert.assertEquals("", tree.postorder());
    }

    @Test
    public void testremoveMin01(){
        tree.add("one");
        tree.add("two");
        tree.add("three");
        Assert.assertTrue(tree.removeMin());
        Assert.assertEquals("((three)two)", tree.toString());
    }

    @Test
    public void testremoveMax01(){
        tree.add("one");
        tree.add("two");
        tree.add("three");
        Assert.assertTrue(tree.removeMax());
        Assert.assertEquals("(one(three))", tree.toString());
    }

    @Test (expected = NoSuchElementException.class)
    public void testRemoveMin02(){
        tree.removeMin();
    }

    @Test (expected = NoSuchElementException.class)
    public void testRemoveMax02(){
        tree.removeMax();
    }

    @Test
    public void testleaves01(){
        Assert.assertEquals(0, tree.leaves());
    }

    @Test
    public void testleaves02(){
        tree.add("a");
        tree.add("b");
        tree.add("c");
        Assert.assertEquals(1, tree.leaves());
    }

    @Test
    public void testLeaves03(){
        tree.add("one");
        Assert.assertEquals(1, tree.leaves());
    }

    @Test
    public void testHeight01(){
        Assert.assertEquals(0, tree.height());
    }

    @Test
    public void testHeight02(){
        tree.add("a");
        tree.add("b");
        tree.add("c");
        tree.add("d");
        tree.add("e");
        Assert.assertEquals(4, tree.height());
    }

   @Test
    public void testBreadth01(){
        Assert.assertEquals("", tree.breadthFirstOrder());
    }

    @Test
    public void testBreadth02(){
        tree.add("a");
        tree.add("b");
        tree.add("c");
        Assert.assertEquals("a b c", tree.breadthFirstOrder());
    }
}
