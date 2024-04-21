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
import spb.hack.lifeindex.model.dto.impl.RestaurantDto;
import spb.hack.lifeindex.model.dto.impl.GeocoderDto;
import spb.hack.lifeindex.model.response.RestaurantResponse;
import spb.hack.lifeindex.model.response.GeocoderResponse;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class RestaurantClient implements ApiClient {

    private final ProxyClient proxyClient;
    private static final String BASE_URL = "https://spb-classif.gate.petersburg.ru/api/v2/datasets/143/versions/latest/data/570/";

    @Override
    public RestaurantDto getDto(RequestParamsDto requestParamsDto) {
        // подготовка урла
        String endpoint = "?";
        String paramPage = "page=" + requestParamsDto.getPage();
        String paramPerPage = "&per_page=100";
        String url = BASE_URL + endpoint + paramPage + paramPerPage;
        // запрос к прокси клиенту
        RestaurantResponse restaurantResponse = proxyClient.get(url, RestaurantResponse.class);
        // обработка респонса в дто
        Integer count = restaurantResponse.getResults().size();
        ArrayList<GeoPoint> results = new ArrayList<>();
        restaurantResponse.getResults().forEach(result -> {
            results.add(new GeoPoint(result.coordinates.getFirst(), result.coordinates.getLast()));
        });
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setCount(count);
        restaurantDto.setCoordinates(results);
        // возврат дто
        return restaurantDto;
    }
}
