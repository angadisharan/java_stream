package org.matools.stream.filter;

import java.util.List;
import java.util.Objects;

public class FilterDemo {

    public static void main(String[] args) {

        // List.of(...) factory methods were added in Java 9.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // List.of(...) rejects nulls; use a mutable list so we can demo null filtering (still Java 9 feature).
        List<String> names = new java.util.ArrayList<>(List.of("  alice  ", "", "Bob", "anna", "Alex", "  ", "JOHN"));
        names.add(null);

        // Stream.toList() was added in Java 16 (before that you would use collect(Collectors.toList())).
        var evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        var evenSquaresOver20 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .filter(square -> square > 20)
                .toList();

        var cleanedNamesStartingWithA = names.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                // isBlank() was added in Java 11.
                .filter(s -> !s.isBlank())
                .filter(s -> s.toLowerCase().startsWith("a"))
                .toList();

        System.out.println("Numbers: " + numbers);
        System.out.println("Evens: " + evens);
        System.out.println("Even squares > 20: " + evenSquaresOver20);
        System.out.println("Names: " + names);
        System.out.println("Cleaned names starting with 'a': " + cleanedNamesStartingWithA);

    }

}
