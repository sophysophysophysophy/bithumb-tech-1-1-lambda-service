package net.sophy.api.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.jupiter.api.Assertions.*;

class MathOperationTest {

    @BeforeEach
    void setUp() {
    }

    @Test @DisplayName("사칙연산 프로그램")
    void apply() {
        MathOperation mathOperation = (a, b) -> a + b;          //선언
        int result = mathOperation.apply(2, 7);           //실행
        assertThat(result, is(equalTo(9)));             //테스트
    }
}