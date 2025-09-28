package Principles.Liskov_Violation;

abstract class Bird {
    abstract void fly();
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagles fly");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() { // dummy implementation
        System.out.println("Can't fly high but it lays big eggs");
    }
}

class Driverclass {
    public static void main(String[] args) {
        Bird eagle = new Eagle();
        Bird ostrich = new Ostrich();

        eagle.fly();
        ostrich.fly();
    }
}
