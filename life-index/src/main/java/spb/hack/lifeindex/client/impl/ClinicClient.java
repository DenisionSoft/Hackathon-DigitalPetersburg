package spb.hack.lifeindex.client.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.ApiClient;
import spb.hack.lifeindex.client.ProxyClient;
import spb.hack.lifeindex.model.District;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.House;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.impl.GeocoderDto;
import spb.hack.lifeindex.model.response.GeocoderResponse;

@Service
@AllArgsConstructor
public class ClinicClient implements ApiClient {

    private final ProxyClient proxyClient;
    private static final String BASE_URL = "https://spb-classif.gate.petersburg.ru/api/v2/datasets/149/versions/latest/data/327";

    @Override
    public GeocoderDto getDto(RequestParamsDto requestParamsDto) {
        /*
        // подготовка урла
        String endpoint = "";
        String paramPage = "page=
        String url = BASE_URL + endpoint + paramStreet;
        // запрос к прокси клиенту
        GeocoderResponse geocoderResponse = proxyClient.get(url, GeocoderResponse.class);
        // обработка респонса в дто
        District district = new District(geocoderResponse.districtName, geocoderResponse.districtId);
        GeoPoint geoPoint = new GeoPoint(geocoderResponse.latitude, geocoderResponse.longitude);
        House house = new House(geocoderResponse.buildingId, geocoderResponse.address, district, geoPoint);

        GeocoderDto geocoderDto = new GeocoderDto();
        geocoderDto.setDistrict(district);
        geocoderDto.setGeoPoint(geoPoint);
        geocoderDto.setHouse(house);
        // возврат дто
        return geocoderDto;

         */
        return null;
    }
}
