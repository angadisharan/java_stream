package org.matools.stream.map;

import org.matools.stream.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterCollect {

    public static void main(String[] args) {
        List<Employee> employees = Employee.sampleEmployees();

        // Return names of employees with salary > 100000.
        List<String> eList = employees.stream().filter(e -> e.getSalary() > 100000)
                .map(e -> e.getName())
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(eList);


        // Count Employees per Department
    }
}
