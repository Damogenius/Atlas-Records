package Methods_implementation.Abstract_Factory_method;

public class Mobile {
    String desc;

    public Mobile(String desc){
        this.desc = desc;
    }

    public void getDesc() {
        System.out.println(this.desc);
    }
}


