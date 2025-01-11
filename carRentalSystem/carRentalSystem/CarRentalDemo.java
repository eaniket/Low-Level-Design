package carRentalSystem.carRentalSystem;

import java.time.LocalDate;
import java.util.List;

public class CarRentalDemo {
    public static void run(){
        CarRentalSystem system = CarRentalSystem.getInstance();

        system.addCar(new Car("Toyota", "Etios", "2015", "UX-524-4758", 30.0));
        system.addCar(new Car("BMW", "X7", "2019", "BY-329-8395", 50.0));
        system.addCar(new Car("Suzuki", "Breeza", "2023", "PU-436-9548", 45.0));

        Customer customer  = new Customer("John", "+1-645-9683", "RX3954208");

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(5);
        List<Car> availableCars = system.searchCars("BMW", "X7", startDate, endDate);
        if(!availableCars.isEmpty()){
            Reservation reservation = system.makeReservation(availableCars.get(0), startDate, endDate, customer);
            if(reservation != null){
                PaymentStatus paymentStatus = system.processPayment(reservation.getTotalPrice());
                if(paymentStatus.equals(PaymentStatus.SUCCESS)){
                    System.out.println("Payment successful, car is reserved!");
                }else if(paymentStatus.equals(PaymentStatus.FAILURE)){
                    System.out.println("Payment failure, reservation is cancelled! Please try again");
                    system.cancelReservation(reservation.getReservationId());
                }
            }else{
                System.out.println("Selected Car is not available in the given dates");
            }
        }else{
            System.out.println("No cars found with the given criteria!");
        }
    }
    public static void main(String[] args) {
        run();
    }
}
