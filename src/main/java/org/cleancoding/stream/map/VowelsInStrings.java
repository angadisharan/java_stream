package org.cleancoding.stream.map;

import org.cleancoding.stream.entity.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VowelsInStrings {

    public static void main(String[] args) {
        String input = "Java streams is so interesting in Java coding.";
        //O/P : {Java=2, coding.=2, in=1, streams=2, interesting=4, is=1, so=1}

        Map<String, Long> map = Arrays.stream(input.split("\s+"))
                .distinct()
                .collect(Collectors.toMap(Function.identity(), s -> s.toLowerCase().chars().filter(ch -> "aeiou".indexOf(ch) != -1).count()));

        System.out.println(map);

    }
}
