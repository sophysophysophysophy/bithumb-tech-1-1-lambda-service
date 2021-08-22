package net.sophy.api.optional;

import lombok.Data;

import java.util.Date;
import java.util.Optional;

public class OptionalTest {

    //     getter setter requireArgs 모두 포함
    @Data
    class Order {
        private final Long id;
        private final Date date;
        private final Member member;
    }

    @Data
    class Member {
        private final Long id;
        private final String name;
        private final Address address;
    }

    @Data
    class Address {
        private final String street;
        private final String city;
        private final String zipcode;
    }

    /* 주문을 한 회원이 사는 도시  */
    public String getCityOfMemberFromOrder(Order order) {
        return Optional.ofNullable(order)
                .map(Order::getMember)
                .map(Member::getAddress)
                .map(Address::getCity)
                .orElse("No address"); // null일 때 방어. default value 설
    }

    /* 주어진 시간(분) 내에 생성된 주문을 한 회원정보  */
    public Optional<Member> getMemberIfOrderWithin(Order order, int min) {
//        LocalDateTime dateTime = LocalDateTime.now().minus(Duration.of(min, ChronoUnit.MINUTES));
//        return Optional.ofNullable(order)
//                .filter(nowOrder -> nowOrder.getDate().after(Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant())))
//                .map(Order::getMember);

        return Optional.ofNullable(order)
                .filter( o -> o.getDate().getTime() > System.currentTimeMillis() - min * 1000)       //매개변수가 의미가 있다면 메소드참조를 사용하면 안된다.
                .map(Order::getMember)
                ;
    }
}
