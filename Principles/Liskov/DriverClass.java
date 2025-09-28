package Principles.Liskov;

abstract class BirdsthatFly {
    abstract void fly();
}

abstract class BirdsthatDontFly {
    abstract void Speciality();
}

class Eagle extends BirdsthatFly {
    @Override
    public void fly() {
        System.out.println("Eagles fly");
    }
}

class Ostrich extends BirdsthatDontFly {
    @Override
    public void Speciality() {
        System.out.println("It lays big egg");
    }
}

class Driverclass {
    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        Ostrich ostrich = new Ostrich();

        eagle.fly();
        ostrich.Speciality();
    }
}
