package spb.hack.lifeindex.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GeoPoint {
    private final double lat;
    private final double lon;
}
