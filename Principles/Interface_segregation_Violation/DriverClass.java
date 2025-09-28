package Principles.Interface_segregation_Violation;

interface ICalcShapesArea {
    void calcArea();
    void calcVolume();
}

class Circle implements ICalcShapesArea {
    @Override
    public void calcArea() {
        System.out.println("Calculating area of Circle");
    }
    @Override
    public void calcVolume() {  // forced dummy implementation
        System.out.println("Circle has no volume");
    }
}

class Sphere implements ICalcShapesArea {
    @Override
    public void calcArea() {
        System.out.println("Calculating area of Sphere");
    }
    @Override
    public void calcVolume() {
        System.out.println("Calculating volume of Sphere");
    }
}
class Driverclass {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.calcArea();
        // circle.calcVolume(); // Not available!

        Sphere sphere = new Sphere();
        sphere.calcArea();
        sphere.calcVolume();
    }
}
