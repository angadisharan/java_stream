package org.matools.stream.sort;

interface A {
    default void show() { System.out.println("A"); }
}

interface B {
    default void show() { System.out.println("B"); }
}

class C implements A {


}


public class ISort {
    public static void main(String[] args) {

        A a = new C();
        C c = new C();

        a.show();
        c.show();

    }
}
