package net.sophy.api.lambda;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class FunctionTest {

    @Test
    @DisplayName("Function Test")
    void apply() {
        List<String> list = Arrays.asList("Bithumb", "Cooperation", "Market");

//        선언 -> 실행 -> 테스트
        Function<String, Integer> function = String::length;
        int count = function.apply(list.get(1));
        assertThat(count, is(equalTo(11)));

//        List<Integer> newList = convertToLength(list);
//        for (int i : newList) {
//            System.out.println("i = " + i);
//        }


        List<Integer> newList = convertToLength(list, function);
        System.out.println("newList = " + newList);
        assertThat(newList.get(0), is(equalTo(7)));
    }


//    private static <T,R> List<Integer> convertToLength(List<String> list) {
//        return list.stream().map(String::length).collect(Collectors.toList());
//    }
//


//    가장 복잡한 제네릭 구조.
//    param : data , function
    private static <T,R> List<R> convertToLength(List<T> list, Function<T,R> function) {
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(function.apply(t));
        }
        return newList;
    }

}
