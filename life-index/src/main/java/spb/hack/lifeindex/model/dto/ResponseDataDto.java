package spb.hack.lifeindex.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spb.hack.lifeindex.model.GeoPoint;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDataDto {
    // всевозможные данные, которые мы получаем от публичных апи
    private Long count;
    private ArrayList<GeoPoint> geoPoints;
    private Double distance;
    private Integer intData;
    private String stringData;

}
