package Methods_implementation.Bridge_Design_Pattern;

class Square extends Shape {
    private int x, y, size;

    public Square(int x, int y, int size, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw() {
        drawingAPI.drawSquare(x, y, size);
    }
}
