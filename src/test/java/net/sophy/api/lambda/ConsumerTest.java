package net.sophy.api.lambda;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.jupiter.api.Assertions.*;

public class ConsumerTest {

    @Test
    @DisplayName("Consumer 테스트")
    void accept() {
        List<Integer> list = Arrays.asList(1, 2, 3);    // new로 객체를 생성하는 것 : 비용이 비쌈,, 잘 안씀!
        Consumer<Integer> consumer = System.out::println;           // soutc : 대표적인 consumer

//        System.out.println(); -> 비용이 비쌈. static으로 생성. 메모리 많이 차지
//        그러한 메소드 행위를 consumer 객체에 위임함
        consumer.accept(33);

//        function(데이터, 함수); -> 형태로 많이 사용됨.
//        ex) messageQueue(데이터, 기능)
        print(list, consumer);  // 기능(함수)까지 같이 넘김.. 클래식 자바에서는 데이터만 전달하지만 모던자바에서는 function도 전달 가능
        assertThat(list.get(1), is(equalTo(2)));
    }

//     제네릭 메소드
    private static <T> void print(List<T> list, Consumer<T> consumer) {
        for (T t: list) {
            consumer.accept(t);
        }
    }
}
