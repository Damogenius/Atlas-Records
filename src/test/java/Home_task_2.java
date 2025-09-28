import org.junit.Test;
import static org.junit.Assert.*;

public class Home_task_2 {

    @Test
    public void testCompareWhenFirstIsGreater() {
        Junit4Test tester = new Junit4Test();
        int result = tester.compare(10, 5);
        assertEquals(1, result);
    }

    @Test
    public void testCompareWhenFirstIsLess() {
        Junit4Test tester = new Junit4Test();
        int result = tester.compare(3, 7);
        assertEquals(-1, result);
    }

    @Test
    public void testCompareWhenBothAreEqual() {
        Junit4Test tester = new Junit4Test();
        int result = tester.compare(5, 5);
        assertEquals(-1, result);
    }
}

