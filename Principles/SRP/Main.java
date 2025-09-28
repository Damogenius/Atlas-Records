package Principles.SRP;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", "alice@example.com", 75000);

        EmployeeReportGenerator reportGenerator = new EmployeeReportGenerator();
        reportGenerator.generatePdfReport(emp);

        EmailService emailService = new EmailService();
        emailService.sendEmail(emp, "Your monthly report is ready.");
    }
}

