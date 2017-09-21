import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorTest {

    @Before
    public void before1() {
        System.out.println("before1");
    }
    @Before
    public void before2() {
        System.out.println("before2");
    }
    @After
    public void after1() {
        System.out.println("after1");
    }
    @After
    public void after2() {
        System.out.println("after2");
    }

    @BeforeClass
    public static void beforeClass1() {
        System.out.println("beforeClass1");
    }
    @BeforeClass
    public static void beforeClass2() {
        System.out.println("beforeClass2");
    }
    @AfterClass
    public static void afterClass1() {
        System.out.println("afterClass1");
    }
    @AfterClass
    public static void afterClass2() {
        System.out.println("afterClass2");
    }


    int firstParam;
    int secondParam;
    int expected;

    public CalculatorTest(int firstParam, int secondParam, int expected) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Integer[]> setParams() {
        return Arrays.asList(new Integer[][]{
                {1,2,3},
                {3,5,8},
                {5,7,12}
        });
    }

    @Test(timeout = 10)
    public void add() throws Exception {
        System.out.println("test");
        Calculator calculator = new Calculator();
        int result = calculator.add(firstParam, secondParam);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = RuntimeException.class)
    @Ignore(value = "This is just a test")
    public void testDivException() throws Exception {
        Calculator calculator = new Calculator();
        calculator.div(5, 0);
    }
}
