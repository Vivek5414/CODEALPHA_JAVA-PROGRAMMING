import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();  // consume newline

        // INPUT SECTION
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine(); 

            students.add(new Student(name, marks));
        }

        // PROCESSING SECTION
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topper = "", lowestScorer = "";

        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                topper = s.name;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
                lowestScorer = s.name;
            }
        }

        double average = total / n;

        // OUTPUT: SUMMARY REPORT
        System.out.println("\n============================");
        System.out.println("     STUDENT SUMMARY REPORT");
        System.out.println("============================\n");

        System.out.println("Total Students : " + n);
        System.out.println("Average Marks  : " + average);
        System.out.println("Highest Marks  : " + highest + " ( " + topper + " )");
        System.out.println("Lowest Marks   : " + lowest + " ( " + lowestScorer + " )");

        System.out.println("\n--- All Students ---");
        for (Student s : students) {
            System.out.println(s.name + " : " + s.marks);
        }

        sc.close();
    }
}
