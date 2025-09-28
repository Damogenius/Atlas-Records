package Principles.SRP;

// Handles sending emails related to employees
public class EmailService {
    public void sendEmail(Employee employee, String message) {
        // code to send email to the employee
        System.out.println("Sending email to " + employee.getEmail() + ": " + message);
    }
}
