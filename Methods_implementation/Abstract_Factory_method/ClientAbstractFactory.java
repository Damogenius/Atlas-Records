package Methods_implementation.Abstract_Factory_method;

public class ClientAbstractFactory {
    public static void main(String[] args){
        Mobile m1 = MobileStore.getMobile("Apple", "iphone16");
        m1.getDesc();

        Mobile m2 = MobileStore.getMobile("Samsung", "galaxyS25Ultra");
        m2.getDesc();

        Mobile m3 = MobileStore.getMobile("OnePlus", "oneplus13");
        m3.getDesc();

        Mobile m4 = MobileStore.getMobile("Nokia", "3310"); // Invalid
        m4.getDesc();
    }
}
