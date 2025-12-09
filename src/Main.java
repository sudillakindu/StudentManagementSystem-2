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
        showWelcomeBanner();
        // Login
        if (login() == true) {
            int choice = 0;
            
            do {
                if (currentRole.equals("teacher")) {
                    showTeacherMenu();
                    System.out.print("\n>>> Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    
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
                        showExitMessage();
                    } else {
                        showErrorMessage("Invalid choice! Please try again.");
                    }
                } else if (currentRole.equals("student")) {
                    showStudentMenu();
                    System.out.print("\n>>> Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    
                    if (choice == 1) {
                        viewMyGrades();
                    } else if (choice == 2) {
                        viewMyAttendance();
                    } else if (choice == 3) {
                        viewMyCourses();
                    } else if (choice == 4) {
                        showExitMessage();
                    } else {
                        showErrorMessage("Invalid choice! Please try again.");
                    }
                }
            } while ((currentRole.equals("teacher") && choice != 6) || (currentRole.equals("student") && choice != 4));
        } else {
            showErrorMessage("Login failed! Exiting system.");
        }
    }
    
    // Welcome banner
    public static void showWelcomeBanner() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                               ║");
        System.out.println("║                   STUDENT MANAGEMENT SYSTEM                   ║");
        System.out.println("║                                                               ║");
        System.out.println("║               Welcome to University of Kelaniya               ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    // Success message
    public static void showSuccessMessage(String message) {
        System.out.println();
        System.out.println("✓ SUCCESS: " + message);
        System.out.println();
    }
    
    // Error message
    public static void showErrorMessage(String message) {
        System.out.println();
        System.out.println("✗ ERROR: " + message);
        System.out.println();
    }
    
    // Exit message
    public static void showExitMessage() {
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                               ║");
        System.out.println("║     Thank you for using Student Management System!            ║");
        System.out.println("║                   Have a great day!                           ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    // Login method
    public static boolean login() {
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                        LOGIN PAGE                             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Email    : ");
        String email = scanner.nextLine();
        System.out.print("  Password : ");
        String password = scanner.nextLine();
        System.out.println();
        
        if (email.equals(TEACHER_EMAIL) && password.equals(TEACHER_PASSWORD)) {
            currentRole = "teacher";
            System.out.println("✓ Login successful! Welcome Teacher.");
            System.out.println();
            return true;
        } else if (email.equals(STUDENT_EMAIL) && password.equals(STUDENT_PASSWORD)) {
            currentRole = "student";
            System.out.println("✓ Login successful! Welcome Student.");
            System.out.println();
            return true;
        } else {
            showErrorMessage("Invalid email or password!");
            return false;
        }
    }
    
    // Show teacher menu
    public static void showTeacherMenu() {
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║          STUDENT MANAGEMENT SYSTEM (TEACHER)                  ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                               ║");
        System.out.println("║  1. Student Management                                        ║");
        System.out.println("║  2. Course Management                                         ║");
        System.out.println("║  3. Teacher Management                                        ║");
        System.out.println("║  4. Grade Management                                          ║");
        System.out.println("║  5. Attendance Management                                     ║");
        System.out.println("║  6. Exit                                                      ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
    
    // Show student menu
    public static void showStudentMenu() {
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║          STUDENT MANAGEMENT SYSTEM (STUDENT)                  ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                               ║");
        System.out.println("║  1. View My Grades                                            ║");
        System.out.println("║  2. View My Attendance                                        ║");
        System.out.println("║  3. View My Courses                                           ║");
        System.out.println("║  4. Exit                                                      ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
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
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("            PERFORMANCE REPORT FOR " + currentStudent.getName() + "                            ");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            Grade.displayPerformanceReport(grades, gradeCount, currentStudent);
        } else {
            showErrorMessage("Student profile not found in system.");
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
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║                  MY ATTENDANCE RECORDS                        ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            System.out.println();
            boolean found = false;
            for (int i = 0; i < attendanceCount; i++) {
                if (attendances[i].getStudent().getEmail().equals(STUDENT_EMAIL)) {
                    System.out.println("  Course : " + attendances[i].getCourse().getCourseName());
                    System.out.println("  Date   : " + attendances[i].getDate());
                    System.out.println("  Status : " + attendances[i].getStatus());
                    System.out.println();
                    found = true;
                }
            }
            if (found == false) {
                System.out.println("  No attendance records found.");
                System.out.println();
            }
        } else {
            showErrorMessage("Student profile not found in system.");
        }
    }
    
    // View my courses
    public static void viewMyCourses() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    MY ENROLLED COURSES                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
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
                System.out.println("  Course ID   : " + courses[i].getCourseId());
                System.out.println("  Course Name : " + courses[i].getCourseName());
                if (courses[i].getTeacher() != null) {
                    System.out.println("  Teacher     : " + courses[i].getTeacher().getName());
                }
                System.out.println();
                found = true;
            }
            if (found == false) {
                System.out.println("  No courses enrolled.");
                System.out.println();
            }
        } else {
            showErrorMessage("Student profile not found in system.");
        }
    }
    
    // Student menu
    public static void studentMenu() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║                   STUDENT MANAGEMENT                          ║");
            System.out.println("╠═══════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                               ║");
            System.out.println("║  1. Add Student                                               ║");
            System.out.println("║  2. Update Student                                            ║");
            System.out.println("║  3. Display Student                                           ║");
            System.out.println("║  4. Back to Main Menu                                         ║");
            System.out.println("║                                                               ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            System.out.print("\n>>> Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            
            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                updateStudent();
            } else if (choice == 3) {
                displayStudent();
            } else if (choice == 4) {
                break;
            } else {
                showErrorMessage("Invalid choice!");
            }
        } while (choice != 4);
    }
    
    // Add student
    public static void addStudent() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                      ADD NEW STUDENT                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Student ID : ");
        String studentId = scanner.nextLine();
        System.out.print("  Enter Name       : ");
        String name = scanner.nextLine();
        System.out.print("  Enter Email      : ");
        String email = scanner.nextLine();
        System.out.println();
        
        Student student = new Student(studentCount + 1, name, studentId, email);
        students[studentCount] = student;
        studentCount = studentCount + 1;
        showSuccessMessage("Student added successfully!");
    }
    
    // Update student
    public static void updateStudent() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    UPDATE STUDENT                             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Student ID to update : ");
        String studentId = scanner.nextLine();
        System.out.println();
        
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                System.out.print("  Enter new Name              : ");
                String newName = scanner.nextLine();
                System.out.print("  Enter new Email             : ");
                String newEmail = scanner.nextLine();
                System.out.println();
                
                students[i].setName(newName);
                students[i].setEmail(newEmail);
                showSuccessMessage("Student updated successfully!");
                found = true;
                break;
            }
        }
        
        if (found == false) {
            showErrorMessage("Student not found!");
        }
    }
    
    // Display student
    public static void displayStudent() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                  STUDENT DETAILS                             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Student ID to display : ");
        String studentId = scanner.nextLine();
        System.out.println();
        
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                students[i].displayDetails();
                found = true;
                break;
            }
        }
        
        if (found == false) {
            showErrorMessage("Student not found!");
        }
    }
    
    // Course menu
    public static void courseMenu() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    COURSE MANAGEMENT                          ║");
            System.out.println("╠═══════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                               ║");
            System.out.println("║  1. Add Course                                                ║");
            System.out.println("║  2. Remove Course                                             ║");
            System.out.println("║  3. Display Courses                                           ║");
            System.out.println("║  4. Assign Student to Course                                  ║");
            System.out.println("║  5. Back to Main Menu                                         ║");
            System.out.println("║                                                               ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            System.out.print("\n>>> Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            
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
                showErrorMessage("Invalid choice!");
            }
        } while (choice != 5);
    }
    
    // Add course
    public static void addCourse() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                       ADD NEW COURSE                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Course ID   : ");
        String courseId = scanner.nextLine();
        System.out.print("  Enter Course Name : ");
        String courseName = scanner.nextLine();
        System.out.println();
        
        Course course = new Course(courseId, courseName);
        courses[courseCount] = course;
        courseCount = courseCount + 1;
        showSuccessMessage("Course added successfully!");
    }
    
    // Remove course
    public static void removeCourse() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                      REMOVE COURSE                            ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Course ID to remove : ");
        String courseId = scanner.nextLine();
        System.out.println();
        
        boolean found = false;
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courseCount = courseCount - 1;
                showSuccessMessage("Course removed successfully!");
                found = true;
                break;
            }
        }
        
        if (found == false) {
            showErrorMessage("Course not found!");
        }
    }
    
    // Display courses
    public static void displayCourses() {
        if (courseCount == 0) {
            showErrorMessage("No courses available.");
            return;
        }
        
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                        ALL COURSES                            ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        for (int i = 0; i < courseCount; i++) {
            courses[i].displayCourse();
        }
    }
    
    // Assign student to course
    public static void assignStudentToCourse() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║              ASSIGN STUDENT TO COURSE                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Course ID  : ");
        String courseId = scanner.nextLine();
        System.out.print("  Enter Student ID : ");
        String studentId = scanner.nextLine();
        System.out.println();
        
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
            System.out.println();
        } else {
            showErrorMessage("Course or Student not found!");
        }
    }
    
    // Teacher menu
    public static void teacherMenu() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║                   TEACHER MANAGEMENT                          ║");
            System.out.println("╠═══════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                               ║");
            System.out.println("║  1. Add Teacher                                               ║");
            System.out.println("║  2. Assign Course to Teacher                                  ║");
            System.out.println("║  3. View Teacher                                              ║");
            System.out.println("║  4. Back to Main Menu                                         ║");
            System.out.println("║                                                               ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            System.out.print("\n>>> Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            
            if (choice == 1) {
                addTeacher();
            } else if (choice == 2) {
                assignCourseToTeacher();
            } else if (choice == 3) {
                viewTeacher();
            } else if (choice == 4) {
                break;
            } else {
                showErrorMessage("Invalid choice!");
            }
        } while (choice != 4);
    }
    
    // Add teacher
    public static void addTeacher() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                      ADD NEW TEACHER                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Teacher ID : ");
        String teacherId = scanner.nextLine();
        System.out.print("  Enter Name       : ");
        String name = scanner.nextLine();
        System.out.print("  Enter Subject    : ");
        String subject = scanner.nextLine();
        System.out.println();
        
        Teacher teacher = new Teacher(teacherCount + 1, name, teacherId, subject);
        teachers[teacherCount] = teacher;
        teacherCount = teacherCount + 1;
        showSuccessMessage("Teacher added successfully!");
    }
    
    // Assign course to teacher
    public static void assignCourseToTeacher() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║            ASSIGN COURSE TO TEACHER                           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Teacher ID : ");
        String teacherId = scanner.nextLine();
        System.out.print("  Enter Course ID  : ");
        String courseId = scanner.nextLine();
        System.out.println();
        
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
            showSuccessMessage("Course assigned to teacher successfully!");
        } else {
            showErrorMessage("Teacher or Course not found!");
        }
    }
    
    // View teacher
    public static void viewTeacher() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    TEACHER DETAILS                            ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Teacher ID : ");
        String teacherId = scanner.nextLine();
        System.out.println();
        
        boolean found = false;
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getTeacherId().equals(teacherId)) {
                teachers[i].displayDetails();
                found = true;
                break;
            }
        }
        
        if (found == false) {
            showErrorMessage("Teacher not found!");
        }
    }
    
    // Grade menu
    public static void gradeMenu() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║                     GRADE MANAGEMENT                          ║");
            System.out.println("╠═══════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                               ║");
            System.out.println("║  1. Add Grade                                                 ║");
            System.out.println("║  2. Calculate Average                                         ║");
            System.out.println("║  3. Display Performance Report                                ║");
            System.out.println("║  4. Back to Main Menu                                         ║");
            System.out.println("║                                                               ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            System.out.print("\n>>> Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            
            if (choice == 1) {
                addGrade();
            } else if (choice == 2) {
                calculateAverage();
            } else if (choice == 3) {
                displayPerformanceReport();
            } else if (choice == 4) {
                break;
            } else {
                showErrorMessage("Invalid choice!");
            }
        } while (choice != 4);
    }
    
    // Add grade
    public static void addGrade() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                        ADD GRADE                              ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Student ID : ");
        String studentId = scanner.nextLine();
        System.out.print("  Enter Course ID  : ");
        String courseId = scanner.nextLine();
        System.out.print("  Enter Grade      : ");
        double grade = scanner.nextDouble();
        scanner.nextLine();
        System.out.println();
        
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
            showSuccessMessage("Grade added successfully!");
        } else {
            showErrorMessage("Student or Course not found!");
        }
    }
    
    // Calculate average
    public static void calculateAverage() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                   CALCULATE AVERAGE                           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Student ID : ");
        String studentId = scanner.nextLine();
        System.out.println();
        
        Student student = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                student = students[i];
                break;
            }
        }
        
        if (student != null) {
            double average = Grade.calculateAverage(grades, gradeCount, student);
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║  Average grade for " + student.getName() + " : " + average + "                           ");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            System.out.println();
        } else {
            showErrorMessage("Student not found!");
        }
    }
    
    // Display performance report
    public static void displayPerformanceReport() {
        System.out.print("  Enter Student ID : ");
        String studentId = scanner.nextLine();
        System.out.println();
        
        Student student = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                student = students[i];
                break;
            }
        }
        
        if (student != null) {
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("            PERFORMANCE REPORT FOR " + student.getName() + "                            ");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            Grade.displayPerformanceReport(grades, gradeCount, student);
        } else {
            showErrorMessage("Student not found!");
        }
    }
    
    // Attendance menu
    public static void attendanceMenu() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║                  ATTENDANCE MANAGEMENT                        ║");
            System.out.println("╠═══════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                               ║");
            System.out.println("║  1. Record Attendance                                         ║");
            System.out.println("║  2. View Attendance by Course                                 ║");
            System.out.println("║  3. Display Attendance Summary                                ║");
            System.out.println("║  4. Back to Main Menu                                         ║");
            System.out.println("║                                                               ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            System.out.print("\n>>> Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            
            if (choice == 1) {
                recordAttendance();
            } else if (choice == 2) {
                viewAttendanceByCourse();
            } else if (choice == 3) {
                displayAttendanceSummary();
            } else if (choice == 4) {
                break;
            } else {
                showErrorMessage("Invalid choice!");
            }
        } while (choice != 4);
    }
    
    // Record attendance
    public static void recordAttendance() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    RECORD ATTENDANCE                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.print("  Enter Student ID        : ");
        String studentId = scanner.nextLine();
        System.out.print("  Enter Course ID         : ");
        String courseId = scanner.nextLine();
        System.out.print("  Enter Date (DD-MM-YYYY) : ");
        String date = scanner.nextLine();
        System.out.print("  Enter Status (Present/Absent) : ");
        String status = scanner.nextLine();
        System.out.println();
        
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
            showSuccessMessage("Attendance recorded successfully!");
        } else {
            showErrorMessage("Student or Course not found!");
        }
    }
    
    // View attendance by course
    public static void viewAttendanceByCourse() {
        System.out.print("  Enter Course ID : ");
        String courseId = scanner.nextLine();
        System.out.println();
        
        Course course = null;
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                course = courses[i];
                break;
            }
        }
        
        if (course != null) {
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("         ATTENDANCE FOR COURSE: " + course.getCourseName() + "                            ");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝");
            Attendance.viewAttendanceByCourse(attendances, attendanceCount, course);
        } else {
            showErrorMessage("Course not found!");
        }
    }
    
    // Display attendance summary
    public static void displayAttendanceSummary() {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    ATTENDANCE SUMMARY                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.println();
        Attendance.displaySummary(attendances, attendanceCount);
    }
}
