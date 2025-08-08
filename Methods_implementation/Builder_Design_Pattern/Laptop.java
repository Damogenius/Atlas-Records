package Methods_implementation.Builder_Design_Pattern;

public class Laptop {
    private int memory;
    private int storage;
    private String processor;
    private String graphicsCard;

    public Laptop() {}

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public String toString() {
        return "Laptop [Memory = " + memory + "GB, Storage = " + storage + "GB, Processor = " + processor + ", GraphicsCard = " + graphicsCard + "]";
    }
}
