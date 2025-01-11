package carRentalSystem.carRentalSystem.Payment;

import carRentalSystem.carRentalSystem.PaymentStatus;

public class ChequeProcessor implements PaymentProcessor{

    @Override
    public PaymentStatus processPayment(Double amount) {
        System.out.println("Amount paid through cheque: " + amount);
        return PaymentStatus.SUCCESS;
    }

}
