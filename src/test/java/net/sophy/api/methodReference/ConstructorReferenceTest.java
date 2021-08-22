package net.sophy.api.methodReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class ConstructorReferenceTest {
    @Test
    @DisplayName("생성자 참조 테스트")
    void apply() {
//        람다식에서 불필요한 매개변수 지움.
//        () -> a()
//        a()

//        () -> A.b()
//        A::b

        Function<Runnable, Thread> function = Thread::new;  // 팩토리를 통해서 객체를 생성


//        Runnable task1 = () -> System.out.println("Task 1 excuted");        //람다 ( 이전에는 익명객체..)
//        Runnable task2 = () -> System.out.println("Task 2 excuted");
//        Thread thread1 = function.apply(task1);
//        Thread thread2 = function.apply(task2);
//        thread1.start();
//        thread2.start();


//       객체 생성 없이..
//        팩토리는 하나 만들어놓는게 효율적.
        function.apply(() -> System.out.println("Task 1 excuted")).start();

        function
                .apply(() -> System.out.println("Task 2 excuted"))      // 중간 함수들은 function ( 받고, 리턴하고 )
                .start();       // 트리거 역할을 하는 마지막 함수. (컨슈머 역할. 리턴값 없음)



//        익명 객체 (과거 버전)
//        Runnable task1 = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }

//        클래식 자바
//        Thread t = new Thread();   -> 이제 이렇게 객채 셍성하면 안됨...!
//        객체지향의 단점: 객체가 남음. 또 다른 객체가 필요할 떄 또 만들어야 함
//        함수형: 필요할 때 그때그때 사용하고 지울 수 있음. 또 다른 객체가 필요할 때 팩토리 패턴으로 자원 적게(수공업이 아니기 때문에..) 생성할 수 있음.



//        enum : 범주(카테고리)형 변수…
    }
}
