package net.sophy.api.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test {

//  wildcard  : object  : <?>
//    제네릭 : <T> -> type
    <T> List<T> test1(List<T> list) {
        List<T> a = new ArrayList<T>();
        return a;
    }

    private <T> void print(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }


//    제네릭에 대한 설명
//    객체지향의 4가지 특징 : 은닉화 , 상속, 추상화, 다형성 : (Overriding, Overloading) + 제네릭(일반화), 와일드카드!(중요)
//    제네릭 : 일반화. 일반화라는 것은 결국 추상화와 같은 의미. <> (앵글 브레이스) . 선언할 때 사용
//    제네릭 메소드 : 메소드에서만 한정적으로 사용하는 제네릭 타입. 선언문 접근지정자 다음에 선언하여 사용.
}
