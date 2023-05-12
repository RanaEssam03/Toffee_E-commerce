package User;

public class BuildingInfo {
    String floor;
    String flat;
    private String number;

    public BuildingInfo(String number, String floor, String flat) {
        this.number = number;
        this.floor = floor;
        this.flat = flat;
    }

    /**
     * BuildingInfo constructor that takes the number of the building,
     *
     * @return number of the building
     */
    public String getNumber() {

        return number;
    }

    /**
     * Setter for number
     *
     * @param number : number of the building
     */
    public void setNumber(String number) {

        this.number = number;
    }

    /**
     * Getter for floor
     *
     * @return floor of the building
     */
    public String getFloor() {

        return floor;
    }

    /**
     * Setter for floor of the building
     *
     * @param floor : floor of the building
     */
    public void setFloor(String floor) {

        this.floor = floor;
    }

    /**
     * Getter for flat
     *
     * @return flat of the building
     */
    public String getFlat() {
        return flat;
    }

    /**
     * Setter for flat of the building
     *
     * @param flat : flat of the building
     */
    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String toString() {
        return "Building Number: " + number + " Floor: " + floor + " Flat: " + flat;
    }
}


