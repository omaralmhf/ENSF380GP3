package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.Period;

public class DisasterVictim {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private FamilyRelation[] familyConnections;
    private MedicalRecord[] medicalRecords;
    private Supply[] personalBelongings;
    private final LocalDate ENTRY_DATE;
    private String gender;
    private String comments;

    public DisasterVictim(String firstName, LocalDate entryDate) {
        if (firstName == null || entryDate == null) {
            throw new IllegalArgumentException("firstName and entryDate cannot be null");
        }
        this.firstName = firstName;
        this.ENTRY_DATE = entryDate;
        this.familyConnections = new FamilyRelation[0];
        this.medicalRecords = new MedicalRecord[0];
        this.personalBelongings = new Supply[0];
    }

    public DisasterVictim(String firstName, LocalDate entryDate, LocalDate dateOfBirth) {
        if (firstName == null || entryDate == null) {
            throw new IllegalArgumentException("firstName and entryDate cannot be null");
        }
        this.firstName = firstName;
        this.ENTRY_DATE = entryDate;
        this.familyConnections = new FamilyRelation[0];
        this.medicalRecords = new MedicalRecord[0];
        this.personalBelongings = new Supply[0];
        setDateOfBirth(dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName cannot be null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName cannot be null");
        }
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("dateOfBirth cannot be null");
        }
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("dateOfBirth cannot be in the future");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public FamilyRelation[] getFamilyConnections() {
        return familyConnections;
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords;
    }

    public Supply[] getPersonalBelongings() {
        return personalBelongings;
    }

    public void setFamilyConnections(FamilyRelation[] connections) {
        if (connections == null) {
            throw new IllegalArgumentException("connections cannot be null");
        }
        this.familyConnections = connections;
    }

    public void setMedicalRecords(MedicalRecord[] records) {
        if (records == null) {
            throw new IllegalArgumentException("records cannot be null");
        }
        this.medicalRecords = records;
    }

    public void setPersonalBelongings(Supply[] supplies) {
        if (supplies == null) {
            throw new IllegalArgumentException("supplies cannot be null");
        }
        this.personalBelongings = supplies;
    }

    public void addPersonalBelonging(Supply belonging) {
        if (belonging == null) {
            throw new IllegalArgumentException("belonging cannot be null");
        }

        Supply[] newArr = new Supply[this.personalBelongings.length + 1];
        for (int i = 0; i < this.personalBelongings.length; i++) {
            newArr[i] = this.personalBelongings[i];
        }
        newArr[newArr.length - 1] = belonging;
        this.personalBelongings = newArr;
    }

    public void removePersonalBelonging(Supply belonging) {
        if (belonging == null) {
            throw new IllegalArgumentException("belonging cannot be null");
        }

        int idx = -1;
        for (int i = 0; i < this.personalBelongings.length; i++) {
            if (this.personalBelongings[i] == belonging) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            throw new IllegalArgumentException("Belonging not found");
        }

        Supply[] newArr = new Supply[this.personalBelongings.length - 1];
        int j = 0;
        for (int i = 0; i < this.personalBelongings.length; i++) {
            if (i == idx) {
                continue;
            }
            newArr[j++] = this.personalBelongings[i];
        }
        this.personalBelongings = newArr;
    }

    public void addFamilyConnection(FamilyRelation connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection cannot be null");
        }

        FamilyRelation[] newArr = new FamilyRelation[this.familyConnections.length + 1];
        for (int i = 0; i < this.familyConnections.length; i++) {
            newArr[i] = this.familyConnections[i];
        }
        newArr[newArr.length - 1] = connection;
        this.familyConnections = newArr;
    }

    public void removeFamilyConnection(FamilyRelation connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection cannot be null");
        }

        int idx = -1;
        for (int i = 0; i < this.familyConnections.length; i++) {
            if (this.familyConnections[i] == connection) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            throw new IllegalArgumentException("Family connection not found");
        }

        FamilyRelation[] newArr = new FamilyRelation[this.familyConnections.length - 1];
        int j = 0;
        for (int i = 0; i < this.familyConnections.length; i++) {
            if (i == idx) {
                continue;
            }
            newArr[j++] = this.familyConnections[i];
        }
        this.familyConnections = newArr;
    }

    public void addMedicalRecord(MedicalRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("record cannot be null");
        }

        MedicalRecord[] newArr = new MedicalRecord[this.medicalRecords.length + 1];
        for (int i = 0; i < this.medicalRecords.length; i++) {
            newArr[i] = this.medicalRecords[i];
        }
        newArr[newArr.length - 1] = record;
        this.medicalRecords = newArr;
    }

    public LocalDate getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        if (comments == null) {
            throw new IllegalArgumentException("comments cannot be null");
        }
        this.comments = comments;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String genderInput) {
        if (genderInput == null) {
            throw new IllegalArgumentException("gender cannot be null");
        }

        if (genderInput.trim().equalsIgnoreCase("please specify")) {
            this.gender = "Please specify";
            return;
        }

        if (this.gender != null && this.gender.trim().equalsIgnoreCase("please specify")) {
            this.gender = genderInput;
            return;
        }

        String newGender = null;
        if (genderInput.trim().equalsIgnoreCase("man")) {
            newGender = "Man";
        } else if (genderInput.trim().equalsIgnoreCase("woman")) {
            newGender = "Woman";
        } else if (genderInput.trim().equalsIgnoreCase("boy")) {
            newGender = "Boy";
        } else if (genderInput.trim().equalsIgnoreCase("girl")) {
            newGender = "Girl";
        } else {
            throw new IllegalArgumentException("Invalid gender option");
        }

        if (this.dateOfBirth == null) {
            throw new IllegalArgumentException("dateOfBirth required for standard gender options");
        }

        boolean adult = Period.between(this.dateOfBirth, LocalDate.now()).getYears() >= 18;

        if ((newGender.equals("Man") || newGender.equals("Woman")) && !adult) {
            throw new IllegalArgumentException("Man/Woman only valid for adults (18+)");
        }
        if ((newGender.equals("Boy") || newGender.equals("Girl")) && adult) {
            throw new IllegalArgumentException("Boy/Girl only valid for children (<18)");
        }

        this.gender = newGender;
    }
}