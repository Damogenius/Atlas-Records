package Principles.OCP;

// Interface for sending OTP notifications
interface OTPNotification {
    void sendOTP();
}

// Interface for sending Transaction notifications
interface TransactionNotification {
    void sendTransactionNotification();
}

// Email Notification implements both or any needed interface
class EmailNotify implements OTPNotification, TransactionNotification {
    @Override
    public void sendOTP() {
        System.out.println("Email: OTP sent to your mail id");
    }
    @Override
    public void sendTransactionNotification() {
        System.out.println("Email: Transaction notification sent to your mail id");
    }
}

// Mobile Notification
class MobileNotify implements OTPNotification, TransactionNotification {
    @Override
    public void sendOTP() {
        System.out.println("Mobile: OTP sent to your Mobile no");
    }
    @Override
    public void sendTransactionNotification() {
        System.out.println("Mobile: Transaction notification sent to your Mobile no");
    }
}

// Whatsapp Notification
class WhatsappNotify implements OTPNotification, TransactionNotification {
    @Override
    public void sendOTP() {
        System.out.println("Whatsapp: OTP sent to your whatsapp");
    }
    @Override
    public void sendTransactionNotification() {
        System.out.println("Whatsapp: Transaction notification sent to your whatsapp");
    }
}

