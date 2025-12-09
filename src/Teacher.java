// Teacher class extends User (Inheritance)
public class Teacher extends User {
    private String teacherId;
    private String subject;
    
    // Constructor
    public Teacher(int id, String name, String teacherId, String subject) {
        super(id, name);
        this.teacherId = teacherId;
        this.subject = subject;
    }
    
    // Getter methods (Encapsulation)
    public String getTeacherId() {
        return teacherId;
    }
    
    public String getSubject() {
        return subject;
    }
    
    // Setter methods (Encapsulation)
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    // Override display method
    public void displayDetails() {
        System.out.println("Teacher Details:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Subject: " + subject);
    }
}
