package edu.ucalgary.oop;
public class Inquirer {
    private final String FIRST_NAME;
    private final String LAST_NAME;
    private final String INFO;
    private final String SERVICES_PHONE;

    // Constructor
    public Inquirer(String firstName, String lastName, String phone, String info) {
        if(firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if(info == null || info.isEmpty()) {
            throw new IllegalArgumentException("Info cannot be null or empty");
        }
        if(phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }

        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.SERVICES_PHONE = phone;
        this.INFO = info;
    }

    // Getters
    public String getFirstName() {
        return FIRST_NAME;
    }
    public String getLastName() {
        return LAST_NAME;
    }
    public String getInfo() {
        return INFO;
    }
    public String getServicesPhoneNum() {
        return SERVICES_PHONE;
    }

}
