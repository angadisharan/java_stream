package org.matools.stream.generic;

import org.matools.stream.entity.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenericDemo {

    public static void main(String[] args) {
        demoMapAndFlatMap();
        demoReduce();   
        demoGroupingAndMapping();
        demoPartitioningBy();
        demoJoining();
        demoOptional();
        demoParallelStream();
        demoPrimitiveStreams();
    }

    private static void demoMapAndFlatMap() {
        System.out.println("=== map / flatMap ===");

        List<String> names = List.of("Alice", "Bob", "Carol"); // List.of -> Java 9

        // map: transform each element
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .toList(); // Stream.toList() -> Java 16

        // flatMap: flatten nested structure
        List<String> words = names.stream()
                .flatMap(n -> Arrays.stream(n.split("")))
                .toList();

        System.out.println("Names: " + names);
        System.out.println("map -> lengths: " + nameLengths);
        System.out.println("flatMap -> characters: " + words);
    }

    private static void demoReduce() {
        System.out.println("\n=== reduce ===");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Sum with reduce
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        // Max with reduce
        int max = numbers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);

        System.out.println("Numbers: " + numbers);
        System.out.println("reduce -> sum: " + sum);
        System.out.println("reduce -> max: " + max);
    }

    private static void demoGroupingAndMapping() {
        System.out.println("\n=== groupingBy / mapping ===");

        List<Employee> employees = Employee.sampleEmployees();

        // groupingBy: employees per department
        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)); // Java 8

        // groupingBy + mapping: names per department
        Map<String, List<String>> namesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                )); // Java 8

        System.out.println("Employees by department: " + byDepartment);
        System.out.println("Names by department (groupingBy + mapping): " + namesByDepartment);
    }

    private static void demoPartitioningBy() {
        System.out.println("\n=== partitioningBy ===");

        List<Employee> employees = Employee.sampleEmployees();

        // partitioningBy: split into active vs inactive
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isActive)); // Java 8

        System.out.println("Active employees: " + partitioned.get(true));
        System.out.println("Inactive employees: " + partitioned.get(false));
    }

    private static void demoJoining() {
        System.out.println("\n=== joining ===");

        List<String> technologies = List.of("Java", "Kotlin", "Scala");

        // joining: concatenate strings with delimiter / prefix / suffix (Java 8).
        String joined = technologies.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("Technologies: " + technologies);
        System.out.println("joining -> " + joined);
    }

    private static void demoOptional() {
        System.out.println("\n=== Optional ===");

        List<Employee> employees = Employee.sampleEmployees();

        // Find highest-paid Engineering employee
        Optional<Employee> topEngineer = employees.stream()
                .filter(e -> "Engineering".equals(e.getDepartment()))
                .max(Comparator.comparingDouble(Employee::getSalary)); // max(...) returns Optional in Java 8

        System.out.println("Top engineer: " + topEngineer.orElse(null));

        // Optional.map / orElse
        String topEngineerName = topEngineer
                .map(Employee::getName)
                .orElse("<none>");
        System.out.println("Top engineer name via Optional: " + topEngineerName);
    }

    private static void demoParallelStream() {
        System.out.println("\n=== parallelStream ===");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // parallelStream was added in Java 8.
        int sum = numbers.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Numbers: " + numbers);
        System.out.println("parallelStream sum: " + sum);
    }

    private static void demoPrimitiveStreams() {
        System.out.println("\n=== primitive streams ===");

        // IntStream / LongStream / DoubleStream are part of Java 8 streams.
        IntSummaryStatistics stats = java.util.stream.IntStream.rangeClosed(1, 10)
                .summaryStatistics();

        // Box to List<Integer> for comparison.
        List<Integer> boxed = java.util.stream.IntStream.rangeClosed(1, 5)
                .boxed()
                .toList(); // Stream.toList() -> Java 16

        System.out.println("IntStream 1..10 stats: " + stats);
        System.out.println("IntStream 1..5 boxed to List<Integer>: " + boxed);
    }
}
