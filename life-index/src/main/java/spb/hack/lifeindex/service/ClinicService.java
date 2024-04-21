package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.impl.ClinicClient;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.impl.ClinicDto;

@Service
@RequiredArgsConstructor
public class ClinicService {

    private final ClinicClient clinicClient;

    public ClinicDto getAllData(RequestParamsDto requestParamsDto) {
        return clinicClient.getDto(requestParamsDto);
    }
}
