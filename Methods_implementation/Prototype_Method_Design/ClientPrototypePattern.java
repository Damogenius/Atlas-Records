package Methods_implementation.Prototype_Method_Design;

public class ClientPrototypePattern {
    public static void main(String[] args) {
        ColorPrototype black = new BlackConcretePrototype();
        ColorPrototype white = new WhiteConcretePrototype();

        ColorPrototype clonedBlack = black.cloneColor();
        ColorPrototype clonedWhite = white.cloneColor();

        ((BlackConcretePrototype) clonedBlack).display();
        ((WhiteConcretePrototype) clonedWhite).display();
    }
}

