package carRentalSystem.carRentalSystem.Payment;

import carRentalSystem.carRentalSystem.PaymentStatus;

public interface PaymentProcessor {
    public PaymentStatus processPayment(Double amount);
}
