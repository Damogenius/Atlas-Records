package Principles;

public class Home_Task_Student {
    private String name;
    private String studentId;
    private double[] marks;
    private double fees;

    // Constructor to initialize student details
    public Home_Task_Student(String name, String studentId, double[] marks, double fees) {
        this.name = name;
        this.studentId = studentId;
        this.marks = marks;
        this.fees = fees;
    }

    // Method to display student registration details
    public void registrationDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentId);
    }

    // Method to calculate the total marks and average
    public void marksCalc() {
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }
        double averageMarks = totalMarks / marks.length;
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + averageMarks);
    }

    // Method to calculate the fees (Just a placeholder logic, you can extend it)
    public void feesCalc() {
        System.out.println("Total Fees: " + fees);
    }

    // Main method for testing
    public static void main(String[] args) {
        double[] marks = {85, 90, 78, 88}; // Example marks for the student
        Home_Task_Student student = new Home_Task_Student("John Doe", "S001", marks, 1500.50);

        // Calling methods
        student.registrationDetails();
        student.marksCalc();
        student.feesCalc();
    }
}
