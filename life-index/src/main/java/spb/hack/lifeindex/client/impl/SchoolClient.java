package spb.hack.lifeindex.client.impl;

import lombok.AllArgsConstructor;
import spb.hack.lifeindex.util.Pair;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.ApiClient;
import spb.hack.lifeindex.client.ProxyClient;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.House;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.impl.SchoolDto;
import spb.hack.lifeindex.model.dto.impl.GeocoderDto;
import spb.hack.lifeindex.model.dto.support.SchoolResults;
import spb.hack.lifeindex.model.response.SchoolResponse;
import spb.hack.lifeindex.model.response.GeocoderResponse;
import spb.hack.lifeindex.service.GeocoderService;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class SchoolClient implements ApiClient {

    private final ProxyClient proxyClient;
    private final GeocoderService geocoderService;
    private static final String BASE_URL = "https://obr.gate.petersburg.ru";

    @Override
    public SchoolDto getDto(RequestParamsDto requestParamsDto) {
        // подготовка урла
        String endpoint = "?";
        String districtId = "id=" + requestParamsDto.getHouse().getDistrict().getId();
        String url = BASE_URL + endpoint + districtId;
        // запрос к прокси клиенту
        SchoolResponse schoolResponse = proxyClient.get(url, SchoolResponse.class);
        // get coords
        ArrayList<GeocoderDto> geoData = new ArrayList<>();
        for (SchoolResults result : schoolResponse.getResults()) {
            RequestParamsDto requestParamsDto1 = new RequestParamsDto();
            requestParamsDto1.setAddress(result.address);
            geoData.add(geocoderService.getAllData(requestParamsDto1));
        }
        // обработка респонса в дто
        ArrayList<Pair<GeoPoint, District>> results = new ArrayList<>();
        Integer count = schoolResponse.getResults().size();
        for (GeocoderDto geocoderDto : geoData) {
            results.add(new Pair<>(geocoderDto.getGeoPoint(), geocoderDto.getDistrict()));
        }

        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setCount(count);
        schoolDto.setResults(results);
        // возврат дто
        return schoolDto;
    }
}
