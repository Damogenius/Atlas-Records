class Employee1{
private int pwd=1234;
protected int Salary = 5000;
public int empid=10001;
}
class Hr extends Employee1 {
 void show_diff()
 {
     System.out.println("Employee ID: " + empid);
     System.out.println("Salary: " + Salary);
     //System.out.println("PWD " + pwd);
     //Private variable cannot be accessed
 }

}

class Task037{
    public static void main(String[] args) {
        Hr obj = new Hr();
        obj.show_diff();
        System.out.println(obj.empid);
        System.out.println(obj.Salary);
}
}
