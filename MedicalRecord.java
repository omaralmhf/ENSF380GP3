import java.time.LocalDate;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private LocalDate dateOfTreatment;

    // Constructor
    public MedicalRecord(Location location, String treatmentDetails, LocalDate dateOfTreatment) {
        setLocation(location);
        setTreatmentDetails(treatmentDetails);
        setDateOfTreatment(dateOfTreatment);
    }

    // Getters
    public Location getLocation() {
        return this.location;
    }
    public String getTreatmentDetails() {
        return this.treatmentDetails;
    }
    public LocalDate getDateOfTreatment() {
        return this.dateOfTreatment;
    }

    // Setters
    public void setLocation(Location location) {
        if(location == null) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        } else {
            this.location = location;
        }
    }
    
    public void setTreatmentDetails(String treatmentDetails) {
        if(treatmentDetails == null || treatmentDetails.isEmpty()) {
            throw new IllegalArgumentException("Treatment details cannot be null or empty");
        } else {
            this.treatmentDetails = treatmentDetails;
        }
    }

    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        if(dateOfTreatment == null) {
            throw new IllegalArgumentException("Date of treatment cannot be null");
        } if(dateOfTreatment.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of treatment cannot be in the future");
        } else {
            this.dateOfTreatment = dateOfTreatment;
        }

    }
    
}
