package Java_collections_worksheet_1;

import java.util.*;

public class Q15_College_Subject_Allotment {
    private Map<String, List<String>> studentSubjects = new HashMap<>();
    private Map<String, List<String>> subjectStudents = new HashMap<>();

    public void allotSubject(String student, String subject) {
        List<String> subjects = studentSubjects.computeIfAbsent(student, k -> new ArrayList<>());
        if (subjects.contains(subject)) {
            System.out.println("Subject " + subject + " is already allotted to student " + student + " earlier.");
        } else {
            subjects.add(subject);
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
            System.out.println("Subject allotted successfully.");
        }
    }

    public List<String> getSubjects(String student) {
        return studentSubjects.getOrDefault(student, Collections.emptyList());
    }

    public List<String> getStudents(String subject) {
        return subjectStudents.getOrDefault(subject, Collections.emptyList());
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Allot Subject to Student");
            System.out.println("2. Get Subjects of Student");
            System.out.println("3. Get Students of Subject");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String student = scanner.nextLine();
                    System.out.print("Enter subject name: ");
                    String subject = scanner.nextLine();
                    allotSubject(student, subject);
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    student = scanner.nextLine();
                    List<String> subjects = getSubjects(student);
                    System.out.println("Subjects of " + student + ": " + subjects);
                    break;
                case 3:
                    System.out.print("Enter subject name: ");
                    subject = scanner.nextLine();
                    List<String> students = getStudents(subject);
                    System.out.println("Students who chose " + subject + ": " + students);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Q15_College_Subject_Allotment allotment = new Q15_College_Subject_Allotment();
        allotment.displayMenu();
    }
}
