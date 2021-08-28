package net.sophy.api.designpattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class OrderPatternTest {
    @Test @DisplayName("Order Pattern Test")
    void main() {
        Order.place(order -> order.add("shoes")
                                .add("smartphone")
                                .add("food")
                                .deliveredAt("Street No 45 Gangnam"));
    }
}

//    many to one 관계
@Data
@NoArgsConstructor
@AllArgsConstructor
class Order {
    private List<String> cart = new ArrayList<>();
    private String address;

    public Order add(String item) {
        cart.add(item);
        System.out.println("add to cart = " + item);
        return new Order(this.cart, this.address);
    }
    public Order deliveredAt(String location) {
        this.address = location;
        System.out.println("The delivery address set by you = " + location);
        return new Order(this.cart, this.address);
    }
    public static void place(Function<Order, Order> function) {
        Order order = new Order();
        order = function.apply(order);
        System.out.println("order place = "
                + order.cart.size() +
                " items orderd by you will be delivered at "
                + order.address +
                "by tomorrow");
    }
}
