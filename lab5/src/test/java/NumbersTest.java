import static org.junit.Assert.assertEquals;

public class NumbersTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void sum() {
        Numbers numbers = new Numbers();
        int actual = numbers.sum(5);
        int expected = 15;
        assertEquals(expected, actual);
    }
}