package org.matools;

public class InterfaceTest {

    public static void main(String args[]) {
        Sum s = (a, b) -> { return a + b; };

        System.out.println(s.sum(2, 3));
    }
}
