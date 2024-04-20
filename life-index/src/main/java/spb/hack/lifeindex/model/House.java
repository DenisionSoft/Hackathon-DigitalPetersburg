package spb.hack.lifeindex.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class House {
    private Long id;
    private String address;
    private District district;
    private GeoPoint geoPoint;
}
