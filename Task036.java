public class Task036 {
    static void add(int x, float y) {
        System.out.printf("x - %d, y - %.2f%n",x,y);
    }

    static void add(float x, int y) {
        System.out.printf("x - %.2f, y - %d%n",x,y);

    }

    public static void main(String[] args) {

        add(40.50f,20);
        add(50, 60.52f);
    }
}
