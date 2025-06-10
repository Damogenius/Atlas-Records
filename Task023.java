class Student1 {
    public int roll_no;
    public String name;

    public Student1(int Roll_no, String Name) {
        this.roll_no = Roll_no;
        this.name = Name;
    }
}

    public class Task023 {
    public static void main(String[] args){


        // declares an Array of Student
        Student1[] arr;
  // allocating memory for 5 objects of type Student.
        arr = new Student1[5];

        // initialize the elements of the array
        arr[0] = new Student1(1, "Damo");
        arr[1] = new Student1(2, "Surya");
        arr[2] = new Student1(3, "Praka");
        arr[3] = new Student1(4, "Santho");
        arr[4] = new Student1(5, "Vicky");

        // accessing the elements of the specified array
        for (int i = 0; i < arr.length; i++)
            System.out.println("Element at " + i + " : { "
                    + arr[i].roll_no + " "
                    + arr[i].name+" }");
    }
}
