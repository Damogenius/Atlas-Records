package Methods_implementation;

public class PepperoniPizza extends Pizza {

    @Override
    public void preparation() {
        System.out.println("Preparing Pepperoni Pizza...");
    }

    @Override
    public void baking() {
        System.out.println("Baking Pepperoni Pizza at 400F for 20 minutes.");
    }

    @Override
    public void cutting() {
        System.out.println("Cutting Pepperoni Pizza into 8 slices.");
    }

    @Override
    public void boxing() {
        System.out.println("Boxing Pepperoni Pizza in a official box.");
    }
}
