package net.sophy.api.designpattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BuilderPatternTest {

    @Test
    @DisplayName("builder pattern example")
    void main() {
        MobileBuilder builder = new MobileBuilder();
        Mobile myMobile = builder.with(myBuilder -> {
            myBuilder.ram = 4;
            myBuilder.battery = 4000;
            myBuilder.processor = "A23 Bionic";
        }).createMobile();
        assertThat(myMobile.getRam(), is(4));
        assertThat(myMobile.getBattery(), is(4000));
        assertThat(myMobile.getProcessor(), is(equalTo("A23 Bionic")));
    }


    @Data
    @AllArgsConstructor
    class Mobile{
        private final int ram;
        private final int storage;
        private final int battery;
        private final int camera;
        private final String processor;
        private final double screenSize;

        public Mobile(MobileBuilder mobileBuilder) {
            this.ram = mobileBuilder.ram;
            this.storage = mobileBuilder.storage;
            this.battery = mobileBuilder.battery;
            this.camera = mobileBuilder.camera;
            this.processor = mobileBuilder.processor;
            this.screenSize = mobileBuilder.screenSize;
        }
    }
    @Data class MobileBuilder {
        private int ram;
        private int storage;
        private int battery;
        private int camera;
        private String processor;
        private double screenSize;

        public MobileBuilder with(Consumer<MobileBuilder> builderField) {
            builderField.accept(this);
            return this;
        }

        //    builder : method로 객체를 생성
        public Mobile createMobile() {
            return new Mobile(this);
        }
    }

}

