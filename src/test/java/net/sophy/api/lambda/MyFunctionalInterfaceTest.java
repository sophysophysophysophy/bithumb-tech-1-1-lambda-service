package net.sophy.api.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


import static org.junit.jupiter.api.Assertions.*;

class MyFunctionalInterfaceTest {

    @BeforeEach
    void setUp() {
    }

    @Test @DisplayName("FunctionalInterfaceTest")   //unit test
    void myMethod() {
        MyFunctionalInterface fun = () -> "Hello Functional Interface";         //thin arrow. fun 객체가 없어지는 순간 해당 함수도 제거됨.
        assertThat(fun.myMethod(), is(equalTo("Hello Functional Interface")));
    }

    @Test @DisplayName("Imperative vs Declarative")
    void main() {
//        Imperative(명령형)
        int sumOfEvens = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                sumOfEvens += i;
            }
        }

        System.out.println("Imperative sumOfEvens is " + sumOfEvens);

//        Declarative
        sumOfEvens = IntStream.rangeClosed(0, 100)
                .filter(i -> i % 2 == 0)
                .reduce((x, y) -> x + y) // 여기까지는 StreamType
                .getAsInt();        // int형으로 반납

        System.out.println("Declarative sumOfEvens is " + sumOfEvens);
    }
}