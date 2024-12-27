package parkingLot.VehicleType;

public class Vehicle {
    private String licensePlateNumber;
    private VehicleType vehicleType;

    public Vehicle(String licensePlateNumber, VehicleType type){
        this.licensePlateNumber = licensePlateNumber;
        this.vehicleType = type;
    }

    public VehicleType getType(){
        return vehicleType;
    }
}
