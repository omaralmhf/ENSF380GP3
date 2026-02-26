package edu.ucalgary.oop;

import java.time.LocalDate;

public class ReliefService {

    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private LocalDate dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;

    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, LocalDate inquiryDate, String infoProvided, Location lastKnownLocation) {
        if (inquirer == null || missingPerson == null || inquiryDate == null || infoProvided == null || lastKnownLocation == null) {
            throw new IllegalArgumentException("Constructor arguments cannot be null");
        }
        if (inquiryDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("inquiryDate cannot be in the future");
        }

        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = inquiryDate;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }

    public Inquirer getInquirer() {
        return inquirer;
    }

    public void setInquirer(Inquirer inquirer) {
        if (inquirer == null) {
            throw new IllegalArgumentException("inquirer cannot be null");
        }
        this.inquirer = inquirer;
    }

    public DisasterVictim getMissingPerson() {
        return missingPerson;
    }

    public void setMissingPerson(DisasterVictim missingPerson) {
        if (missingPerson == null) {
            throw new IllegalArgumentException("missingPerson cannot be null");
        }
        this.missingPerson = missingPerson;
    }

    public LocalDate getDateOfInquiry() {
        return dateOfInquiry;
    }

    public void setDateOfInquiry(LocalDate inquiryDate) {
        if (inquiryDate == null) {
            throw new IllegalArgumentException("inquiryDate cannot be null");
        }
        if (inquiryDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("inquiryDate cannot be in the future");
        }
        this.dateOfInquiry = inquiryDate;
    }

    public String getInfoProvided() {
        return infoProvided;
    }

    public void setInfoProvided(String info) {
        if (info == null) {
            throw new IllegalArgumentException("info cannot be null");
        }
        this.infoProvided = info;
    }

    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(Location lastKnownLocation) {
        if (lastKnownLocation == null) {
            throw new IllegalArgumentException("lastKnownLocation cannot be null");
        }
        this.lastKnownLocation = lastKnownLocation;
    }

    public String getLogDetails() {
        String inquirerName = inquirer.getFirstName();
        String missingName = missingPerson.getFirstName();
        String locationName = lastKnownLocation.getName();

        return "Inquirer: " + inquirerName
                + ", Missing Person: " + missingName
                + ", Date of Inquiry: " + dateOfInquiry
                + ", Info Provided: " + infoProvided
                + ", Last Known Location: " + locationName;
    }
}