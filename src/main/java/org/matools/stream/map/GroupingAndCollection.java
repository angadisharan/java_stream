package org.matools.stream.map;

import org.matools.stream.entity.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingAndCollection {

    public static void main(String[] args) {
        List<Employee> employees = Employee.sampleEmployees();

        // groupingBy + toList(): group all employees by department (Java 8).
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // groupingBy + counting(): how many employees in each department (Java 8).
        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));

        // groupingBy + mapping(): names per department (Java 8).
        Map<String, List<String>> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));

        // groupingBy + mapping to Set: unique first letters per department (Java 8).
        Map<String, Set<Character>> firstLettersByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(e -> e.getName().charAt(0), Collectors.toSet())
                ));

        // partitioningBy: split employees into active vs inactive (Java 8).
        Map<Boolean, List<Employee>> byActive = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isActive));

        // collectingAndThen: get the highest-paid employee per department (Java 8).
        Map<String, Employee> topEarnerByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                optional -> optional.orElseThrow()
                        )
                ));

        System.out.println("Employees by department (groupingBy -> List): " + employeesByDept);
        System.out.println("Employee count by department (groupingBy + counting): " + countByDept);
        System.out.println("Names by department (groupingBy + mapping): " + namesByDept);
        System.out.println("First letters by department (groupingBy + mapping to Set): " + firstLettersByDept);
        System.out.println("Partitioned by active (partitioningBy): " + byActive);
        System.out.println("Top earner by department (groupingBy + collectingAndThen + maxBy): " + topEarnerByDept);
    }
}
