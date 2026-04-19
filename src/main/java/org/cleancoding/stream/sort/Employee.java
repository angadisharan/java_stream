package org.cleancoding.stream.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
    private String name;
    private Integer age;
    private String gender;

    private final Address address = new Address();

    private List<String> hobbiesWrapper;

    private Integer myHash;

    public Employee() {

    }

    public Employee(String name, Integer age, String gender, Address address, List<String> hobbies, List<String> hobbies1) {
        this.name = name;
        this.age = age;
        this.gender = gender;

        hobbiesWrapper = Arrays.asList();


        // this.address = address; reinitalise items inside Address
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }


    @Override
    public int hashCode() {
        if (myHash != null) return myHash;
        return -1;
    }


}


