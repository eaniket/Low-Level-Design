package carRentalSystem.carRentalSystem;

public class Customer {
    private final String name;
    private String contactInfo;
    private final String licenseNumber;

    public Customer(String name, String contactInfo, String licenceNumber){
        this.name = name;
        this.contactInfo = contactInfo;
        this.licenseNumber = licenceNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
