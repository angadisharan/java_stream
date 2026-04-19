package org.matools.immutable;

import java.util.*;

final class Person {

    private final String name;
    private final int age;
    private final List<String> hobbies;
    private final Address address;

    public Person(String name, int age, List<String> hobbies, Address address) {
        this.name = name;
        this.age = age;

        // Defensive copy
        this.hobbies = new ArrayList<>(hobbies);

        // Address is already immutable
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        // Return unmodifiable copy
        return Collections.unmodifiableList(hobbies);
    }

    public Address getAddress() {
        return address;
    }
}
