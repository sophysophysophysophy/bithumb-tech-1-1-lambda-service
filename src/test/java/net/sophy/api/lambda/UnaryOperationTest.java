package net.sophy.api.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
class UnaryOperationTest {

    @Test
    @DisplayName("단항식 테스트")
    void apply() {
        List<Integer> list = Arrays.asList(10,20,30,40,50);
        UnaryOperator<Integer> unaryOperator = x -> x * 100;

        List<Integer> newList = mapper(list, unaryOperator);

        assertThat(newList, is(equalTo(Arrays.asList(1000, 2000, 3000, 4000, 5000))));
    }

    private static <T> List<T> mapper(List<T> list, UnaryOperator<T> unaryOperator) {
        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            resultList.add(unaryOperator.apply(t));
        }
        return resultList;
    }
}