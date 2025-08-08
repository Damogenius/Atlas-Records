package Methods_implementation.Builder_Design_Pattern;

public class LaptopConcreteBuilder implements LaptopBuilder {
    private Laptop laptop;
    public LaptopConcreteBuilder() {
        this.laptop = new Laptop();
    }
    @Override
    public LaptopBuilder buildMemory(int memory) {
        laptop.setMemory(memory);
        return this;
    }
    @Override
    public LaptopBuilder buildStorage(int storage) {
        laptop.setStorage(storage);
        return this;
    }
    @Override
    public LaptopBuilder buildProcessor(String processor) {
        laptop.setProcessor(processor);
        return this;
    }
    @Override
    public LaptopBuilder buildGraphicsCard(String graphicsCard) {
        laptop.setGraphicsCard(graphicsCard);
        return this;
    }
    @Override
    public Laptop build() {
        return this.laptop;
    }
}

