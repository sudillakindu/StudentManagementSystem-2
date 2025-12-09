// Student class extends User (Inheritance)
public class Student extends User {
    private String studentId;
    private String email;
    
    // Constructor
    public Student(int id, String name, String studentId, String email) {
        super(id, name);
        this.studentId = studentId;
        this.email = email;
    }
    
    // Getter methods (Encapsulation)
    public String getStudentId() {
        return studentId;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setter methods (Encapsulation)
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Override display method
    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Student ID: " + studentId);
        System.out.println("Email: " + email);
    }
}
