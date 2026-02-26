package edu.ucalgary.oop;
import java.util.ArrayList;
import java.util.Arrays;

public class Location {

    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    public Location(String locationName, String address) {
        if (locationName == null || address == null) {
            throw new IllegalArgumentException("Name and address cannot be null.");
        }
        this.name = locationName;
        this.address = address;
        this.occupants = new DisasterVictim[0];
        this.supplies = new Supply[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String locationName) {
        if (locationName == null) {
            throw new IllegalArgumentException("Location name cannot be null.");
        }
        this.name = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        this.address = address;
    }

    public DisasterVictim[] getOccupants() {
        return occupants;
    }

    public void setOccupants(DisasterVictim[] occupants) {
        if (occupants == null) {
            throw new IllegalArgumentException("Occupants cannot be null.");
        }
        this.occupants = occupants;
    }

    public Supply[] getSupplies() {
        return supplies;
    }

    public void setSupplies(Supply[] inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Supplies cannot be null.");
        }
        this.supplies = inventory;
    }

    public void addOccupant(DisasterVictim occupant) {
        if (occupant == null) {
            throw new IllegalArgumentException("Occupant cannot be null.");
        }
        occupants = Arrays.copyOf(occupants, occupants.length + 1);
        occupants[occupants.length - 1] = occupant;
    }

    public void removeOccupant(DisasterVictim occupant) {
        ArrayList<DisasterVictim> list = new ArrayList<>(Arrays.asList(occupants));
        list.remove(occupant);
        occupants = list.toArray(new DisasterVictim[0]);
    }

    public void addSupply(Supply inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Supply cannot be null.");
        }
        supplies = Arrays.copyOf(supplies, supplies.length + 1);
        supplies[supplies.length - 1] = inventory;
    }

    public void removeSupply(Supply inventory) {
        ArrayList<Supply> list = new ArrayList<>(Arrays.asList(supplies));
        list.remove(inventory);
        supplies = list.toArray(new Supply[0]);
    }
}