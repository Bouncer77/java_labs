import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.Assert.*;

public class MathFuncTest {

    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(MathFuncTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());

        result = runner.run(Numbers.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }


    /*expected - указываем какое исключение будет сгенерировано методом (см. пример ниже);
    timeout - через какое время в милисекундах прекратить выполнение теста и засчитать его как неуспешный.*/
    // @Ignore пропустить тест
    // Метод, помеченный @Before будет выполняться перед каждым тестовым случаем,
    // а метод, помеченный @After - после каждого тестового случая.

    // один раз - соответственно до и после всех тестов - то используйте пару аннотаций @BeforeClass и @AfterClass.

    private MathFunc math;

    @Before
    public void init() { math = new MathFunc(); }

    @After
    public void tearDown() { math = null; }

    @Test
    public void getCalls() {
        assertEquals(0, math.getCalls());

        math.factorial(1);
        assertEquals(1, math.getCalls());

        math.plus(1, 1);
        assertEquals(2, math.getCalls());
    }

    @Test
    public void factorial() {
        assertTrue(math.factorial(0) == 1);
        assertTrue(math.factorial(1) == 1);
        assertTrue(math.factorial(5) == 120);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialNegative() {
        math.factorial(-1);
    }

    @Test
    public void plus() {
        //assertTrue(math.plus(1, 1) == 3);
        assertEquals(math.plus(1,2), 3);
    }

    @Ignore
    @Test
    public void todo() {
        assertTrue(math.plus(1, 1) == 3);
    }
}

/*assertEquals - ожидаемый результат и полученный результат совпадают;
assertNull - результатом выражения есть null;
assertNotNull - результат выражения отличен от null;
assertSame - ожидаемый и полученный объекты это один и тот же объект.
fail - метод генерирует исключение AssertionError - добавляем туда, куда не должен дойти ход выполнения программы.*/