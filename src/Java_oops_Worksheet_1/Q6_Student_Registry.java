package Java_oops_Worksheet_1;

import java.util.Scanner;

public class Q6_Student_Registry {
    private static int studentCount = 0;
    private int studentID;
    private String name;

    // Constructor to initialize student object
    public Q6_Student_Registry(String name) {
        this.name = name;
        this.studentID = ++studentCount; // Increment the static counter and assign it as student ID
    }

    // Method to get the student ID
    public int getStudentID() {
        return studentID;
    }

    // Method to get the student name
    public String getName() {
        return name;
    }

    // Static method to get the total number of students
    public static int getTotalStudents() {
        return studentCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Q6_Student_Registry[] students = new Q6_Student_Registry[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            students[i] = new Q6_Student_Registry(name);
        }

        // Displaying the total number of students
        System.out.println("Total number of students: " + Q6_Student_Registry.getTotalStudents());

        // Displaying details of each student
        for (Q6_Student_Registry student : students) {
            System.out.println("Student ID = " + student.getStudentID() + ", Name = " + student.getName());
        }

        scanner.close();
    }
}
