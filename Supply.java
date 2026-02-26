public class Supply {
    private String type;
    private int quantity;

    // Constructor
    public Supply(String type, int quantity) {
        setType(type);
        setQuantity(quantity);
    }

    // Setters

    public void setType(String type) {
        if(type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        } else {
            this.type = type;

        }


    }
    public void setQuantity(int quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        } else {
            this.quantity = quantity;
        }

    }
    // Getters

    public String getType() {
        return this.type;
    }

    public int getQuantity() {
        return this.quantity;
    }

}
