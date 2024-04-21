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
import spb.hack.lifeindex.model.dto.impl.MuseumDto;
import spb.hack.lifeindex.model.dto.impl.GeocoderDto;
import spb.hack.lifeindex.model.response.MuseumResponse;
import spb.hack.lifeindex.model.response.GeocoderResponse;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class RestaurantClient implements ApiClient {

    private final ProxyClient proxyClient;
    private static final String BASE_URL = "https://spb-classif.gate.petersburg.ru/api/v2/datasets/139/versions/latest/data/569/";

    @Override
    public MuseumDto getDto(RequestParamsDto requestParamsDto) {
        // подготовка урла
        String endpoint = "?";
        String paramPage = "page=" + requestParamsDto.getPage();
        String paramPerPage = "&per_page=100";
        String url = BASE_URL + endpoint + paramPage + paramPerPage;
        // запрос к прокси клиенту
        ResturantResponse museumResponse = proxyClient.get(url, RestaurantResponse.class);
        // обработка респонса в дто
        Integer count = museumResponse.getResults().size();
        ArrayList<Pair<GeoPoint, District>> results = new ArrayList<>();
        museumResponse.getResults().forEach(result -> {
            results.add(new Pair<>(new GeoPoint(result.getCoordinates().get(0), result.getCoordinates().get(1)), new District(result.getDistrict())));
        });
        MuseumDto museumDto = new MuseumDto();
        museumDto.setCount(count);
        museumDto.setResults(results);
        // возврат дто
        return museumDto;
    }
}
