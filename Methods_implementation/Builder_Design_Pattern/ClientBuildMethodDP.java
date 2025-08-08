package Methods_implementation.Builder_Design_Pattern;

public class ClientBuildMethodDP {
    public static void main(String[] args) {
        LaptopBuilder builder = new LaptopConcreteBuilder();
        LaptopDirector director = new LaptopDirector(builder);

        Laptop myLaptop = director.constructLaptop();

        System.out.println(myLaptop);
    }
}
