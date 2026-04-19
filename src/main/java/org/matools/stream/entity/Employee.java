package org.matools.stream.entity;

import java.util.Objects;

public class Employee {

    private final long id;
    private final String name;
    private final String department;
    private final double salary;
    private final boolean active;

    public Employee(long id, String name, String department, double salary, boolean active) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                '}';
    }

    /**
     * Static factory that returns a small sample list of employees.
     * List.of(...) factory methods were introduced in Java 9.
     */
    public static java.util.List<Employee> sampleEmployees() {
        return java.util.List.of(
                new Employee(1L, "Alice", "Engineering", 120_000, true),
                new Employee(2L, "Bob", "Engineering", 90_000, true),
                new Employee(3L, "Carol", "HR", 80_000, true),
                new Employee(4L, "Dave", "Finance", 110_000, false),
                new Employee(5L, "Eve", "Engineering", 150_000, true),
                new Employee(6L, "Frank", "Finance", 95_000, true)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return id == e.id &&
                Double.compare(e.salary, salary) == 0 &&
                active == e.active &&
                Objects.equals(name, e.name) &&
                Objects.equals(department, e.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, salary, active);
    }
}
