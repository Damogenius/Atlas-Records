package Methods_implementation.Bridge_Design_Pattern;

class DrawingPicture implements DrawingAPI {
    public void drawSquare(int x, int y, int size) {
        System.out.println("Drawing square using Picture API at (" + x + "," + y + ") with size " + size);
    }
}

class DrawingFrame implements DrawingAPI {
    public void drawSquare(int x, int y, int size) {
        System.out.println("Drawing square using Frame API at (" + x + "," + y + ") with size " + size);
    }
}

class ExcalidrawAPI implements DrawingAPI {
    public void drawSquare(int x, int y, int size) {
        System.out.println("Drawing square using Excalidraw API at (" + x + "," + y + ") with size " + size);
    }
}
