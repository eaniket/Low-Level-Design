package carRentalSystem.carRentalSystem.Payment;
import carRentalSystem.carRentalSystem.PaymentStatus;

public class CreditCardProcessor implements PaymentProcessor{

    @Override
    public PaymentStatus processPayment(Double amount) {
        //... add payment logic here
        System.out.println("Amount paid through credit card:" + amount);
        return PaymentStatus.SUCCESS;
    }
     
}
