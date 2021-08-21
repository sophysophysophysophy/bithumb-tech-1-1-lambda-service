package net.sophy.api.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class LengthOfStringTest {

    @Test @DisplayName("문자열의 길이 반환 테스트")
    void apply() {
        LengthOfString lengthOfStringAns = str -> {
            int i = str.length();
            System.out.println("문자열길이 = " + i);
            return str.length();
        };

        assertThat(lengthOfStringAns.apply("apple"), is(equalTo(5)));

        LengthOfString lengthOfStringZero = str -> 0;
        assertThat(lengthOfStringZero.apply("apple"), is(equalTo(0)));

        LengthOfString lengthOfString = str -> str.length();    //선언
        int result = lengthOfString.apply("apply");         //실행
        assertThat(result, is(equalTo(5)));             //테스트
    }

}