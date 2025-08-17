package Methods_implementation.Prototype_method_home_task;

public class Shrub implements Plant {
    private String growthType;

    public Shrub(String growthType) {
        this.growthType = growthType;
    }

    @Override
    public void grow() {
        System.out.println("Shrub is growing with type: " + growthType);
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
        return new Shrub(this.growthType);
    }
}

