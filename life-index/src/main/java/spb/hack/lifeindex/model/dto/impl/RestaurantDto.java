package spb.hack.lifeindex.model.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.dto.ApiDto;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto extends ApiDto {
    private Integer count;
    private ArrayList<GeoPoint> coordinates;
}
