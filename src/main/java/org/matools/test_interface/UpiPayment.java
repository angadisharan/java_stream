package org.matools.test_interface;

public sealed class UpiPayment implements Payment permits WalletPayment{
    public void pay(int amount) {
        System.out.println("UPI payment: " + amount);
    }
}