package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.impl.GeocoderClient;
import spb.hack.lifeindex.model.GeoPoint;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.impl.GeocoderDto;

@Service
@RequiredArgsConstructor
public class GeocoderService {

    private final GeocoderClient geocoderClient;

    public GeoPoint getGeoPoint(RequestParamsDto requestParamsDto) {
        GeocoderDto geocoderDto = geocoderClient.getDto(requestParamsDto);
        return new GeoPoint(geocoderDto.getGeoPoint().getLat(), geocoderDto.getGeoPoint().getLon());
    }

    public GeocoderDto getAllData(RequestParamsDto requestParamsDto) {
        return geocoderClient.getDto(requestParamsDto);
    }
}
