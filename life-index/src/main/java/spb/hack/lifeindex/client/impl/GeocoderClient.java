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
public class GeocoderClient implements ApiClient {

    private final ProxyClient proxyClient;
    private static final String BASE_URL = "https://geocode.gate.petersburg.ru";

    @Override
    public GeocoderDto getDto(RequestParamsDto requestParamsDto) {
        // подготовка урла
        String endpoint = "/parse/free?";
        String paramStreet = "street=" + requestParamsDto.getAddress();
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
    }
}
