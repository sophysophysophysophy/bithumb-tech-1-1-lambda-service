package net.sophy.api.designpattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class IteratorPatternTest {

//    내부 순환
    @Test @DisplayName("Iterator Pattern Test")
    void main() {
        MyArrayList list = new MyArrayList(new Object[]{1, 3, 5, 7, 9});
        list.forEach(System.out::println);
    }

    class MyArrayList {
        Object[] elements;

        public MyArrayList(Object[] elements) {
            this.elements = elements;
        }

        public void forEach(Consumer<Object> action) {
            for (int i = 0; i < elements.length; i++) {
                action.accept(elements[i]);
            }
        }
    }
}
