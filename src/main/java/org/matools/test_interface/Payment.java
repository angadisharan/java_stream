package org.matools.test_interface;

public sealed interface Payment
        permits UpiPayment, CardPayment, WalletPayment {

    void pay(int amount);
}