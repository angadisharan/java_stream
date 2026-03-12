package org.cleancoding.stream.filter;

import org.cleancoding.stream.entity.Employee;

import java.util.Comparator;
import java.util.List;

public class FilterEntityDemo {

    public static void main(String[] args) {
        List<Employee> employees = Employee.sampleEmployees();

        var activeHighEarnersInEngineering = employees.stream()
                .filter(Employee::isActive)
                .filter(e -> "Engineering".equals(e.getDepartment()))
                .filter(e -> e.getSalary() >= 100_000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList(); //toList added in java 16

        var inactiveEmployees = employees.stream()
                .filter(e -> !e.isActive())
                .toList();

        System.out.println("All employees:");
        employees.forEach(System.out::println);

        System.out.println("\nActive Engineering employees with salary >= 100000 (sorted by salary desc):");
        activeHighEarnersInEngineering.forEach(System.out::println);

        System.out.println("\nInactive employees:");
        inactiveEmployees.forEach(System.out::println);
    }
}