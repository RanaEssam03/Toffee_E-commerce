package User;

public class BuildingInfo {
    private int number;
    int floor;
    int flat;

    /**
     * BuildingInfo constructor that takes the number of the building,
     * @return number of the building
     */
    public int getNumber() {
        return number;
    }

    /**
     * Setter for number
     * @param number : number of the building
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     * Getter for floor
     * @return floor of the building
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Setter for floor of the building
     * @param floor : floor of the building
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }
}

