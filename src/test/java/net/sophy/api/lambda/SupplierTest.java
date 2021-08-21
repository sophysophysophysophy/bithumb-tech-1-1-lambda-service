package net.sophy.api.lambda;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.jupiter.api.Assertions.*;

public class SupplierTest {

    @Test
    @DisplayName("Supplier 테스트")
    void get() {
        Supplier<String> stringSupplier = () -> new String("No Pain, No Gain");            //return type이 string이라고 선언
        String result = stringSupplier.get();
        assertThat(result, is(equalTo("No Pain, No Gain")));

        Supplier<Double> integerSupplier = () -> Math.random();             // supplier: parameter value 없고, return값만 있기 때문에 선언할 때 return type만 선언한다.
        double resultDouble = integerSupplier.get();
        System.out.println("resultDouble = " + resultDouble);

//        supplier는 parameter값이 없기 때문에 매개변수 자리가 불필요함 (제거가능) -> 메소드 레퍼런스 가능 .
//        왜 람다가 아닌 메소드 레퍼런스로 사용? -> 오컴의 면도날 (경제성의 원리) : 심플, 간결 (성능차이x)
        Supplier<Double> integerSupplierMethodRefer = Math::random;
        double resultDoubleMR = integerSupplierMethodRefer.get();
        System.out.println("resultDoubleMR = " + resultDoubleMR);
    }
}
