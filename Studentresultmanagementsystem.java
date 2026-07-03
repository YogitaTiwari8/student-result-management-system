import java.util.*;
import java.util.stream.*;

public class Studentresultmanagementsystem {

    public static void main(String[] args) {

        // Create student data
        List<Student> students = createStudentData();

        System.out.println("========== ALL STUDENTS ==========");
        students.forEach(System.out::println);

        // Filter - Passed students
        System.out.println("\n========== PASSED STUDENTS (Average >= 40) ==========");
        List<Student> passedStudents = students.stream()
                .filter(Student::isPass)
                .collect(Collectors.toList());
        passedStudents.forEach(System.out::println);

        // Sort by average
        System.out.println("\n========== STUDENTS SORTED BY AVERAGE ==========");
        List<Student> sortedByAverage = students.stream()
                .sorted(Comparator.comparingDouble(Student::getAverage).reversed())
                .collect(Collectors.toList());
        sortedByAverage.forEach(System.out::println);

        //  Top scorer using reduce
        System.out.println("\n========== TOP SCORER ==========");
        Optional<Student> topScorer = students.stream()
                .reduce((s1, s2) -> s1.getAverage() >= s2.getAverage() ? s1 : s2);
        topScorer.ifPresent(System.out::println);

        // Group students by Grade
        System.out.println("\n========== STUDENTS GROUPED BY GRADE ==========");
        Map<Character, List<Student>> groupedByGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        // Print in sorted grade order (A, B, C, D, F)
        groupedByGrade.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println("\nGrade " + entry.getKey() + ":");
                    entry.getValue().forEach(s -> System.out.println("   " + s));
                });

        // Partition - Pass vs Fail
        System.out.println("\n========== PASS vs FAIL PARTITION ==========");
        Map<Boolean, List<Student>> partitioned = students.stream()
                .collect(Collectors.partitioningBy(Student::isPass));

        System.out.println("Passed Count: " + partitioned.get(true).size());
        System.out.println("Failed Count: " + partitioned.get(false).size());

        // Class average using summarizing
        System.out.println("\n========== CLASS STATISTICS ==========");
        DoubleSummaryStatistics stats = students.stream()
                .mapToDouble(Student::getAverage)
                .summaryStatistics();

        System.out.printf("Class Average : %.2f%n", stats.getAverage());
        System.out.printf("Highest Average : %.2f%n", stats.getMax());
        System.out.printf("Lowest Average : %.2f%n", stats.getMin());
        System.out.println("Total Students : " + stats.getCount());

        // Subject-wise topper
        System.out.println("\n========== SUBJECT-WISE TOPPER ==========");
        Set<String> subjects = students.get(0).getMarks().keySet();
        for (String subject : subjects) {
            Student subjectTopper = students.stream()
                    .max(Comparator.comparingInt(s -> s.getMarks().get(subject)))
                    .orElse(null);
            if (subjectTopper != null) {
                System.out.println(subject + " Topper: " + subjectTopper.getName()
                        + " (" + subjectTopper.getMarks().get(subject) + " marks)");
            }
        }
    }

    // ---------- Helper method: creates sample data ----------
    private static List<Student> createStudentData() {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1, "Aarav", Map.of("Maths", 92, "Science", 88, "English", 85)));
        list.add(new Student(2, "Priya", Map.of("Maths", 76, "Science", 81, "English", 79)));
        list.add(new Student(3, "Rohan", Map.of("Maths", 45, "Science", 38, "English", 50)));
        list.add(new Student(4, "Simran", Map.of("Maths", 65, "Science", 70, "English", 68)));
        list.add(new Student(5, "Karan", Map.of("Maths", 30, "Science", 25, "English", 35)));
        list.add(new Student(6, "Ananya", Map.of("Maths", 95, "Science", 91, "English", 89)));
        list.add(new Student(7, "Vikram", Map.of("Maths", 58, "Science", 62, "English", 55)));

        return list;
    }
}