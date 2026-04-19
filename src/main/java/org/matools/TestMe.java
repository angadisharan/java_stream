package org.matools;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMe {


    public static void main(String args[]) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        LinkedHashMap map =
                list.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a, b) -> a,
                                LinkedHashMap::new
                        ));

        System.out.println(
                map


        );


    }

}
