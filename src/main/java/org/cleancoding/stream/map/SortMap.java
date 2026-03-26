package org.cleancoding.stream.map;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortMap {
    public static void main(String[] args) {
        String input = "Java streams is so interesting in Java coding.";
        //O/P : {Java=2, coding.=2, in=1, streams=2, interesting=4, is=1, so=1}

        Map<String, Long> map = Arrays.stream(input.split("\s+"))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));


        String sortedDesc = input.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(sortedDesc);
        System.out.println(map);

    }
}
