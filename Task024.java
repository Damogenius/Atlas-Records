class Student{
    public String name;
    Student(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}

public class Task024{
    public static void main (String[] args){

        // declares an Array and initializing the
        // elements of the array
        Student[] myStudents = new Student[]{
                new Student("19"),new Student("30"),
                new Student("20"),new Student("40")
        };
        // accessing the elements of the specified array
        for(Student m:myStudents){
            System.out.println(m);
        }
    }
}
