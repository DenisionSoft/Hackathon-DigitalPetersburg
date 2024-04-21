package spb.hack.lifeindex.model.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.House;
import spb.hack.lifeindex.model.dto.ApiDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeocoderDto extends ApiDto {
    private District district;
    private GeoPoint geoPoint;
    private House house;
}
