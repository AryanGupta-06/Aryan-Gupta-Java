package Day_2_Objective.main;

import Day_2_Objective.model.Course;
import Day_2_Objective.model.Student;
import Day_2_Objective.service.RegistrationSystem;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("University Course Registration System");
            System.out.println("1. Register Student to Course");
            System.out.println("2. Drop Course");
            System.out.println("3. List Students for Course");
            System.out.println("4. List Students for Branch");
            System.out.println("5. List Courses");
            System.out.println("6. Filter Courses by Credits");
            System.out.println("7. Filter Courses by Instructor");
            System.out.println("8. Add Student");
            System.out.println("9. Remove Student");
            System.out.println("10. Add Course");
            System.out.println("11. Remove Course");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();
                    system.registerStudentToCourse(studentId, courseId);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    courseId = scanner.nextLine();
                    system.dropCourse(studentId, courseId);
                    break;
                case 3:
                    System.out.print("Enter Course ID: ");
                    courseId = scanner.nextLine();
                    List<Student> studentsForCourse = system.listStudentsForCourse(courseId);
                    System.out.println("Students enrolled in " + courseId + ":");
                    for (Student student : studentsForCourse) {
                        System.out.println(student);
                    }
                    break;
                case 4:
                    System.out.print("Enter Branch: ");
                    String branch = scanner.nextLine();
                    List<Student> studentsForBranch = system.listStudentsForBranch(branch);
                    System.out.println("Students in branch " + branch + ":");
                    for (Student student : studentsForBranch) {
                        System.out.println(student);
                    }
                    break;
                case 5:
                    List<Course> courses = system.listCourses();
                    System.out.println("Courses:");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    break;
                case 6:
                    System.out.print("Enter Credits: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    List<Course> coursesByCredits = system.filterCoursesByCredits(credits);
                    System.out.println("Courses with " + credits + " credits:");
                    for (Course course : coursesByCredits) {
                        System.out.println(course);
                    }
                    break;
                case 7:
                    System.out.print("Enter Instructor Name: ");
                    String instructorName = scanner.nextLine();
                    List<Course> coursesByInstructor = system.filterCoursesByInstructor(instructorName);
                    System.out.println("Courses taught by " + instructorName + ":");
                    for (Course course : coursesByInstructor) {
                        System.out.println(course);
                    }
                    break;
                case 8:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Email: ");
                    String studentEmail = scanner.nextLine();
                    System.out.print("Enter Student Year: ");
                    int studentYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Branch: ");
                    String studentBranch = scanner.nextLine();
                    system.addStudent(new Student(studentId, studentName, studentEmail, studentYear, studentBranch));
                    break;
                case 9:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    system.removeStudent(studentId);
                    System.out.println("Student removed.");
                    break;
                case 10:
                    System.out.print("Enter Course ID: ");
                    courseId = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Instructor Name: ");
                    instructorName = scanner.nextLine();
                    System.out.print("Enter Course Capacity: ");
                    int courseCapacity = scanner.nextInt();
                    System.out.print("Enter Course Credits: ");
                    credits = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.addCourse(new Course(courseId, courseName, instructorName, courseCapacity, credits));
                    System.out.println("Course added.");
                    break;
                case 11:
                    System.out.print("Enter Course ID: ");
                    courseId = scanner.nextLine();
                    system.removeCourse(courseId);
                    System.out.println("Course removed.");
                    break;
                case 12:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
