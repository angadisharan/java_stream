package org.matools.test_interface;

public non-sealed class WalletPayment extends UpiPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Wallet payment: " + amount);
    }
}