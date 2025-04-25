package Java_oops_Worksheet_1;

import java.util.ArrayList;
import java.util.Scanner;

// Abstract class Employee
abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Abstract method to get details
    public abstract String getDetails();

    // Getter methods for name and id
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

// FullTimeEmployee class extending Employee
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String getDetails() {
        return "FullTimeEmployee [Name: " + getName() + ", ID: " + getId() + ", Monthly Salary: " + monthlySalary + "]";
    }
}

// Freelancer class extending Employee
class Freelancer extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Freelancer(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getDetails() {
        return "Freelancer [Name: " + getName() + ", ID: " + getId() + ", Hourly Rate: " + hourlyRate + ", Hours Worked: " + hoursWorked + "]";
    }
}

// Main class to test the implementation
public class Q5_Employee_Payroll_System {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nEmployee Payroll System Menu:");
            System.out.println("1. Add FullTimeEmployee");
            System.out.println("2. Add Freelancer");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addFullTimeEmployee();
                    break;
                case 2:
                    addFreelancer();
                    break;
                case 3:
                    displayAllEmployees();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addFullTimeEmployee() {
        System.out.println("Enter details for FullTimeEmployee:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Monthly Salary: ");
        double monthlySalary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Employee fullTimeEmployee = new FullTimeEmployee(name, id, monthlySalary);
        employees.add(fullTimeEmployee);
        System.out.println("FullTimeEmployee added successfully.");
    }

    private static void addFreelancer() {
        System.out.println("Enter details for Freelancer:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Hours Worked: ");
        int hoursWorked = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee freelancer = new Freelancer(name, id, hourlyRate, hoursWorked);
        employees.add(freelancer);
        System.out.println("Freelancer added successfully.");
    }

    private static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee.getDetails());
                System.out.println("Salary: " + employee.calculateSalary());
            }
        }
    }
}
