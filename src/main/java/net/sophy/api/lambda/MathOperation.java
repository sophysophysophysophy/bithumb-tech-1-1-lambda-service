package net.sophy.api.lambda;

//정수 두개를 입력받아서 정수 한개가 값으로 리턴된다.
@FunctionalInterface
public interface MathOperation {
    int apply(int a, int b);
}
