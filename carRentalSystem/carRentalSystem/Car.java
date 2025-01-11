package carRentalSystem.carRentalSystem;

public class Car {
    private String make;
    private String model;
    private String year;
    private String licensePlateNumber;
    private Double pricePerDay;
    private boolean isAvailable;

    public Car(String make, String model, String year, String licensePlateNumber, Double pricePerDay) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlateNumber = licensePlateNumber;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }
    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
    public Double getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
