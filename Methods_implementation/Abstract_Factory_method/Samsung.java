package Methods_implementation.Abstract_Factory_method;

public class Samsung {
    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("galaxyS25")) {
            return new Mobile("Here is your Samsung Galaxy S25");
        } else if (model.equalsIgnoreCase("galaxyS25Ultra")) {
            return new Mobile("Here is your Samsung Galaxy S25 Ultra");
        }
        return new NoMobile();
    }
}
