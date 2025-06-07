public class Task038 {
    public static void main(String[] args) {

        Employee e = new Manager("George W.", "Houston, TX", 43);
        System.out.println("\nCall mailCheck using Employee reference--");
        e.mailCheck();
        e.computePay();
    }
}

abstract class Employee {
    private String name;
    private String address;
    private int number;

    // Constructor
    public Employee(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public double computePay() {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }

    // Concrete method in abstract class
    public void mailCheck() {
        System.out.println("Mailing a check to " + this.name + " " + this.address);
    }

    // toString() method for printing Employee details
    public String toString() {
        return name + " " + address + " " + number;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }
}

class Manager extends Employee {
    public Manager(String name, String address, int number) {
        super(name, address, number);
        System.out.println("Constructing a Manager");
    }

}
