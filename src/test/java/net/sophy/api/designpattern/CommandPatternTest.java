package net.sophy.api.designpattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CommandPatternTest {

    @Test @DisplayName("Command Pattern Test")
    void main() {
        //  command : interface가 필요. 구현체도 필요.

        Aircon aircon = new Aircon();
        AirconRemote airconRemote = new AirconRemote();
        airconRemote.setCommand(() -> aircon.turnOn());
        airconRemote.buttonProcessed();
        airconRemote.setCommand(() -> aircon.decTemp());
        airconRemote.buttonProcessed();
        airconRemote.setCommand(() -> aircon.turnOff());
        airconRemote.buttonProcessed();

        assertThat("te", is(equalTo("te")));
    }

    class Aircon {
        public void turnOn() {
            System.out.println("turning on AC");
        }
        public void turnOff() {
            System.out.println("turning off AC");
        }
        public void incTemp() {
            System.out.println("Increasing temperature");
        }
        public void decTemp() {
            System.out.println("Decreasing temperature");
        }
    }
    interface Command {
        void execute();
    }

//    controller 에서 service 가져오는 구조
    class AirconRemote {
        Command command;

        public void setCommand(Command command) {
            this.command = command;
        }
        public void buttonProcessed() {
            command.execute();
        }

    }
}
