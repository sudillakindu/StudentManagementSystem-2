// Attendance class
public class Attendance {
    private Student student;
    private Course course;
    private String date;
    private String status;
    
    // Constructor
    public Attendance(Student student, Course course, String date, String status) {
        this.student = student;
        this.course = course;
        this.date = date;
        this.status = status;
    }
    
    // Getter methods (Encapsulation)
    public Student getStudent() {
        return student;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getStatus() {
        return status;
    }
    
    // View attendance by course
    public static void viewAttendanceByCourse(Attendance[] attendances, int count, Course course) {
        System.out.println();
        
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (attendances[i].getCourse().getCourseId().equals(course.getCourseId())) {
                System.out.println("  Student : " + attendances[i].getStudent().getName());
                System.out.println("  Date    : " + attendances[i].getDate());
                System.out.println("  Status  : " + attendances[i].getStatus());
                System.out.println();
                found = true;
            }
        }
        
        if (found == false) {
            System.out.println("  No attendance records found for this course.");
            System.out.println();
        }
    }
    
    // Display attendance summary
    public static void displaySummary(Attendance[] attendances, int count) {
        int present = 0;
        int absent = 0;
        
        for (int i = 0; i < count; i++) {
            if (attendances[i].getStatus().equals("Present")) {
                present = present + 1;
            } else {
                absent = absent + 1;
            }
        }
        
        System.out.println("  Total Records : " + count);
        System.out.println("  Present       : " + present);
        System.out.println("  Absent        : " + absent);
        System.out.println();
    }
}
