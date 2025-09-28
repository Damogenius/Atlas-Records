package Principles.OCP;

public class NotificationDriver {
    public static void main(String[] args) {
        OTPNotification emailOTP = new EmailNotify();
        emailOTP.sendOTP();

        TransactionNotification mobileTxn = new MobileNotify();
        mobileTxn.sendTransactionNotification();

        OTPNotification whatsappOTP = new WhatsappNotify();
        whatsappOTP.sendOTP();
    }
}

