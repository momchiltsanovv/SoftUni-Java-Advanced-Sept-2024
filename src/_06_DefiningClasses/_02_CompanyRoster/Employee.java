package _06_DefiningClasses._02_CompanyRoster;

import java.util.List;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;



    Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    String getName() {
        return name;
    }
    double getSalary() {
        return salary;
    }
    String getPosition() {
        return position;
    }
    String getDepartment() {
        return department;
    }
    String getEmail() {
        return email;
    }
    int getAge() {
        return age;
    }







}
