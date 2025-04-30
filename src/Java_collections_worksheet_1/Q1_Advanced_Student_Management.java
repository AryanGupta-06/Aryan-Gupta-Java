package Java_collections_worksheet_1;

import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private double grade;
    private String branch;

    public Student(int id, String name, int age, double grade, String branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public String getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", branch='" + branch + '\'' +
                '}';
    }
}

public class Q1_Advanced_Student_Management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        Set<Integer> uniqueIds = new HashSet<>();

        // User input for at least 15 students
        while (students.size() < 15 || askForMoreStudents(scanner)) {
            System.out.println("Enter details for student " + (students.size() + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            while (uniqueIds.contains(id)) {
                System.out.print("ID already exists. Enter a unique ID: ");
                id = scanner.nextInt();
            }
            uniqueIds.add(id);
            scanner.nextLine(); // Consume newline
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Branch: ");
            String branch = scanner.nextLine();

            students.add(new Student(id, name, age, grade, branch));
        }

        // Sort students by branch, then by descending grade
        students.sort(Comparator.comparing(Student::getBranch)
                .thenComparing(Comparator.comparing(Student::getGrade).reversed()));

        // Group students by branch
        Map<String, List<Student>> groupedByBranch = new HashMap<>();
        for (Student student : students) {
            groupedByBranch.computeIfAbsent(student.getBranch(), k -> new ArrayList<>()).add(student);
        }

        // Print grouped students
        for (Map.Entry<String, List<Student>> entry : groupedByBranch.entrySet()) {
            System.out.println("Branch: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }

    private static boolean askForMoreStudents(Scanner scanner) {
        System.out.print("Do you want to add more students? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes");
    }
}
