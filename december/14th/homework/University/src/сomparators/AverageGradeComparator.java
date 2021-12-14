package сomparators;

import entities.Student;

import java.util.Comparator;

public class AverageGradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        double av = o1.getGradeList().stream().mapToDouble(Integer::doubleValue).average().orElse(0d);
        double av1 = o2.getGradeList().stream().mapToDouble(Integer::doubleValue).average().orElse(0d);
        return Double.compare(av, av1);
    }
}
