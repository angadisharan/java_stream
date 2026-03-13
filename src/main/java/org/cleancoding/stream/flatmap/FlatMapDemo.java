package org.cleancoding.stream.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {

    public static void main(String[] args) {
        // Example 1: flatten List<List<Integer>> to List<Integer> (Java 8).
        List<List<Integer>> nestedNumbers = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        ); // List.of(...) was added in Java 9.

        List<Integer> flattened = nestedNumbers.stream()
                .flatMap(List::stream) // flatMap + method reference (Java 8).
                .collect(Collectors.toList()); // Java 8 style; Java 16+ also has Stream.toList().

        System.out.println("Nested numbers: " + nestedNumbers);
        System.out.println("Flattened numbers (flatMap): " + flattened);

        // Example 2: split sentences into words and flatten them.
        List<String> sentences = Arrays.asList(
                "Java streams are powerful",
                "flatMap flattens nested structures",
                "From Java 8 to 21"
        ); // Arrays.asList has been around since early Java.

        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        Arrays.stream("Java streams are powerful".split("\\s+"));

        System.out.println("Sentences: " + sentences);
        System.out.println("Words (flatMap over split): " + words);
    }
}
