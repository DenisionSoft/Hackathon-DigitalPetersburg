package spb.hack.lifeindex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class House {
    private Long buildingId;
    private String address;
    private District district;
    private GeoPoint geoPoint;
}
