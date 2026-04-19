package org.cleancoding.immutable;

import java.util.ArrayList;
import java.util.List;

public class TestImmutable {

    public static void main(String[] args) {
        List<String> h = new ArrayList<>();
        h.add("cricket");

        Address addr = new Address("Bangalore", "MG Road");
        Person p = new Person("Sharan", 25, h, addr);

// Try modifying original list
        h.add("hacking");

        System.out.println(p.getHobbies()); // ✅ still safe
    }
}
