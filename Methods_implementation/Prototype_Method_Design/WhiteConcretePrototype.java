package Methods_implementation.Prototype_Method_Design;

public class WhiteConcretePrototype implements ColorPrototype {
    private String colorName;

    public WhiteConcretePrototype() {
        this.colorName = "White";
    }

    @Override
    public ColorPrototype cloneColor() {
        return new WhiteConcretePrototype(); // another new instance
    }

    public void display() {
        System.out.println("This is " + colorName + " color.");
    }
}

