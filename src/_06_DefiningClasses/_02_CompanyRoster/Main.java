package _06_DefiningClasses._02_CompanyRoster;

import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = Integer.parseInt(sc.nextLine());
        // department, avg salary
        Map<String, Double> departmentsWithSalary = new TreeMap<>();

        //department, names of people working there
        Map<String, List<String>> departmentsWithNames = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = "n/a";
            if (input[4].contains("@")) {
                email = input[4];
            }

            int age = -1;
            if (input[5].matches("\\d+")) { // TODO: outof bounds if no email is given
                age = Integer.parseInt(input[5]);
            }

            departmentsWithNames.putIfAbsent(department, new ArrayList<>());
            departmentsWithNames.get(department).add(name);
            departmentsWithSalary.putIfAbsent(department, 0.0);
            departmentsWithSalary.put(department, departmentsWithSalary.get(department) + salary);

            Employee employee = new Employee(name, salary, position, department, email, age);


        }

        String highestAvgDepartment = "";
        for (Map.Entry<String, Double> entry : departmentsWithSalary.entrySet()) {
            double curSalary = entry.getValue() / departmentsWithNames.get(entry.getKey()).size();;
            double highestAvgSalary = 0;
            if (highestAvgSalary > curSalary) {
                highestAvgSalary = curSalary;
                highestAvgDepartment = entry.getKey();
            }
        }
        System.out.printf("Highest Average Salary: %s\n", highestAvgDepartment);

    }
}
