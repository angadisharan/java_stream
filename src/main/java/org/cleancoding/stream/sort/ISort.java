package org.cleancoding.stream.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
