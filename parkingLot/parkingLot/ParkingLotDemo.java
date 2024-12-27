package parkingLot;

import parkingLot.VehicleType.Vehicle;
import parkingLot.VehicleType.Car;
import parkingLot.VehicleType.Bike;
import parkingLot.VehicleType.Truck;

public class ParkingLotDemo {

    public static void main(String args[]){
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 80));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZW45");
        Vehicle bike = new Bike("PQ4567");
        //Park Vehicle
        try {
            parkingLot.parkVehicle(car);
            parkingLot.parkVehicle(truck);
            parkingLot.parkVehicle(bike);
        } catch (Exception e) {
            System.out.println("Error parking vehicle: " + e.getMessage());
        }

        // Display availability
        parkingLot.displayAvailiabilty();

        // Unpark Vehicle
        parkingLot.unparkVehicle(bike);

        // Display updated availability
        parkingLot.displayAvailiabilty();
    }

}