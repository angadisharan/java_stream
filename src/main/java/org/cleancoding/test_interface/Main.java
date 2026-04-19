package org.cleancoding.test_interface;

public class Main {
    public static void main(String[] args) {

        Payment p1 = new UpiPayment();
        Payment p2 = new CardPayment();
        Payment p3 = new WalletPayment();

        p1.pay(100);
        p2.pay(200);
        p3.pay(300);
    }
}