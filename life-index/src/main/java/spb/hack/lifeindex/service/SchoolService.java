package spb.hack.lifeindex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spb.hack.lifeindex.client.impl.SchoolClient;
import spb.hack.lifeindex.model.dto.RequestParamsDto;
import spb.hack.lifeindex.model.dto.impl.SchoolDto;

import java.util.concurrent.Callable;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolClient sClient;

    public Callable<Double> getAllData(RequestParamsDto requestParamsDto) {
        return clinicClient.getDto(requestParamsDto);
    }
}

