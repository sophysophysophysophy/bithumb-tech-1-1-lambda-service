package net.sophy.api.lambda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.function.BinaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class BinaryOperatorTest {
    @Test
    @DisplayName("Binary Operator Test")
    void apply(){
        BinaryOperator<String> operator = (a,b) -> a + "." + b ;
        String res = operator.apply("test", "com");
        assertThat(res, is(equalTo("test.com")));
    }
}
