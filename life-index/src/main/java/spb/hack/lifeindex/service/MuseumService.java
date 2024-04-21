package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.impl.MuseumClient;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.ResponseDataDto;
import spb.hack.lifeindex.model.dto.impl.MuseumDto;

@Service
@RequiredArgsConstructor
public class MuseumService {

    private final MuseumClient museumClient;

    public ResponseDataDto getAllData(RequestParamsDto requestParamsDto) {
        MuseumDto museumDto = museumClient.getDto(requestParamsDto);
        ResponseDataDto responseDataDto = new ResponseDataDto();
        responseDataDto.setCount(museumDto.getCount());
        responseDataDto.setGeoData(museumDto.getResults());
        return responseDataDto;
    }
}
