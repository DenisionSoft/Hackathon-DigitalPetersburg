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
import spb.hack.lifeindex.model.dto.impl.LibraryDto;
import spb.hack.lifeindex.model.dto.impl.GeocoderDto;
import spb.hack.lifeindex.model.response.LibraryResponse;
import spb.hack.lifeindex.model.response.GeocoderResponse;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class LibraryClient implements ApiClient {

    private final ProxyClient proxyClient;
    private static final String BASE_URL = "";

    @Override
    public LibraryDto getDto(RequestParamsDto requestParamsDto) {
        // подготовка урла
        String endpoint = "?";
        String paramPage = "page=" + requestParamsDto.getPage();
        String paramPerPage = "&per_page=100";
        String category = "&Category=ALL";
        String url = BASE_URL + endpoint + paramPage + paramPerPage;
        // запрос к прокси клиенту
        LibraryResponse libraryResponse = proxyClient.get(url, LibraryResponse.class);
        // обработка респонса в дто
        Integer count = libraryResponse.getResults().size();
        ArrayList<Pair<GeoPoint, District>> results = new ArrayList<>();
        libraryResponse.getResults().forEach(result -> {
            results.add(new Pair<>(new GeoPoint(result.getCoordinates().get(0), result.getCoordinates().get(1)), new District(result.getDistrict())));
        });
        LibraryDto libraryDto = new LibraryDto();
        libraryDto.setCount(count);
        libraryDto.setResults(results);
        // возврат дто
        return libraryDto;
    }
}
