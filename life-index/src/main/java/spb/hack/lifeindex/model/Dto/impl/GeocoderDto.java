package spb.hack.lifeindex.model.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.House;
import spb.hack.lifeindex.model.dto.ApiDto;

@Data
@NoArgsConstructor
public class GeocoderDto implements ApiDto {
    private District district;
    private GeoPoint geoPoint;
    private House house;
    // убрать это
    @Override
    public String getTest() {
        return null;
    }

}
