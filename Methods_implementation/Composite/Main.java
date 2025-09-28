package Methods_implementation.Composite;

public class Main {
    public static void main(String[] args) {
        // Create CompanyHead
        CompanyHead head = new CompanyHead("John");

        // Create employees
        HR hr1 = new HR("Alice");
        HR hr2 = new HR("Bob");

        Software dev1 = new Software("Charlie");
        Software dev2 = new Software("David");
        Software dev3 = new Software("Eve");

        // Add employees to head
        head.addEmployee(hr1);
        head.addEmployee(hr2);
        head.addEmployee(dev1);
        head.addEmployee(dev2);
        head.addEmployee(dev3);

        // Show all details
        head.showDetails();
    }
}