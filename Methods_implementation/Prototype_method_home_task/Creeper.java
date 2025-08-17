package Methods_implementation.Prototype_method_home_task;

public class Creeper implements Plant {
    private String growthType;

    public Creeper(String growthType) {
        this.growthType = growthType;
    }

    @Override
    public void grow() {
        System.out.println("Creeper is spreading with type: " + growthType);
    }

    @Override
    public String getGrowthType() {
        return growthType;
    }

    @Override
    public void setGrowthType(String growthType) {
        this.growthType = growthType;
    }

    @Override
    public Plant clone() {
        return new Creeper(this.growthType);
    }
}
