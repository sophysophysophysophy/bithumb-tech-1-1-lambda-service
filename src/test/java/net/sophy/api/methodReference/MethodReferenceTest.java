package net.sophy.api.methodReference;

import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    class MethodReferenceClass {
//        Supplier<Date> newDate = Date::new;
//        Consumer<String> print = System.out::println;

        //        Integer.parseInt("45") === 45;
        Function<String, Integer> integerParseInt = Integer::parseInt;



//        util classes
        Supplier<Date> newDate = Date::new;
        Supplier<Double> doubleRandom = Math::random;
        Consumer<String> print = System.out::print;
        Function<Object, String> objectToString = String::valueOf;
        Function<String, Integer> stringToInteger = Integer::parseInt;
        Function<Double, Double> doubleAbs = Math::abs;
        Function<Float, Float> floatAbs = Math::abs;
        Function<Integer, Integer> integerAbs = Math::abs;
        Function<Long, Long> longAbs = Math::abs;
        Function<Double, Double> doubleCeil = Math::ceil;
        Function<Double, Double> doubleFloor = Math::floor;
        Function<Double, Double> doubleRint = Math::rint;
        Function<Double, Long> doubleRound = Math::round;
        Function<Float, Integer> floatRound = Math::round;
        BiFunction<Double, Double, Double> doubleMax = Math::max;
        BiFunction<Float, Float, Float> floatMax = Math::max;
        BiFunction<Integer, Integer, Integer> integerMax = Math::max;
        BiFunction<Long, Long, Long> longMax = Math::max;
        BiFunction<Double, Double, Double> doubleMin = Math::min;
        BiFunction<Float, Float, Float> floatMin = Math::min;
        BiFunction<Integer, Integer, Integer> integerMin = Math::min;
        BiFunction<Long, Long, Long> longMin = Math::min;
        BiFunction<Integer, Integer, Integer> rangeUnderRandom = (t, u) -> (int) (Math.random() * (u - t)) + t;
        BiFunction<Integer, Integer, Integer> rangeBelowRandom = (t, u) -> (int) (Math.random() * u) + t;



    }
}
