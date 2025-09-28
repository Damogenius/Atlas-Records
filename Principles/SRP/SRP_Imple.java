package Principles.SRP;

public class SRP_Imple {
    public static void main(String[] args) {
        Customer cobj = new Customer("Damo", "C001");
        ManagingFiles mobj = new ManagingFiles();
        mobj.saveData(cobj);
    }
}
