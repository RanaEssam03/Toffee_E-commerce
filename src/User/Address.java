package User;

public class Address {
    /**
     * This String represents the street of the user
     */
        private String street;

        /**
         * This String represents the district of the user
         */
        private String district;
    /**
     * This BuildingInfo represents the building info of the user
     */
        private BuildingInfo buildingInfo;
        /**
         * This String represents the governorate of the user
         */

        String governorate;
        /**
         * This String represents the landmark of the user
         */
        String landMark;

    /**
     * Address constructor that takes the street, district, governorate and building info of the user
     * @param street : String represents the street of the user
     * @param district: String represents the district of the user
     * @param governorate : String represents the governorate of the user
     * @param buildingInfo: BuildingInfo represents the building info of the user
     */
    public Address(String street, String district, String governorate,BuildingInfo buildingInfo ) {
        this.street = street;
        this.district = district;
        this.buildingInfo = buildingInfo;
        this.governorate = governorate;
    }

    /**
     * buildingInfo getter
     * @return buildingInfo : BuildingInfo represents the building info of the user
     */
    public BuildingInfo getBuildingInfo() {
        return buildingInfo;
    }

    /**
     * buildingInfo setter
     * @param buildingInfo : BuildingInfo represents the building info of the user
     */
    public void setBuildingInfo(BuildingInfo buildingInfo) {
        this.buildingInfo = buildingInfo;
    }

    /**
     * governorate getter
     * @return governorate : String represents the governorate of the user
     */
    public String getGovernorate() {
        return governorate;
    }

    /**
     * governorate setter
     * @param governorate : String represents the governorate of the user
     */
    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    /**
     * landMark getter
     * @return landMark : String represents the landmark of the user
     */
    public String getLandMark() {
        return landMark;
    }

    /**
     * landMark setter
     * @param landMark : String represents the landmark of the user
     */
    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    /**
     * Address constructor that takes the street and district of the user
     * @param street : String represents the street of the user
     * @param city : String represents the district of the user
     */
    public Address(String street, String city) {
            this.street = street;
            this.district = city;
        }


    /**
     * street setter
     * @param street : String represents the street of the user
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * street getter
     * @param district : String represents the district of the user
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * street getter
     * @return street : String represents the street of the user
     */
   // Getters
   public String getStreet() {
    return street;
   }

    /**
     * district getter
     * @return district : String represents the district of the user
     */
   public String getDistrict() {
   return district;
   }

    /**
     * toString method that returns the address of the user
     * @return String that represents the address of the user
     */
   public String toString() {
       return "Street: " + street + "\nDistrict: " + district + "\nGovernorate: " + governorate + "\nBuilding Info: " + buildingInfo.toString();
   }

}
