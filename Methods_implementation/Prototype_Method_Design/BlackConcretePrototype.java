package Methods_implementation.Prototype_Method_Design;

public class BlackConcretePrototype implements ColorPrototype {
    private String colorName;

    public BlackConcretePrototype() {
        this.colorName = "Black";
    }

    @Override
    public ColorPrototype cloneColor() {
        return new BlackConcretePrototype(); // shallow copy is enough here
    }

    public void display() {
        System.out.println("This is " + colorName + " color.");
    }
}
