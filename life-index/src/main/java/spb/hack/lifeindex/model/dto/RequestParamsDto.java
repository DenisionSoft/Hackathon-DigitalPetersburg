package spb.hack.lifeindex.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.House;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestParamsDto {
    // всевозможные данные, которые мы передаём в запросы
    private House house;
    private String address;
    private Integer radius;
    private String modifier;
    private Integer page;
}
