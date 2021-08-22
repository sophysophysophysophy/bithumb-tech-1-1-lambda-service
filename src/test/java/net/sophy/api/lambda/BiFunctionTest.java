package net.sophy.api.lambda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BiFunctionTest {

    @Test
    @DisplayName("Bifunction Test")
    void apply() {
        BiFunction<String, String, Integer> biFunction = (a, b) -> (a + b).length();
        assertThat(biFunction.apply("Hello", "Kim"), is(equalTo(8)));

    }
}
