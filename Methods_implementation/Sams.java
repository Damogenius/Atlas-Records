package Methods_implementation;

public class Sams {
    public static void main(String[] args) {
        PizzaFactory pfObj = new PepperoniPizzaFactory();
        Pizza pObj = pfObj.createPizza();

        pObj.preparation();
        pObj.baking();
        pObj.cutting();
        pObj.boxing();
    }
}
