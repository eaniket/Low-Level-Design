package parkingLot;
import parkingLot.VehicleType.Vehicle;
import parkingLot.VehicleType.VehicleType;

public class Spot {
    private final int id;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public Spot(int id){
        this.id = id;
        vehicleType = VehicleType.CAR;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehcile(){
        return parkedVehicle;
    }

    public int getSpotNumber(){
        return id;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getType() == vehicleType){
            parkedVehicle = vehicle;
        }else{
            throw new IllegalArgumentException("Invalid vehicle type or occupied parking space");
        }
    }

    public void unparkVehicle(){
        parkedVehicle = null;
    }
    
}
