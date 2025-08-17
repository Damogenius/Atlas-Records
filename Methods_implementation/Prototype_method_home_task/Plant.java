package Methods_implementation.Prototype_method_home_task;

public interface Plant extends Cloneable {
    void grow();
    String getGrowthType();
    void setGrowthType(String growthType);
    Plant clone();
}
