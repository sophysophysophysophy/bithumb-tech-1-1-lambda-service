package net.sophy.api.designpattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class DecoratorPattern {

    @Test @DisplayName("Decorator Pattern Test")
    void main() {
        Burger myOrder = new BurgerShop(Burger::addCheese)
                .use(new BurgerShop(Burger::addVeggies)
                        .use(new Burger()));
        System.out.println("I eat " + myOrder);
    }

    class Burger{
        private String burgerType;

        public Burger() {
            this.burgerType = "";
        }

        private Burger(String burgerType) {
            this.burgerType = burgerType;
        }

        public Burger addVeggies() {
            System.out.println("Adding vegies to the burger");
            return new Burger(this.burgerType += " Veggie");
        }
        public Burger addCheese() {
            System.out.println("Adding cheese to the burger");
            return new Burger(this.burgerType += " Cheese");
        }
        public String toString() {
            return String.format("%s", burgerType + " burger");
        }
    }

    class BurgerShop {
//        <input, return>
        Function<Burger, Burger> decoration;
        BurgerShop(Function<Burger, Burger> decoration) {
            this.decoration = decoration;
        }

        Burger use(Burger baseBurger) {
            System.out.println("Base Burger : " + baseBurger);
            return decoration.apply(baseBurger);
        }
    }

}
