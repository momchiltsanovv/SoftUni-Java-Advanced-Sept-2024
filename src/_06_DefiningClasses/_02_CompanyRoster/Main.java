package _06_DefiningClasses._02_CompanyRoster;

import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int size = Integer.parseInt(sc.nextLine());

        List<Employee> employees = new ArrayList<>();
        Map<String, Double> salaryPerDepartment = new TreeMap<>();//department and sum of salary of the department
        Map<String, Integer> worksAtDepartment = new TreeMap<>();// department and count of people working there

        inputWork(size, sc, employees, worksAtDepartment, salaryPerDepartment);
        employees.sort(Comparator.comparing(Employee::getSalary).reversed()); // sorting by salary using comparator then reversing to get them in descending order

        String highestAvgDep = depHighestSalary(salaryPerDepartment, worksAtDepartment);

        printResult(highestAvgDep, employees);

    }

    private static void inputWork(int n, Scanner sc, List<Employee> employees, Map<String, Integer> worksAtDepartment, Map<String, Double> salaryPerDepartment) {

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email = "";
            String age = "";

            switch (tokens.length) {
                case 5 -> {
                    if (tokens[4].matches("\\d+")) {
                        age = tokens[4];
                    } else {
                        email = tokens[4];
                    }
                }
                case 6 -> {
                    email = tokens[4];
                    age = tokens[5];
                }
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            employees.add(employee);

            worksAtDepartment.putIfAbsent(department, 0);
            worksAtDepartment.put(department, worksAtDepartment.get(department) + 1);

            salaryPerDepartment.putIfAbsent(employee.getDepartment(), 0.0);
            salaryPerDepartment.put(employee.getDepartment(), salaryPerDepartment.get(department) + salary);

        }
    }

    private static String depHighestSalary(Map<String, Double> salaryPerDepartment, Map<String, Integer> worksAtDepartment) {
        String depHighestSalary = "";
        double curMax = Double.MIN_VALUE;

        for (Map.Entry<String, Double> entry : salaryPerDepartment.entrySet()) {
            String department = entry.getKey();
            double totalSalary = entry.getValue();
            double workers = worksAtDepartment.get(department);
            double avgSalary = totalSalary / workers;
            if (avgSalary > curMax) {
                    curMax = totalSalary / workers;
                    depHighestSalary = department;
                }
            }
        return depHighestSalary;
    }


    private static void printResult(String highestAvgDep, List<Employee> employees) {
        System.out.printf("Highest Average Salary: %s\n", highestAvgDep);
        for (Employee employee : employees) {
            if(employee.getDepartment().equals(highestAvgDep)) {
                System.out.println(employee);
            }
        }
    }


}
