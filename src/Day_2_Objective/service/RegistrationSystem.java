package Day_2_Objective.service;

import Day_2_Objective.model.Student;
import Day_2_Objective.model.Course;

import java.util.*;

public class RegistrationSystem {
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();

    // Method to register a student to a course
    public void registerStudentToCourse(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course ID.");
            return;
        }

        if (course.getEnrolledStudents().contains(student)) {
            System.out.println("Student is already enrolled in the course.");
            return;
        }

        if (course.getWaitlist().contains(student)) {
            System.out.println("Student is already waitlisted for the course.");
            return;
        }

        if (course.getEnrolledStudents().size() < course.getCapacity()) {
            course.getEnrolledStudents().add(student);
            System.out.println("Student enrolled in the course.");
        } else {
            course.getWaitlist().add(student);
            System.out.println("Course is full. Student added to the waitlist.");
        }
    }

    // Method to drop a student from a course
    public void dropCourse(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course ID.");
            return;
        }

        if (course.getEnrolledStudents().remove(student)) {
            System.out.println("Student dropped from the course.");
            if (!course.getWaitlist().isEmpty()) {
                Student nextStudent = course.getWaitlist().poll();
                course.getEnrolledStudents().add(nextStudent);
                System.out.println("Next student from waitlist enrolled in the course.");
            }
        } else {
            System.out.println("Student is not enrolled in the course.");
        }
    }

    // Method to list students for a specific course
    public List<Student> listStudentsForCourse(String courseId) {
        Course course = courses.get(courseId);

        if (course == null) {
            System.out.println("Invalid course ID.");
            return Collections.emptyList();
        }

        List<Student> studentList = new ArrayList<>(course.getEnrolledStudents());
        studentList.sort(Comparator.comparing(Student::getName));
        return studentList;
    }

    // Method to list students for a particular branch across all courses
    public List<Student> listStudentsForBranch(String branch) {
        List<Student> studentList = new ArrayList<>();

        for (Course course : courses.values()) {
            for (Student student : course.getEnrolledStudents()) {
                if (student.getBranch().equals(branch)) {
                    studentList.add(student);
                }
            }
        }

        studentList.sort(Comparator.comparing(Student::getName));
        return studentList;
    }

    // Method to list courses sorted by number of enrolled students (descending)
    public List<Course> listCourses() {
        List<Course> courseList = new ArrayList<>(courses.values());
        courseList.sort((c1, c2) -> Integer.compare(c2.getEnrolledStudents().size(), c1.getEnrolledStudents().size()));
        return courseList;
    }

    // Method to filter courses by credits
    public List<Course> filterCoursesByCredits(int credits) {
        List<Course> courseList = new ArrayList<>();

        for (Course course : courses.values()) {
            if (course.getCredits() == credits) {
                courseList.add(course);
            }
        }

        return courseList;
    }

    // Method to filter courses by instructor
    public List<Course> filterCoursesByInstructor(String instructorName) {
        List<Course> courseList = new ArrayList<>();

        for (Course course : courses.values()) {
            if (course.getInstructorName().equals(instructorName)) {
                courseList.add(course);
            }
        }

        return courseList;
    }

    // Method to add a course
    public void addCourse(Course course) {
        if (courses.containsKey(course.getCourseId())) {
            System.out.println("Course with this ID already exists.");
        } else {
            courses.put(course.getCourseId(), course);
            System.out.println("Course added successfully.");
        }
    }

    // Method to remove a course
    public void removeCourse(String courseId) {
        if (courses.remove(courseId) != null) {
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course ID not found.");
        }
    }

    // Method to add a student
    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            System.out.println("Student with this ID already exists.");
        } else {
            students.put(student.getId(), student);
            System.out.println("Student added successfully.");
        }
    }

    // Method to remove a student
    public void removeStudent(String studentId) {
        if (students.remove(studentId) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }
}
