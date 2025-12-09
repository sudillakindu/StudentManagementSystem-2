// Grade class
public class Grade {
    private Student student;
    private Course course;
    private double grade;
    
    // Constructor
    public Grade(Student student, Course course, double grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }
    
    // Getter methods (Encapsulation)
    public Student getStudent() {
        return student;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public double getGrade() {
        return grade;
    }
    
    // Setter methods (Encapsulation)
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    // Calculate average grade
    public static double calculateAverage(Grade[] grades, int count, Student student) {
        double sum = 0;
        int num = 0;
        
        for (int i = 0; i < count; i++) {
            if (grades[i].getStudent().getId() == student.getId()) {
                sum = sum + grades[i].getGrade();
                num = num + 1;
            }
        }
        
        if (num == 0) {
            return 0;
        }
        
        double average = sum / num;
        return average;
    }
    
    // Display performance report
    public static void displayPerformanceReport(Grade[] grades, int count, Student student) {
        System.out.println();
        
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (grades[i].getStudent().getId() == student.getId()) {
                System.out.println("  Course : " + grades[i].getCourse().getCourseName());
                System.out.println("  Grade  : " + grades[i].getGrade());
                System.out.println();
                found = true;
            }
        }
        
        if (found == true) {
            double average = calculateAverage(grades, count, student);
            System.out.println("  Average Grade : " + average);
            System.out.println();
        } else {
            System.out.println("  No grades found for this student.");
            System.out.println();
        }
    }
}
