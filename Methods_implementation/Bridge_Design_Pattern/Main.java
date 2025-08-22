package Methods_implementation.Bridge_Design_Pattern;

public class Main {
    public static void main(String[] args) {
        Shape square1 = new Square(10, 20, 30, new DrawingPicture());
        Shape square2 = new Square(50, 50, 40, new DrawingFrame());
        Shape square3 = new Square(5, 5, 25, new ExcalidrawAPI());

        square1.draw();
        square2.draw();
        square3.draw();
    }
}
