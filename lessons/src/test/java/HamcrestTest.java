import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestTest {
    @Test
    public void test() {
        String result = "one";
        assertThat(result, anything());
        assertThat(result, is(anything()));
        assertThat(result, is("one"));
        assertThat(result, not("two"));
        assertThat(result, any(String.class));
        assertThat(result, is(any(String.class)));
        assertThat(result, anyOf(containsString("one"), containsString("two")));
        assertThat(result, allOf(containsString("one")));
        assertThat(result, equalTo("one"));
        assertThat(result, instanceOf(String.class));
        assertThat(result, notNullValue());
        assertThat(result, sameInstance(result));

        List<Integer> listResult = Arrays.asList(1, 4, 6);
        assertThat(listResult, hasItem(4));
        assertThat(listResult, hasItems(4,6));
        Integer[] arrayResult = {1,2,7,5,4,8};
        assertThat(arrayResult, hasItemInArray(4));

        double d = 6.3;
        assertThat(d, closeTo(6, 0.5));
        int i = 6;
        assertThat(i, greaterThan(5));

        String s = "hello";
        assertThat(s, equalToIgnoringCase("HelLo"));
        assertThat(s, equalToIgnoringWhiteSpace("hello"));
        assertThat(s, containsString("hel"));
    }
}