package Java_collections_worksheet_1;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + '}';
    }
}

public class Q3_Department_Directory_with_Sorted_Employees {
    private Map<String, List<Employee>> departmentMap;

    public Q3_Department_Directory_with_Sorted_Employees() {
        departmentMap = new HashMap<>();
    }

    public void addEmployee(String department, Employee employee) {
        departmentMap.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
        departmentMap.get(department).sort(Comparator.comparingDouble(Employee::getSalary).reversed());
    }

    public List<Employee> getTopPaidEmployees(int n) {
        return departmentMap.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q3_Department_Directory_with_Sorted_Employees directory = new Q3_Department_Directory_with_Sorted_Employees();

        System.out.println("Enter the number of departments:");
        int numDepartments = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numDepartments; i++) {
            System.out.println("Enter department name:");
            String department = scanner.nextLine();

            System.out.println("Enter the number of employees in " + department + ":");
            int numEmployees = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int j = 0; j < numEmployees; j++) {
                System.out.println("Enter employee name:");
                String name = scanner.nextLine();

                System.out.println("Enter employee salary:");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                directory.addEmployee(department, new Employee(name, salary));
            }
        }

        System.out.println("Enter the number of top paid employees to retrieve:");
        int topN = scanner.nextInt();

        List<Employee> topPaidEmployees = directory.getTopPaidEmployees(topN);
        System.out.println("Top " + topN + " paid employees across all departments:");
        topPaidEmployees.forEach(System.out::println);
    }
}

