package spb.hack.lifeindex.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDataDto {
    // всевозможные данные, которые мы получаем от публичных апи
    private Integer count;
    private ArrayList<GeoPoint> geoPoints;
    private ArrayList<Pair<GeoPoint, District>> geoData;
    private Double distance;
    private Integer intData;
    private String stringData;
    private ArrayList<String> arrayStringData;
}
