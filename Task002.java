public class Task002 {
    static int b=11;

    public static void main(String[] args) {
        Task002 obj=new Task002();
        obj.add();
        obj.add();
        obj.add();
    }
    public void add()
    {
        int a = 10;
        a++;
        b++;
        System.out.printf(" a = %d , b = %d%n",a,b);
    }

}
