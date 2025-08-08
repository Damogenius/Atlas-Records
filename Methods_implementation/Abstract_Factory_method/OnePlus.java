package Methods_implementation.Abstract_Factory_method;

public class OnePlus {
    public static Mobile getMobile(String model) {
        if (model.equalsIgnoreCase("oneplus13")) {
            return new Mobile("Here is your OnePlus 13");
        } else if (model.equalsIgnoreCase("oneplus13Pro")) {
            return new Mobile("Here is your OnePlus 13 Pro");
        }
        return new NoMobile();
    }
}


