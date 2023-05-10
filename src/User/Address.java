package User;

public class Address {
        private String street;
        private String district;

        private BuildingInfo buildingInfo;

        String governorate;
        String landMark;

    public Address(String street, String district, BuildingInfo buildingInfo, String governorate, String landMark) {
        this.street = street;
        this.district = district;
        this.buildingInfo = buildingInfo;
        this.governorate = governorate;
        this.landMark = landMark;
    }

    public BuildingInfo getBuildingInfo() {
        return buildingInfo;
    }

    public void setBuildingInfo(BuildingInfo buildingInfo) {
        this.buildingInfo = buildingInfo;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public Address(String street, String city) {
            this.street = street;
            this.district = city;
        }

        // Setters
        public void setStreet(String street) {
            this.street = street;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

       // Getters
       public String getStreet() {
        return street;
       }

       public String getDistrict() {
       return district;
       }


}
