package Methods_implementation.Prototype_method_home_task;

public class Main {
    public static void main(String[] args) {
        Plant shrub1 = new Shrub("Compact");
        Plant shrub2 = shrub1.clone();

        shrub1.grow();
        shrub2.setGrowthType("Wide");
        shrub2.grow();

        Plant creeper1 = new Creeper("Ground");
        Plant creeper2 = creeper1.clone();

        creeper1.grow();
        creeper2.setGrowthType("Wall");
        creeper2.grow();
    }
}
