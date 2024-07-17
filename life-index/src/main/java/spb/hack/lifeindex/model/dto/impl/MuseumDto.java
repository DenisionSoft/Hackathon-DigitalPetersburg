package spb.hack.lifeindex.model.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.dto.ApiDto;
import spb.hack.lifeindex.util.Pair;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuseumDto extends ApiDto {
    private Integer count;
    private ArrayList<Pair<GeoPoint, District>> results;
}
