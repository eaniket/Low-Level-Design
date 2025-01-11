package carRentalSystem.carRentalSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Reservation {
    private final String reservationId;
    private final Car car;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Customer customer;
    private final Double totalPrice;

    public String getReservationId() {
        return reservationId;
    }

    public Car getCar() {
        return car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Reservation(String reservationId, Car car, LocalDate startDate, LocalDate endDate, Customer customer) {
        this.reservationId = reservationId;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.totalPrice = calculateTotalPrice();
    }

    private Double calculateTotalPrice(){
        long daysRented = ChronoUnit.DAYS.between(endDate, startDate) + 1;
        return daysRented*car.getPricePerDay();
    }
}
