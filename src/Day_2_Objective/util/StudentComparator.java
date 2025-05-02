package Day_2_Objective.util;

import Day_2_Objective.model.Student;
import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    private String criteria;

    public StudentComparator(String criteria) {
        this.criteria = criteria;
    }

    @Override
    public int compare(Student s1, Student s2) {
        switch (criteria) {
            case "name":
                return s1.getName().compareTo(s2.getName());
            case "year":
                return Integer.compare(s1.getYear(), s2.getYear());
            case "branch":
                return s1.getBranch().compareTo(s2.getBranch());
            default:
                throw new IllegalArgumentException("Invalid sorting criteria: " + criteria);
        }
    }
}
