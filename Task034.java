public class Task034 {
     static void add(int x, int y) {
        System.out.printf("x - %d, y - %d%n",x,y);
    }

    static void add(int x, int y, int z) {
        System.out.printf("x - %d, y - %d, z - %d%n",x,y,z);

    }

    public static void main(String[] args) {

        add(10, 20, 30);
        add(50, 100);
    }
}
