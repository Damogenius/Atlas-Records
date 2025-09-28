package Principles.SRP_Violation;

import java.io.FileWriter;
import java.io.IOException;

public class Customer {
    String name;
    String custID;

    public Customer(String name, String custID) {
        this.name = name;
        this.custID = custID;
    }

    public String getName() {
        return name;
    }

    public String getCustID() {  // Fixed missing parentheses
        return custID;
    }

    // SRP Violation: Customer class should NOT handle saving to file
    public void saveData() {
        try {
            FileWriter fw = new FileWriter(name + ".txt");
            fw.write("The customer name is " + name + "\t");
            fw.write("The customer id is " + custID + "\t");
            fw.close();  // Remember to close the FileWriter
            System.out.println("The data is saved in the file with your name");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {  // Fixed method signature
        Customer cobj = new Customer("damo", "C001");
        cobj.saveData();
    }
}
