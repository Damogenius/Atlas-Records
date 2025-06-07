public class Task035 {
    static void add(char x, char y) {
        System.out.printf("x - %c, y - %c%n",x,y);
    }

    static void add(int x, int y) {
        System.out.printf("x - %d, y - %d%n",x,y);

    }

    public static void main(String[] args) {

        add('d','e');
        add(50, 100);
    }
}
