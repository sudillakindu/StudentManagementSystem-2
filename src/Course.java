// Course class
public class Course {
    private String courseId;
    private String courseName;
    private Teacher teacher;
    private Student[] students;
    private int studentCount;
    
    // Constructor
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.students = new Student[50];
        this.studentCount = 0;
    }
    
    // Getter methods (Encapsulation)
    public String getCourseId() {
        return courseId;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public Teacher getTeacher() {
        return teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    // Method to add student to course
    public void assignStudent(Student student) {
        if (studentCount < 50) {
            students[studentCount] = student;
            studentCount = studentCount + 1;
            System.out.println("✓ Student " + student.getName() + " assigned to course " + courseName);
        } else {
            System.out.println("✗ ERROR: Course is full!");
        }
    }
    
    // Method to display course
    public void displayCourse() {
        System.out.println("  Course ID          : " + courseId);
        System.out.println("  Course Name        : " + courseName);
        if (teacher != null) {
            System.out.println("  Teacher            : " + teacher.getName());
        }
        System.out.println("  Number of Students : " + studentCount);
        System.out.println();
    }
}
