package spb.hack.lifeindex.client.impl;

import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.ApiClient;
import spb.hack.lifeindex.client.ProxyClient;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.House;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.impl.SchoolDto;
import spb.hack.lifeindex.model.dto.impl.GeocoderDto;
import spb.hack.lifeindex.model.response.SchoolResponse;
import spb.hack.lifeindex.model.response.ShoolResponse;
import spb.hack.lifeindex.model.response.GeocoderResponse;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class SchoolClient implements ApiClient {

    private final ProxyClient proxyClient;
    private static final String BASE_URL = "https://obr.gate.petersburg.ru";

    @Override
    public SchoolDto getDto(RequestParamsDto requestParamsDto) {
        // подготовка урла
        String endpoint = "?";
        String districtId = "id=" + requestParamsDto.getHouse().getDistrict().getId();
        String url = BASE_URL + endpoint + districtId;
        // запрос к прокси клиенту
        SchoolResponse schoolResponse = proxyClient.get(url, SchoolResponse.class);
        // обработка респонса в дто
        Integer count = schoolResponse.getResults().size();
        ArrayList<Pair<GeoPoint, District>> results = new ArrayList<>();
        schoolResponse.getResults().forEach(result -> {
            results.add(new Pair<>(new GeoPoint(result.getCoordinates().get(0), result.getCoordinates().get(1)), new District(result.getDistrict())));
        });
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setCount(count);
        schoolDto.setResults(results);
        // возврат дто
        return schoolDto;
    }
}
