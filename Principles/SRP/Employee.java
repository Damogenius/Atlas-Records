package Principles.SRP;

// Employee class only holds employee data
public class Employee {
    private String name;
    private String email;
    private double salary;

    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // Getters only, no extra responsibilities here
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getSalary() { return salary; }
}
