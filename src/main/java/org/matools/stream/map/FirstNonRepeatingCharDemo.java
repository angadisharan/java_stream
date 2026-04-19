package org.matools.stream.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharDemo {

    public static void main(String[] args) {
        String input = "swiss";

        Optional<Character> firstNonRepeating = firstNonRepeatingChar(input);

        System.out.println("Input: " + input);
        System.out.println("First non‑repeating character: " +
                firstNonRepeating.map(String::valueOf).orElse("<none>"));
    }

    /**
     * Finds the first non‑repeating character in the given string using streams and a frequency map.
     */
    public static Optional<Character> firstNonRepeatingChar(String input) {
        if (input == null || input.isEmpty()) {
            return Optional.empty();
        }

        Map<Character, Long> frequency = input.chars() //.chars() method added in java 9
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, // keep insertion order
                        Collectors.counting()
                ));

        return frequency.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
