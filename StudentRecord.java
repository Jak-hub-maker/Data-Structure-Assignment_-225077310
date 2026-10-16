import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* A course result: one entry in a student's record. */
class Course {
    String code;
    String title;
    int creditHours;
    String grade;   // A, B+, B, C+, C, D+, D, E, F

    Course(String code, String title, int creditHours, String grade) {
        this.code = code;
        this.title = title;
        this.creditHours = creditHours;
        this.grade = grade.toUpperCase();
    }

    double gradePoint() {
        switch (grade) {
            case "A":  return 4.0;
            case "B+": return 3.5;
            case "B":  return 3.0;
            case "C+": return 2.5;
            case "C":  return 2.0;
            case "D+": return 1.5;
            case "D":  return 1.0;
            default:   return 0.0;   // E, F
        }
    }

    static boolean validGrade(String g) {
        switch (g.toUpperCase()) {
            case "A": case "B+": case "B": case "C+":
            case "C": case "D+": case "D": case "E": case "F":
                return true;
            default:
                return false;
        }
    }
}

/* The student record. */
class Student {
    String name;
    String id;
    String programme;
    boolean registered;
    List<Course> courses = new ArrayList<>();

    Student(String name, String id, String programme) {
        this.name = name;
        this.id = id;
        this.programme = programme;
        this.registered = false;
    }

    void addCourse(Course c) {
        courses.add(c);
    }

    /* GPA = sum(gradePoint * creditHours) / sum(creditHours) */
    double gpa() {
        int totalCredits = 0;
        double totalPoints = 0;
        for (Course c : courses) {
            totalCredits += c.creditHours;
            totalPoints += c.gradePoint() * c.creditHours;
        }
        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    String registrationStatus() {
        return registered ? "REGISTERED" : "NOT REGISTERED";
    }

    void displayResults() {
        System.out.println("\n==================================================");
        System.out.println("Name       : " + name);
        System.out.println("Student ID : " + id);
        System.out.println("Programme  : " + programme);
        System.out.println("Status     : " + registrationStatus());
        System.out.println("--------------------------------------------------");
        if (courses.isEmpty()) {
            System.out.println("No course results yet.");
        } else {
            System.out.printf("%-10s %-22s %-8s %-6s %-5s%n",
                    "Code", "Title", "Credits", "Grade", "GP");
            for (Course c : courses) {
                System.out.printf("%-10s %-22s %-8d %-6s %-5.1f%n",
                        c.code, c.title, c.creditHours, c.grade, c.gradePoint());
            }
            System.out.println("--------------------------------------------------");
            System.out.printf("GPA        : %.2f%n", gpa());
        }
        System.out.println("==================================================");
    }
}

public class StudentRecord {
    static Scanner in = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    static Student findById(String id) {
        for (Student s : students) {
            if (s.id.equalsIgnoreCase(id)) return s;
        }
        return null;
    }

    static Student askForStudent() {
        System.out.print("Enter student ID: ");
        Student s = findById(in.nextLine().trim());
        if (s == null) System.out.println("Student not found.");
        return s;
    }

    static void createStudent() {
        System.out.print("Name: ");
        String name = in.nextLine().trim();
        System.out.print("Student ID: ");
        String id = in.nextLine().trim();
        if (findById(id) != null) {
            System.out.println("A student with that ID already exists.");
            return;
        }
        System.out.print("Programme: ");
        String programme = in.nextLine().trim();
        students.add(new Student(name, id, programme));
        System.out.println("Student created.");
    }

    static void addCourseResult() {
        Student s = askForStudent();
        if (s == null) return;
        System.out.print("Course code: ");
        String code = in.nextLine().trim();
        System.out.print("Course title: ");
        String title = in.nextLine().trim();
        System.out.print("Credit hours: ");
        int credits;
        try {
            credits = Integer.parseInt(in.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid credit hours.");
            return;
        }
        System.out.print("Grade (A, B+, B, C+, C, D+, D, E, F): ");
        String grade = in.nextLine().trim();
        if (!Course.validGrade(grade) || credits <= 0) {
            System.out.println("Invalid grade or credit hours.");
            return;
        }
        s.addCourse(new Course(code, title, credits, grade));
        System.out.println("Result added.");
    }

    static void calculateGpa() {
        Student s = askForStudent();
        if (s == null) return;
        System.out.printf("%s's GPA: %.2f%n", s.name, s.gpa());
    }

    static void displayResults() {
        Student s = askForStudent();
        if (s != null) s.displayResults();
    }

    static void setRegistration() {
        Student s = askForStudent();
        if (s == null) return;
        s.registered = !s.registered;
        System.out.println(s.name + " is now " + s.registrationStatus() + ".");
    }

    static void showRegistrationStatus() {
        Student s = askForStudent();
        if (s != null) System.out.println(s.name + ": " + s.registrationStatus());
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Record System ---");
            System.out.println("1. Create a student");
            System.out.println("2. Add a course result");
            System.out.println("3. Calculate GPA");
            System.out.println("4. Display student's results");
            System.out.println("5. Register / unregister a student");
            System.out.println("6. Show registration status");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            if (!in.hasNextLine()) return;
            String choice = in.nextLine().trim();

            switch (choice) {
                case "1": createStudent(); break;
                case "2": addCourseResult(); break;
                case "3": calculateGpa(); break;
                case "4": displayResults(); break;
                case "5": setRegistration(); break;
                case "6": showRegistrationStatus(); break;
                case "0": System.out.println("Goodbye."); return;
                default:  System.out.println("Invalid choice.");
            }
        }
    }
}