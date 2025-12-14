// User class - parent class (Inheritance)
public class User {
    private int id;
    private String name;
    
    // Constructor
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getter methods (Encapsulation)
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Display method
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}
