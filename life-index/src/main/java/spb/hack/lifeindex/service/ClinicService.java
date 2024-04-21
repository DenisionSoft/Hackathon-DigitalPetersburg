package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.impl.ClinicClient;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.ResponseDataDto;
import spb.hack.lifeindex.model.dto.impl.ClinicDto;

import java.util.concurrent.Callable;

@Service
@RequiredArgsConstructor
@Async
public class ClinicService {

    private final ClinicClient clinicClient;
    private final GlebService glebService;

    public ResponseDataDto getAllData(RequestParamsDto requestParamsDto) {
        ClinicDto clinicDto = clinicClient.getDto(requestParamsDto);
        ResponseDataDto responseDataDto = new ResponseDataDto();
        responseDataDto.setCount(clinicDto.getCount());
        responseDataDto.setGeoData(clinicDto.getResults());
        return responseDataDto;
    }
}
