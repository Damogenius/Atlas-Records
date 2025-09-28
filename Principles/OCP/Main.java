package Principles.OCP;

public class Main {
    public static void main(String[] args) {
        Shape square = new Square(5);
        Shape circle = new Circle(3);

        ShapeComparator comparator = new ShapeComparator();

        int result = comparator.compareArea(square, circle);
        if(result > 0) {
            System.out.println("Square has larger area");
        } else if(result < 0) {
            System.out.println("Circle has larger area");
        } else {
            System.out.println("Both have equal area");
        }
    }
}
