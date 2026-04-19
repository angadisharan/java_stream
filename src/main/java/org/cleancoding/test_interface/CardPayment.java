package org.cleancoding.test_interface;

public final class CardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Card payment: " + amount);
    }
}