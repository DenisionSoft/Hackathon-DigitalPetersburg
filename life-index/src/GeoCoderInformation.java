public class GeoInformation {
    public GeoInformation(int buildingID,  String district, String address, double longtitude, double latitude)
    {
        this.buildingID = buildingID;
        this.district = district;
        this.address = address;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }
    public String address;
    public int buildingID;
    public String district;
    public double longtitude;
    public double latitude;
}
