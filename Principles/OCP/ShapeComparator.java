package Principles.OCP;

// Shape interface with area method
 interface Shape {
    double area();
}

// Square implements Shape
 class Square implements Shape {
    int height;
    public Square(int height) {
        this.height = height;
    }
    @Override
    public double area() {
        return height * height;
    }
}

// Circle implements Shape
 class Circle implements Shape {
    int r;
    public Circle(int r) {
        this.r = r;
    }
    @Override
    public double area() {
        return Math.PI * r * r;
    }
}

// Class to compare any shapes
public class ShapeComparator {
    public int compareArea(Shape a, Shape b) {
        return Double.compare(a.area(), b.area());
    }
}
