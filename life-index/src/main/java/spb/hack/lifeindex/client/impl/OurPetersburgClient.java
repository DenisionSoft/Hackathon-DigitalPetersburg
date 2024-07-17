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
import spb.hack.lifeindex.model.dto.impl.OurPetersburgDto;
import spb.hack.lifeindex.model.dto.impl.GeocoderDto;
import spb.hack.lifeindex.model.response.OurPetersburgResponse;
import spb.hack.lifeindex.model.response.GeocoderResponse;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class OurPetersburgClient implements ApiClient {

    private final ProxyClient proxyClient;
    private static final String BASE_URL = "https://our-spb.gate.petersburg.ru/our_spb/problems/by_buildings/";

    @Override
    public OurPetersburgDto getDto(RequestParamsDto requestParamsDto) {
        // подготовка урла
        String endpoint = "?";
        String buildingId = "building_ids=" + requestParamsDto.getHouse().getBuildingId();
        String paramPerPage = "&format=\"common\"&count_on_page=100";
        String url = BASE_URL + endpoint + buildingId + paramPerPage;
        // запрос к прокси клиенту
        OurPetersburgResponse ourPetersburgResponse = proxyClient.get(url, OurPetersburgResponse.class);
        // обработка респонса в дто
        System.out.println(ourPetersburgResponse.getResults());
        Integer count = ourPetersburgResponse.getResults().size();
        ArrayList<GeoPoint> results = new ArrayList<>();
        ArrayList<String> addressInfo = new ArrayList<>();
        ourPetersburgResponse.getResults().forEach(result -> {
            results.add(new GeoPoint(result.latitude, result.longitude));
        });
        ourPetersburgResponse.getResults().forEach(result -> {
            addressInfo.add(result.reason);
        });
        OurPetersburgDto ourPetersburgDto = new OurPetersburgDto();
        ourPetersburgDto.setCount(count);
        ourPetersburgDto.setResults(results);
        ourPetersburgDto.setAddressInfo(addressInfo);
        // возврат дто
        return ourPetersburgDto;
    }
}
