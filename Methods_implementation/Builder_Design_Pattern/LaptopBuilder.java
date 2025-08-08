package Methods_implementation.Builder_Design_Pattern;

public interface LaptopBuilder {
    LaptopBuilder buildMemory(int memory);
    LaptopBuilder buildStorage(int storage);
    LaptopBuilder buildProcessor(String processor);
    LaptopBuilder buildGraphicsCard(String graphicsCard);
    Laptop build();
}
