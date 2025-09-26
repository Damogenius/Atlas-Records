package org.example.Junit;



public class Customer {
    private String Fname;
    private String Lname;
    public Customer(String Fname, String Lname) {
        this.Fname = Fname;
        this.Lname = Lname;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }
}
