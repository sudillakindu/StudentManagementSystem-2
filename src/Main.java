import java.util.Scanner;

// Main class
public class Main {
    // Login credentials
    private static final String TEACHER_EMAIL = "teacher@school.com";
    private static final String TEACHER_PASSWORD = "teacher123";
    private static final String STUDENT_EMAIL = "student@school.com";
    private static final String STUDENT_PASSWORD = "student123";
    
    private static String currentRole = "";
    
    // Arrays to store data
    private static Student[] students = new Student[100];
    private static int studentCount = 0;
    
    private static Course[] courses = new Course[50];
    private static int courseCount = 0;
    
    private static Teacher[] teachers = new Teacher[50];
    private static int teacherCount = 0;
    
    private static Grade[] grades = new Grade[200];
    private static int gradeCount = 0;
    
    private static Attendance[] attendances = new Attendance[500];
    private static int attendanceCount = 0;
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Login
        if (login() == true) {
            int choice = 0;
            
            do {
                if (currentRole.equals("teacher")) {
                    showTeacherMenu();
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (choice == 1) {
                        studentMenu();
                    } else if (choice == 2) {
                        courseMenu();
                    } else if (choice == 3) {
                        teacherMenu();
                    } else if (choice == 4) {
                        gradeMenu();
                    } else if (choice == 5) {
                        attendanceMenu();
                    } else if (choice == 6) {
                        System.out.println("Thank you for using Student Management System!");
                    } else {
                        System.out.println("Invalid choice! Please try again.");
                    }
                } else if (currentRole.equals("student")) {
                    showStudentMenu();
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (choice == 1) {
                        viewMyGrades();
                    } else if (choice == 2) {
                        viewMyAttendance();
                    } else if (choice == 3) {
                        viewMyCourses();
                    } else if (choice == 4) {
                        System.out.println("Thank you for using Student Management System!");
                    } else {
                        System.out.println("Invalid choice! Please try again.");
                    }
                }
            } while ((currentRole.equals("teacher") && choice != 6) || (currentRole.equals("student") && choice != 4));
        } else {
            System.out.println("Login failed! Exiting system.");
        }
    }
    
    // Login method
    public static boolean login() {
        System.out.println("\n===== Login =====");
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        if (email.equals(TEACHER_EMAIL) && password.equals(TEACHER_PASSWORD)) {
            currentRole = "teacher";
            System.out.println("Login successful! Welcome Teacher.");
            return true;
        } else if (email.equals(STUDENT_EMAIL) && password.equals(STUDENT_PASSWORD)) {
            currentRole = "student";
            System.out.println("Login successful! Welcome Student.");
            return true;
        } else {
            System.out.println("Invalid email or password!");
            return false;
        }
    }
    
    // Show teacher menu
    public static void showTeacherMenu() {
        System.out.println("\n===== Student Management System (Teacher) =====");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Teacher Management");
        System.out.println("4. Grade Management");
        System.out.println("5. Attendance Management");
        System.out.println("6. Exit");
        System.out.println("===============================================");
    }
    
    // Show student menu
    public static void showStudentMenu() {
        System.out.println("\n===== Student Management System (Student) =====");
        System.out.println("1. View My Grades");
        System.out.println("2. View My Attendance");
        System.out.println("3. View My Courses");
        System.out.println("4. Exit");
        System.out.println("===============================================");
    }
    
    // View my grades
    public static void viewMyGrades() {
        Student currentStudent = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getEmail().equals(STUDENT_EMAIL)) {
                currentStudent = students[i];
                break;
            }
        }
        
        if (currentStudent != null) {
            Grade.displayPerformanceReport(grades, gradeCount, currentStudent);
        } else {
            System.out.println("Student profile not found in system.");
        }
    }
    
    // View my attendance
    public static void viewMyAttendance() {
        Student currentStudent = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getEmail().equals(STUDENT_EMAIL)) {
                currentStudent = students[i];
                break;
            }
        }
        
        if (currentStudent != null) {
            System.out.println("\nMy Attendance Records:");
            System.out.println("-----------------------------------");
            boolean found = false;
            for (int i = 0; i < attendanceCount; i++) {
                if (attendances[i].getStudent().getEmail().equals(STUDENT_EMAIL)) {
                    System.out.println("Course: " + attendances[i].getCourse().getCourseName());
                    System.out.println("Date: " + attendances[i].getDate());
                    System.out.println("Status: " + attendances[i].getStatus());
                    System.out.println("---");
                    found = true;
                }
            }
            if (found == false) {
                System.out.println("No attendance records found.");
            }
        } else {
            System.out.println("Student profile not found in system.");
        }
    }
    
    // View my courses
    public static void viewMyCourses() {
        System.out.println("\nMy Enrolled Courses:");
        System.out.println("-----------------------------------");
        Student currentStudent = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getEmail().equals(STUDENT_EMAIL)) {
                currentStudent = students[i];
                break;
            }
        }
        
        if (currentStudent != null) {
            boolean found = false;
            for (int i = 0; i < courseCount; i++) {
                System.out.println("Course ID: " + courses[i].getCourseId());
                System.out.println("Course Name: " + courses[i].getCourseName());
                if (courses[i].getTeacher() != null) {
                    System.out.println("Teacher: " + courses[i].getTeacher().getName());
                }
                System.out.println("---");
                found = true;
            }
            if (found == false) {
                System.out.println("No courses enrolled.");
            }
        } else {
            System.out.println("Student profile not found in system.");
        }
    }
    
    // Student menu
    public static void studentMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Display Student");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                updateStudent();
            } else if (choice == 3) {
                displayStudent();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
    
    // Add student
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        Student student = new Student(studentCount + 1, name, studentId, email);
        students[studentCount] = student;
        studentCount = studentCount + 1;
        System.out.println("Student added successfully!");
    }
    
    // Update student
    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String studentId = scanner.nextLine();
        
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                System.out.print("Enter new Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new Email: ");
                String newEmail = scanner.nextLine();
                
                students[i].setName(newName);
                students[i].setEmail(newEmail);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }
        
        if (found == false) {
            System.out.println("Student not found!");
        }
    }
    
    // Display student
    public static void displayStudent() {
        System.out.print("Enter Student ID to display: ");
        String studentId = scanner.nextLine();
        
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                students[i].displayDetails();
                found = true;
                break;
            }
        }
        
        if (found == false) {
            System.out.println("Student not found!");
        }
    }
    
    // Course menu
    public static void courseMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. Display Courses");
            System.out.println("4. Assign Student to Course");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                addCourse();
            } else if (choice == 2) {
                removeCourse();
            } else if (choice == 3) {
                displayCourses();
            } else if (choice == 4) {
                assignStudentToCourse();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
    
    // Add course
    public static void addCourse() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        
        Course course = new Course(courseId, courseName);
        courses[courseCount] = course;
        courseCount = courseCount + 1;
        System.out.println("Course added successfully!");
    }
    
    // Remove course
    public static void removeCourse() {
        System.out.print("Enter Course ID to remove: ");
        String courseId = scanner.nextLine();
        
        boolean found = false;
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courseCount = courseCount - 1;
                System.out.println("Course removed successfully!");
                found = true;
                break;
            }
        }
        
        if (found == false) {
            System.out.println("Course not found!");
        }
    }
    
    // Display courses
    public static void displayCourses() {
        if (courseCount == 0) {
            System.out.println("No courses available.");
            return;
        }
        
        System.out.println("\nAll Courses:");
        System.out.println("-----------------------------------");
        for (int i = 0; i < courseCount; i++) {
            courses[i].displayCourse();
            System.out.println("---");
        }
    }
    
    // Assign student to course
    public static void assignStudentToCourse() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        Course course = null;
        Student student = null;
        
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                course = courses[i];
                break;
            }
        }
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                student = students[i];
                break;
            }
        }
        
        if (course != null && student != null) {
            course.assignStudent(student);
        } else {
            System.out.println("Course or Student not found!");
        }
    }
    
    // Teacher menu
    public static void teacherMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- Teacher Management ---");
            System.out.println("1. Add Teacher");
            System.out.println("2. Assign Course to Teacher");
            System.out.println("3. View Teacher");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                addTeacher();
            } else if (choice == 2) {
                assignCourseToTeacher();
            } else if (choice == 3) {
                viewTeacher();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
    
    // Add teacher
    public static void addTeacher() {
        System.out.print("Enter Teacher ID: ");
        String teacherId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();
        
        Teacher teacher = new Teacher(teacherCount + 1, name, teacherId, subject);
        teachers[teacherCount] = teacher;
        teacherCount = teacherCount + 1;
        System.out.println("Teacher added successfully!");
    }
    
    // Assign course to teacher
    public static void assignCourseToTeacher() {
        System.out.print("Enter Teacher ID: ");
        String teacherId = scanner.nextLine();
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        
        Teacher teacher = null;
        Course course = null;
        
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getTeacherId().equals(teacherId)) {
                teacher = teachers[i];
                break;
            }
        }
        
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                course = courses[i];
                break;
            }
        }
        
        if (teacher != null && course != null) {
            course.setTeacher(teacher);
            System.out.println("Course assigned to teacher successfully!");
        } else {
            System.out.println("Teacher or Course not found!");
        }
    }
    
    // View teacher
    public static void viewTeacher() {
        System.out.print("Enter Teacher ID: ");
        String teacherId = scanner.nextLine();
        
        boolean found = false;
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getTeacherId().equals(teacherId)) {
                teachers[i].displayDetails();
                found = true;
                break;
            }
        }
        
        if (found == false) {
            System.out.println("Teacher not found!");
        }
    }
    
    // Grade menu
    public static void gradeMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- Grade Management ---");
            System.out.println("1. Add Grade");
            System.out.println("2. Calculate Average");
            System.out.println("3. Display Performance Report");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                addGrade();
            } else if (choice == 2) {
                calculateAverage();
            } else if (choice == 3) {
                displayPerformanceReport();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
    
    // Add grade
    public static void addGrade() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();
        
        Student student = null;
        Course course = null;
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                student = students[i];
                break;
            }
        }
        
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                course = courses[i];
                break;
            }
        }
        
        if (student != null && course != null) {
            Grade gradeObj = new Grade(student, course, grade);
            grades[gradeCount] = gradeObj;
            gradeCount = gradeCount + 1;
            System.out.println("Grade added successfully!");
        } else {
            System.out.println("Student or Course not found!");
        }
    }
    
    // Calculate average
    public static void calculateAverage() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                student = students[i];
                break;
            }
        }
        
        if (student != null) {
            double average = Grade.calculateAverage(grades, gradeCount, student);
            System.out.println("Average grade for " + student.getName() + ": " + average);
        } else {
            System.out.println("Student not found!");
        }
    }
    
    // Display performance report
    public static void displayPerformanceReport() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                student = students[i];
                break;
            }
        }
        
        if (student != null) {
            Grade.displayPerformanceReport(grades, gradeCount, student);
        } else {
            System.out.println("Student not found!");
        }
    }
    
    // Attendance menu
    public static void attendanceMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- Attendance Management ---");
            System.out.println("1. Record Attendance");
            System.out.println("2. View Attendance by Course");
            System.out.println("3. Display Attendance Summary");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                recordAttendance();
            } else if (choice == 2) {
                viewAttendanceByCourse();
            } else if (choice == 3) {
                displayAttendanceSummary();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
    
    // Record attendance
    public static void recordAttendance() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Enter Status (Present/Absent): ");
        String status = scanner.nextLine();
        
        Student student = null;
        Course course = null;
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                student = students[i];
                break;
            }
        }
        
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                course = courses[i];
                break;
            }
        }
        
        if (student != null && course != null) {
            Attendance attendance = new Attendance(student, course, date, status);
            attendances[attendanceCount] = attendance;
            attendanceCount = attendanceCount + 1;
            System.out.println("Attendance recorded successfully!");
        } else {
            System.out.println("Student or Course not found!");
        }
    }
    
    // View attendance by course
    public static void viewAttendanceByCourse() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        
        Course course = null;
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                course = courses[i];
                break;
            }
        }
        
        if (course != null) {
            Attendance.viewAttendanceByCourse(attendances, attendanceCount, course);
        } else {
            System.out.println("Course not found!");
        }
    }
    
    // Display attendance summary
    public static void displayAttendanceSummary() {
        Attendance.displaySummary(attendances, attendanceCount);
    }
}
