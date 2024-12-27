package parkingLot;
import java.util.ArrayList;
import java.util.List;
import parkingLot.VehicleType.Vehicle;

public class Level {
    private final int floorLevel;
    private final List<Spot> spots;

    public Level(int floorLevel, int size){
        this.floorLevel = floorLevel;
        spots = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            spots.add(new Spot(i));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(Spot spot: spots){
            if(spot.isAvailable() && spot.getVehicleType() == vehicle.getType()){
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle){
        for(Spot spot: spots){
            if(!spot.isAvailable() && spot.getParkedVehcile().equals(vehicle)){
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailiabilty(){
        System.out.println("Level: " + floorLevel + " Availiability");
        for(Spot spot: spots){
            System.out.println("Spot" + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available" : "Not Available"));
        }
    }
}
