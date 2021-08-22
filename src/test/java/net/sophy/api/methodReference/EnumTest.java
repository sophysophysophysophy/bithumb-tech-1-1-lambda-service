package net.sophy.api.methodReference;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleBinaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;


public class EnumTest {
    // 메모리에 {} (스콥)을 잡아먹으면 주소값을 가짐. (function)  cf) interface는 {}가 없음. 객체가 아님.

//    enum : 열거형

    @RequiredArgsConstructor
    enum Operation {
//        객체들.. (기능과 속성을 갖췄음)
        PLUS("+", (x, y) -> x + y),          // () -> 생성자. all args 상태. PLUS() -> No args 상태
        MINUS("-", (x, y) -> x - y),
        TIMES("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);

        //        인스턴스 변수
        private final String symbol;
        private final DoubleBinaryOperator operator;
        @Override public String toString(){return symbol;}

        public double apply(double x, double y) {
            return operator.applyAsDouble(x, y);
    }

    @Test
    @DisplayName("Enum 테스트")
    void apply(){
        assertThat(Operation.PLUS.apply(5, 7), is(equalTo(12.0)));
        assertThat(Operation.MINUS.apply(5, 7), is(equalTo(-2.0)));
        assertThat(Operation.TIMES.apply(5, 7), is(equalTo(35.0)));
        assertThat(Operation.DIVIDE.apply(14, 7), is(equalTo(2.0)));
    }
}


}
