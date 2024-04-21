package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.impl.OurPetersburgClient;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.ResponseDataDto;
import spb.hack.lifeindex.model.dto.impl.OurPetersburgDto;

@Service
@RequiredArgsConstructor
public class OurPetersburgService {

    private final OurPetersburgClient ourPetersburgClient;

    public ResponseDataDto getAllData(RequestParamsDto requestParamsDto) {
        OurPetersburgDto ourPetersburgDto = ourPetersburgClient.getDto(requestParamsDto);

        ResponseDataDto responseDataDto = new ResponseDataDto();
        responseDataDto.setCount(ourPetersburgDto.getCount());
        responseDataDto.setGeoPoints(ourPetersburgDto.getResults());
        responseDataDto.setArrayStringData(ourPetersburgDto.getAddressInfo());
        return responseDataDto;
    }
}
