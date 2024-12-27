package parkingLot;
import java.util.List;
import java.util.ArrayList;
import parkingLot.VehicleType.Vehicle;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> levels;

    private ParkingLot(){
        levels = new ArrayList<>();
    }

    static synchronized ParkingLot getInstance(){
        if(instance == null)
            instance = new ParkingLot();
        return instance;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Level level: levels){
            if(level.parkVehicle(vehicle))
                return true;
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for(Level level: levels){
            if(level.unparkVehicle(vehicle))
                return true;
        }
        return false;
    }

    public void displayAvailiabilty(){
        for(Level level: levels){
            level.displayAvailiabilty();
        }
    }

}
