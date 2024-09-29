package _06_DefiningClasses._02_CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email; // optional
    private String age; // optional


    public Employee(String name, double salary, String position, String department, String email, String age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email.isEmpty() ? "n/a" : email;
        this.age = age.isEmpty() ? "-1" : age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %s %s", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}
