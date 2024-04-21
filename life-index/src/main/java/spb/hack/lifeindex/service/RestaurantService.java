package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.impl.ClinicClient;
import spb.hack.lifeindex.client.impl.RestaurantClient;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.ResponseDataDto;
import spb.hack.lifeindex.model.dto.impl.ClinicDto;
import spb.hack.lifeindex.model.dto.impl.RestaurantDto;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantClient restaurantClient;

    public ResponseDataDto getAllData(RequestParamsDto requestParamsDto) {
        RestaurantDto restaurantDto = restaurantClient.getDto(requestParamsDto);
        ResponseDataDto responseDataDto = new ResponseDataDto();
        responseDataDto.setCount(restaurantDto.getCount());
        responseDataDto.setGeoPoints(restaurantDto.getCoordinates());
        return responseDataDto;
    }
}
