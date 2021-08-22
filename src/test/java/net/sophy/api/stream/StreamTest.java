package net.sophy.api.stream;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;


public class StreamTest {

//    stream : 계속 데이터가 흐르게 개발. 이를 구독해야만 정보 가질 수 있음.
//    nonblocking : 흐르는 데이터를 막지않는다.
//    async : 일방적으로 데이터 전송 (비동기)
//    sync : 전화. async : 단방향. 카톡|메세지

//    Non Blocking ( <-> iterative)
//    async ( <-> sync)



    @Test
    @DisplayName("Stream 테스트")
    void apply() {
        List<String> sBlocking = Arrays.asList("Apple", "Orange", "");      //blocking
        Stream<String> sStream = Arrays.asList("Apple", "Orange", "").stream();      //non-blocking
        int emptyString = (int) sStream.filter(String::isEmpty).count();

        assertThat(emptyString, is(equalTo(1)));
    }
}
