package User;

public class Address {
    String governorate;
    String landMark;
    private String street;
    private String district;
    private BuildingInfo buildingInfo;

    public Address(String street, String district, BuildingInfo buildingInfo, String governorate, String landMark) {
        this.street = street;
        this.district = district;
        this.buildingInfo = buildingInfo;
        this.governorate = governorate;
        this.landMark = landMark;
    }

    public Address(String street, String city) {
        this.street = street;
        this.district = city;
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

    // Getters
    public String getStreet() {
        return street;
    }

    // Setters
    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


}
