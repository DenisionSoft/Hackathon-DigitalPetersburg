package spb.hack.lifeindex.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class GeocoderResponse {

    @JsonProperty("Building_ID")
    public Long buildingId;

    @JsonProperty("Name")
    public String address;

    @JsonProperty("District_ID")
    public Long districtId;

    @JsonProperty("District")
    public String districtName;

    @JsonProperty("Longitude")
    public Double longitude;

    @JsonProperty("Latitude")
    public Double latitude;
}
