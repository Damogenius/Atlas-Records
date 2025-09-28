package Methods_implementation.Facade;

public class BillingCounterService {
    public void payBill(String accountId, String billId, double amount) {
        System.out.println("paying for Mangoes "+ amount +"for billId "+ billId + "from account" +accountId);
    }
}
