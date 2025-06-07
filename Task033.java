class Customer1{
    int cost = 40;
    String items = "Tomatoes";
    Customer1(){
        System.out.println("Constructor called");
    }
    void purchase_list(){
        System.out.println("cost of tomatoes in Customer class is "+ cost);
    }
}
public class Task033 extends Customer1 {

    void billing(){
        String items = "onions";
        int cost = 30;

        super.items = "Potatoes";
        super.cost = 50;
        super.purchase_list();

        System.out.println(items);
        System.out.println(cost);
        System.out.println("***************************");
        System.out.println(super.items);
        System.out.println(super.cost);
        // return 0;
    }
    public static void main(String[] args){
        Customer1 cobj =new Customer1();
        cobj.purchase_list();
        Task033 tobj = new Task033();
        tobj.billing();

    }

}
