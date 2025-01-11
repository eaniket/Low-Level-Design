package carRentalSystem.carRentalSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import carRentalSystem.carRentalSystem.Payment.CreditCardProcessor;
import carRentalSystem.carRentalSystem.Payment.PaymentProcessor;

public class CarRentalSystem {
    private static CarRentalSystem instance;
    private Map<String, Car> cars;
    private Map<String, Reservation> reservations;
    private PaymentProcessor paymentProcessor; 

    private CarRentalSystem(){
        cars = new HashMap<>();
        reservations = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardProcessor();
    }

    public static synchronized CarRentalSystem getInstance(){
        if(instance == null){
            instance = new CarRentalSystem();
        }
        return instance;
    }

    public void addCar(Car car){
        cars.put(car.getLicensePlateNumber(), car);
    }

    public void removeCar(String licenseNumber){
        cars.computeIfPresent(licenseNumber, (key, value) -> {
            System.out.println("Car with plate number: "+licenseNumber + " is removed from the system!");
            return null; //returning null removes the car from the system
        });
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate){
        List<Car> result = new ArrayList<>();
        for(Car car: cars.values()){
            if(car.getMake().equalsIgnoreCase(make) 
            && car.getModel().equalsIgnoreCase(model)
            && isAvailable(startDate, endDate, car)){
                result.add(car);
            }
        }
        return result;
    }

    private boolean isAvailable(LocalDate startDate, LocalDate endDate, Car car){
        for(Reservation reservation: reservations.values()){
            if(reservation.getCar().equals(car)){
                if(startDate.isBefore(reservation.getEndDate()) || endDate.isAfter(reservation.getStartDate())){
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized Reservation makeReservation(Car car, LocalDate startDate, LocalDate endDate, Customer customer){
        if(isAvailable(startDate, endDate, car)){
            String reservationId = generateId();
            Reservation reservation = new Reservation(reservationId, car, startDate, endDate, customer);
            reservations.put(reservationId, reservation);
            car.setAvailable(false);
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId){
        if(reservations.containsKey(reservationId)){
            Reservation reservation = reservations.get(reservationId);
            reservation.getCar().setAvailable(true);
            reservations.remove(reservationId);
        }else{
            System.out.println("No reservation present");
        }
        
    }

    public PaymentStatus processPayment(Double totalPrice){
        return paymentProcessor.processPayment(totalPrice);
    }

    private String generateId(){
        return "RES_"+UUID.randomUUID().toString();
    }
}
