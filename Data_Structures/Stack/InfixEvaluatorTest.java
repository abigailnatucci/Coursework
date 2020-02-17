import org.junit.Assert;
import org.junit.Test;

public class InfixEvaluatorTest {
        @Test
        public void testExpression01() {
                Assert.assertEquals( 1, InfixEvaluator.evaluate("7 - 3 * 2") );
        }

        @Test
        public void testExpression02() {
                Assert.assertEquals(8, InfixEvaluator.evaluate("( 7 - 3 ) * 2"));
        }

        @Test
        public void testExpression03() {
                Assert.assertEquals( 18, InfixEvaluator.evaluate("2 * 3 ^ 2") );
        }
        @Test
        public void testExpression04(){
                Assert.assertEquals(2, InfixEvaluator.evaluate(" ( 40 - 5 * 4 ) / ( 4 * 2 + 2 ) "));
        }
}
