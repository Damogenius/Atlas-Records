package Methods_implementation.Abstract_Factory_method;

public class MobileStore {
    public static Mobile getMobile(String brand, String model) {
        if (brand.equalsIgnoreCase("Apple")) {
            System.out.println("Here are your Apple models:");
            return Apple.getMobile(model);
        } else if (brand.equalsIgnoreCase("Samsung")) {
            System.out.println("Here are your Samsung models:");
            return Samsung.getMobile(model);
        } else if (brand.equalsIgnoreCase("OnePlus")) {
            System.out.println("Here are your OnePlus models:");
            return OnePlus.getMobile(model);
        }

        return new NoMobile();
    }
}

