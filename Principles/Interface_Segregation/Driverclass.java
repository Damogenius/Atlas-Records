package Principles.Interface_Segregation;

// Interface for 2D shape calculations
interface ICalcArea {
    void calcArea();
    void calcPerimeter();
}

// Interface for 3D shape calculations
interface ICalcVolume {
    void calcVolume();
}

// Circle implements only ICalcArea (2D)
class Circle implements ICalcArea {
    @Override
    public void calcArea() {
        System.out.println("Calculating area of Circle");
    }

    @Override
    public void calcPerimeter() {
        System.out.println("Calculating perimeter of Circle");
    }
}

// Sphere implements both ICalcArea and ICalcVolume (3D)
class Sphere implements ICalcArea, ICalcVolume {
    @Override
    public void calcArea() {
        System.out.println("Calculating surface area of Sphere");
    }

    @Override
    public void calcPerimeter() {
        System.out.println("Perimeter not applicable to Sphere");
    }

    @Override
    public void calcVolume() {
        System.out.println("Calculating volume of Sphere");
    }
}

// Driver class with main method
public class Driverclass {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.calcArea();
        circle.calcPerimeter();

        Sphere sphere = new Sphere();
        sphere.calcArea();
        sphere.calcPerimeter();
        sphere.calcVolume();
    }
}
