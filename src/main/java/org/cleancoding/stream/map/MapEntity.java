package org.cleancoding.stream.map;

import org.cleancoding.stream.entity.Employee;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapEntity {

    public static void main(String[] args) {
        List<Employee> employees = Employee.sampleEmployees();
        
        // Collector: counting() -> count elements
        long totalEmployees = employees.stream()
                .collect(Collectors.counting()); // Java 8

        // Collector: toList() -> collect elements into a List
        List<String> namesList = employees.stream()
                .map(Employee::getName) // .map(e -> e.getName())
                .collect(Collectors.toList()); // Java 8

        // Collector: toSet() -> unique elements
        Set<String> departments = employees.stream()
                .map(Employee::getDepartment) // .map(e -> e.getDepartment())
                .collect(Collectors.toSet()); // Java 8

        // Collector: summingInt() -> sum values
        int totalSalaryRounded = employees.stream()
                .collect(Collectors.summingInt(e -> (int) e.getSalary())); // Java 8

        // Collector: averagingDouble() -> average
        double averageSalary = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary)); // Java 8

        // Collector: maxBy() -> maximum
        var maxSalaryEmployee = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))); // Java 8

        // Collector: minBy() -> minimum
        var minSalaryEmployee = employees.stream()
                .collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))); // Java 8

        // Collector: mapping() -> transform values
        Map<String, List<String>> namesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList()) // Java 8
                ));

        System.out.println("Employees: " + employees);
        System.out.println("counting(): " + totalEmployees);
        System.out.println("toList() names: " + namesList);
        System.out.println("toSet() departments: " + departments);
        System.out.println("summingInt() totalSalaryRounded: " + totalSalaryRounded);
        System.out.println("averagingDouble() averageSalary: " + averageSalary);
        System.out.println("maxBy() salary: " + maxSalaryEmployee.orElse(null));
        System.out.println("minBy() salary: " + minSalaryEmployee.orElse(null));
        System.out.println("mapping() namesByDepartment: " + namesByDepartment);

        // Extra: summary statistics for salaries in one go (also Java 8).
        DoubleSummaryStatistics stats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Salary stats (Java 8 summarizingDouble): " + stats);
    }
}
