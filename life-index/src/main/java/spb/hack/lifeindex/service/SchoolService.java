package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.impl.SchoolClient;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.impl.SchoolDto;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final ClinicClient clinicClient;

    public SchoolDto getAllData(RequestParamsDto requestParamsDto) {
        return clinicClient.getDto(requestParamsDto);
    }
}
