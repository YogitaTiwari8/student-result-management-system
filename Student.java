import java.util.Map;

public class Student {

    private int rollNo;
    private String name;
    private Map<String, Integer> marks; // subject -> marks

    public Student(int rollNo, String name, Map<String, Integer> marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    // Total marks using Stream API
    public int getTotalMarks() {
        return marks.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Average marks using Stream API
    public double getAverage() {
        return marks.values()
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    // Grade calculation based on average
    public char getGrade() {
        double avg = getAverage();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }

    public boolean isPass() {
        return getAverage() >= 40;
    }

    @Override
    public String toString() {
        return String.format("Roll No: %-3d | Name: %-10s | Total: %-4d | Average: %-6.2f | Grade: %c",
                rollNo, name, getTotalMarks(), getAverage(), getGrade());
    }
}