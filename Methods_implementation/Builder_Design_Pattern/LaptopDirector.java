package Methods_implementation.Builder_Design_Pattern;

public class LaptopDirector {
    private LaptopBuilder laptopBuilder;

    public LaptopDirector(LaptopBuilder laptopBuilder) {
        this.laptopBuilder = laptopBuilder;
    }

    public Laptop constructLaptop() {
        return laptopBuilder
                .buildMemory(16)
                .buildStorage(512)
                .buildProcessor("Intel i7")
                .buildGraphicsCard("NVIDIA RTX 3060")
                .build();
    }
}
