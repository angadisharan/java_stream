package org.matools.stream.entity;

import java.util.*;
import java.util.stream.Collectors;

public class TestM {

    public static void main(String arg[]) {

        Employee e1 = new Employee(1, "Ram", "D", 10d, true);
        Employee e2 = new Employee(1, "Ram", "D", 10d, true);

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

        Set<Employee> eS = new HashSet<>();
        eS.add(e1);
        System.out.println(eS.size());
        eS.remove(e2);
        System.out.println(eS.size());


        List<Employee> e = Employee.sampleEmployees();

         e.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getName).reversed()),
                optional -> optional.map(emp -> Map.entry(emp.getName(), emp.getSalary())).orElse(null)
        )));

        Map<String, String> result =
                e.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparingDouble(Employee::getSalary)
                                                .thenComparing(Employee::getName)
                                ),
                                opt -> opt.map(Employee::getName).orElse(null)
                        )
                ));


        System.out.println(result);

    }
}
